package com.green.boardver3.user;

import com.green.boardver3.user.model.UserInsDto;
import com.green.boardver3.user.model.UserLoginDto;
import com.green.boardver3.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//최대한 자바단에서 다 잡기

@Service
public class UserService {
    private final UserMapper mapper;
    private final CommonUtils commonUtils;

    @Autowired
    public UserService(UserMapper mapper, CommonUtils commonUtils) {
        this.mapper = mapper;
        this.commonUtils = commonUtils;
    }
    public int insUser(UserInsDto dto) {
        //성별 항상 대문자로 받기
        char gender = Character.toUpperCase(dto.getGender());
        // 성별로 m, f 가 아닌 다른게 들어왔을 때 -1날림
        if(!(gender == 'M' || gender == 'F')) {
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

    @PostMapping("/login")
    public int postLoginUser(@RequestBody UserLoginDto dto) {
        return 0;
    }

    public int login(UserLoginDto dto) {
        return 0;
    }

}
