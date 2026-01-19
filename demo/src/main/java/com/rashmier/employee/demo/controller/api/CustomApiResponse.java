package com.rashmier.employee.demo.controller.api;


public class CustomApiResponse<T> {

    private int code;
    private HttpStatus status;
    private String message;
    private T object;

    public CustomApiResponse(HttpStatus status, String message, T object) {
        this.code = status.value();
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getObject() {
        return object;
    }

}
