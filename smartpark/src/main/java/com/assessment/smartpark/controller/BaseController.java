package com.assessment.smartpark.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.assessment.smartpark.model.dto.BaseResponseDto;
import com.assessment.smartpark.service.exceptions.BaseException;
import com.assessment.smartpark.service.exceptions.NoRollbackException;
import com.assessment.smartpark.service.util.HttpUtil;

public abstract class BaseController {
        
    
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoRollbackException.class)
    public ResponseEntity<?> handleBusinessRule(BaseException e) {

        return HttpUtil
                .generateErrorResponseEntity(new BaseResponseDto(e.getErrorCodeEnum(), e.getErrorParameters()));
    }
}
