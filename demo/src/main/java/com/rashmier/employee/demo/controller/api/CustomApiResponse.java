package com.rashmier.employee.demo.controller.api;

import org.springframework.http.HttpStatus;

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

    public static <T> CustomApiResponse<T> success(String message, T object) {
        return new CustomApiResponse<>(HttpStatus.OK, message, object);
    }

    public static <T> CustomApiResponse<T> created(String message, T object) {
        return new CustomApiResponse<>(HttpStatus.CREATED, message, object);
    }

    public static <T> CustomApiResponse<T> error(HttpStatus status, String message) {
        return new CustomApiResponse<>(status, message, null);
    }
}
