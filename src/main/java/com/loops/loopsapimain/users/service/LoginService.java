package com.loops.loopsapimain.users.service;


import com.loops.loopsapimain.common.APIResponse;
import com.loops.loopsapimain.users.dto.DTOUserLogin;
import com.loops.loopsapimain.users.entity.User;
import com.loops.loopsapimain.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;

    public APIResponse login(DTOUserLogin dtoUserLogin){

        APIResponse apiResponse = new APIResponse();


        User user = userRepository.findOneByUserEmailIgnoreCaseAndUserPassword(dtoUserLogin.getUserEmail(),dtoUserLogin.getUserPassword());

        if (user == null){
            apiResponse.setData("User Login Failed");
        }else {
            apiResponse.setData("User Login Success");
        }

        return apiResponse;


    }

}
