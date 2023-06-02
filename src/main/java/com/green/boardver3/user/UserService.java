package com.green.boardver3.user;

import com.green.boardver3.user.model.*;
import com.green.boardver3.utils.CommonUtils;
import com.green.boardver3.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//최대한 자바단에서 다 잡기

@Service
public class UserService {
    private final UserMapper mapper;
    private final CommonUtils commonUtils;


    @Value("${file.dir}")
    private String fileDir;

    @Autowired
    public UserService(UserMapper mapper, CommonUtils commonUtils) {
        this.mapper = mapper;
        this.commonUtils = commonUtils;
    }

    public int insUser(UserInsDto dto) {
        //성별 항상 대문자로 받기
        char gender = Character.toUpperCase(dto.getGender());
        // 성별로 m, f 가 아닌 다른게 들어왔을 때 -1날림
        if (!(gender == 'M' || gender == 'F')) {
            return -1;
        }
        dto.setGender(gender);

        //비밀번호 암호화
        String hashPw = commonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hashPw);
        //에러 터졌을 때 리턴값으로 0날림
        try {
            return mapper.insUser(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int login(UserLoginDto dto) {
        UserLoginVo vo = mapper.selUserByUid(dto);
        if (vo == null) {
            return 2;
        }

        String pw = commonUtils.encodeSha256(dto.getUpw());
        if (vo.getUpw().equals(pw)) {
            return 1;
        }
        return 3;
    }

    public int updUserPw(UserPatchPwDto dto) {
        String hashPw = commonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hashPw);
        return mapper.updUserPw(dto);
    }


    public int updUserPic(MultipartFile pic, UserPicDto dto) {
        // user/pk/uuid.jpg
        String dicPath = String.format("%s/user/%d"
                , fileDir, dto.getIuser());  //D://download/board3/user/1   // e.g. iuser=1 경우 D:download/board3/user/1

        File dic = new File(dicPath);
        if (!dic.exists()) {     //해당하는 폴더가 있는지 확인 가능
            dic.mkdirs();
        }

        String fileName = pic.getOriginalFilename();
        String randomFileNm = FileUtils.makeRandomFileNm(fileName);
        String filePath = dicPath+ "/" +randomFileNm;
//        String filePath = String.format("%s/%s",dicPath,randomFileNm);


        File file = new File(filePath);

        try {
            pic.transferTo(file);
            dto.setMainPic(randomFileNm);
            return mapper.updUserPic(dto);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;

    }

}















