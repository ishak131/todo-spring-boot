package com.asset.todo.controller.body;

import com.asset.todo.controller.interfaces.LoginRequestInterface;

public class LoginRequestBody implements LoginRequestInterface {
    public String password = null;
    public String email = null;
}

