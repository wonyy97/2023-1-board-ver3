package com.green.boardver3.user;

import com.green.boardver3.user.model.UserInsDto;
import com.green.boardver3.user.model.UserLoginDto;
import com.green.boardver3.user.model.UserPatchPwDto;
import com.green.boardver3.user.model.UserPicDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;


    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping
    @Operation(summary = "회원가입", description = "" +
    "uid: [20] 회원 아이디,<br>" +
    "upw: [100] 회원 비밀번호,<br>" +
    "nm: [30] 회원명,<br>" +
    "gender: [1] 성별(M: 남성, F: 여성),<br>" +
    "addr: [100] 대구시 달서구")
    public int postUser(@RequestBody UserInsDto dto) {
        return service.insUser(dto);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "" +
            "리턴값: " +
            "(1)로그인 성공,<br> " +
            "(2)아이디 없음,<br> " +
            "(3)비밀번호 다름")
    public int postLoginUser(@RequestBody UserLoginDto dto) {
        return service.login(dto);
    }

    @PatchMapping("/pw")
    public int patchUpdUserPw(@RequestBody UserPatchPwDto dto) {
        return service.updUserPw(dto);
    }



    @PatchMapping(name="/pic", consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
    public int patchPicUser(@RequestPart MultipartFile pic, @RequestParam int iuser) {
        UserPicDto dto = new UserPicDto();
        dto.setIuser(iuser);
        return service.updUserPic(pic,dto);
    }

}
