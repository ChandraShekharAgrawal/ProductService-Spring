package com.store.productService.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionDto {
    private HttpStatus errorcode;
    private String message;

    public ExceptionDto(HttpStatus errorcode, String message) {
        this.errorcode = errorcode;
        this.message = message;
    }
}
