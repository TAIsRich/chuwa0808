package com.example.enums;


public enum AppHttpCodeEnum {
    
    SUCCESS(0,"Successful operation"),
    NO_USER(100,"User does not exist"),
    NO_TRANSACTION(200, "There is no Transactions"),
    SERVER_ERROR(500,"Server internal error"),
    PARAM_INVALID1(501, "Responsebody Parameter format error"),
    PARAM_INVALID2(502, "Pathvariable Parameter format error"),
    PARAM_INVALID3(503, "RequestParam Parameter format error"),
    PARAM_INVALID4(504, "Parameter format error"),
    PARAM_REQUIRE(505,"Missing parameter");
    int code;
    String errorMessage;

    AppHttpCodeEnum(int code,String errorMessage){
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public int getCode(){
        return code;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

}
