package com.ecust.appv1boatbackend.Exception;

public class LoginFailedException extends RuntimeException{
    public LoginFailedException() {
        super("用户登录失败");
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
