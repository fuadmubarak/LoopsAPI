package com.loops.loopsapimain.users.controller;

import com.loops.loopsapimain.common.APIResponse;
import com.loops.loopsapimain.exception.DataNotFoundException;
import com.loops.loopsapimain.users.dto.DTOUserLogin;
import com.loops.loopsapimain.users.entity.User;
import com.loops.loopsapimain.users.repository.UserRepository;
import com.loops.loopsapimain.users.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("loops/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginService loginService;


    //INI POST REQUEST UNTUK LOGIN KE APLIKASI BERHUBUNGAN SAMA DTO LOGIN DAN LOGIN SERVICE
    @PostMapping("/login")
    public ResponseEntity<APIResponse> getUserDataLogin(@Valid @RequestBody DTOUserLogin dtoUserLogin){

        APIResponse apiResponse = loginService.login(dtoUserLogin);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }


    //INI POST REQUEST UNTUK REGISTER ATAU DAFTAR AKUN KE DALAM APLIKASI
    @PostMapping("/register")
    public User userRegis(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") Long userId) throws DataNotFoundException {

        User user = userRepository.findById(userId)
                .orElseThrow(()->new DataNotFoundException("Employee Dengan NIP: "+userId+", Tidak Ditemukan"));

        return ResponseEntity.ok().body(user);

    }


    //INI GET REQUEST UNTUK NGAMBIL DATA EMAIL SIAPA YANG SEDANG LOGIN SAAT INI
    @GetMapping("/user/details/{email}")
    public List<User> getUserByEmail(@PathVariable(value = "email") String userEmail){

        return userRepository.findUserByUserEmail(userEmail);

    }


    //PUT REQUEST INI DIPAKAI UNTUK UPDATE DI PAGE AKUN SAMA TOPUP
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUserData(@PathVariable(value = "id") Long userId,@RequestBody @Valid User userDetails) throws DataNotFoundException {

        User user = userRepository.findById(userId)
            .orElseThrow(()->new DataNotFoundException("Employee Dengan NIP: "+userId+", Tidak Ditemukan"));

        user.setUserAddress(userDetails.getUserAddress());
        user.setUserBalance(userDetails.getUserBalance());
        user.setUserCity(userDetails.getUserCity());
        user.setUserPovince(userDetails.getUserPovince());
        user.setUserCountry(userDetails.getUserCountry());
        user.setUserPostCode(userDetails.getUserPostCode());



        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }


    //GET REQUEST INI TIDAK DIPAKAI DI APLIKASI HANYA UNTUK NGE CEK AJA DI POSTMANNYA
    @GetMapping("/user")
    public List<User> getUserData(){

        return userRepository.findAll();

    }



}
