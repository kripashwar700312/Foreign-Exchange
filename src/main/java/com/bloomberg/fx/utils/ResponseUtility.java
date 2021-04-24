package com.bloomberg.fx.utils;

import com.bloomberg.fx.response.Response;
import org.springframework.http.HttpStatus;

public class ResponseUtility {

    public static Response getCreatedResponse(String message) {
        return Response.builder()
                .message(message)
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    public static Response getFailedResponse(String message) {
        return Response.builder()
                .success(false)
                .message(message)
                .httpStatus(HttpStatus.NOT_ACCEPTABLE)
                .build();
    }

}
