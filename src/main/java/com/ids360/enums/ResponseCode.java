package com.ids360.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {
    SUCCESS(200, "Success", HttpStatus.OK),
    INVALID_CREDENTIALS(401, "Invalid credentials", HttpStatus.UNAUTHORIZED),
    USER_NOT_FOUND(504, "User not found with Email", HttpStatus.NOT_FOUND),
    ORGANIZATION_NOT_FOUND(404, "Organization not found", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR(500, "An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

    ResponseCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}