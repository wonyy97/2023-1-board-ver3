package com.green.boardver3.user;

import com.green.boardver3.user.model.UserEntity;
import com.green.boardver3.user.model.UserInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserMapper mapper;

    @Autowired
    public UserService(UserMapper mapper) {
        this.mapper = mapper;
    }
    public int insUser(UserInsDto dto) {
        return mapper.insUser(dto);
    }

}
