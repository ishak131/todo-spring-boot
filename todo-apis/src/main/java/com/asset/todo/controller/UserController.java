package com.asset.todo.controller;

import com.asset.todo.controller.body.LoginRequestBody;
import com.asset.todo.controller.interfaces.LoginRequestInterface;
import com.asset.todo.model.UserModel;
import com.asset.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserModel> signup(@RequestBody UserModel userModel) {
        userService.signup(userModel);
        return ResponseEntity.ok(userModel);
    }

    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody LoginRequestBody loginRequest) {
        //  note : this part of code is only for login simulation but this is not the right way  to handle the login request
        UserModel user = userService.login(loginRequest.email, loginRequest.password);
        return ResponseEntity.ok(user);
    }


}
