package com.assessment.smartpark.service.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.assessment.smartpark.model.dto.BaseResponseDto;
import com.assessment.smartpark.model.enums.ResponseCodeEnum;

public final class HttpUtil {
    public static <T> ResponseEntity<T> generateCreatedResponseEntity(T t) {
		((BaseResponseDto) t).setResponseCode(ResponseCodeEnum.SUCCESS.getCode());
		return ResponseEntity.status(HttpStatus.CREATED).body(t);
	}

	public static <T> ResponseEntity<T> generateOKResponseEntity(T t) {
		((BaseResponseDto) t).setResponseCode(ResponseCodeEnum.SUCCESS.getCode());
		return ResponseEntity.status(HttpStatus.OK).body(t);
	}

	public static <T> ResponseEntity<T> generateErrorResponseEntity(T t) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(t);
	}
}
