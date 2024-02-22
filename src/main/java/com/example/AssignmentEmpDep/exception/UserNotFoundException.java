package com.example.AssignmentEmpDep.exception;

public class UserNotFoundException extends RuntimeException{


    private int errorCode;

    public UserNotFoundException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }


}
