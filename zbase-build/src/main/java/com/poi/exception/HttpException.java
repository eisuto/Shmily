package com.poi.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class HttpException extends RuntimeException{
    protected Integer code;
    protected String msg;
}
