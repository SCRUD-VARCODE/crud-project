package com.crudproject.base.exception;

import com.crudproject.base.code.BaseErrorCode;

public class ExceptionHandler extends BaseException {

    public ExceptionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}