package com.assessment.smartpark.service.exceptions;

import java.util.List;

import com.assessment.smartpark.model.enums.ResponseCodeEnum;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -8513856971473330489L;

	private final ResponseCodeEnum errorCodeEnum;
	private final List<String> errorParameters;
	
	public BaseException(ResponseCodeEnum errorCodeEnum, List<String> errorParameters) {
		super(ResponseCodeEnum.generateErrorMessageWithParameters(errorCodeEnum, errorParameters));
		this.errorCodeEnum = errorCodeEnum;
		this.errorParameters = errorParameters;
	}
	
	public BaseException(Throwable ex, ResponseCodeEnum errorCodeEnum, List<String> errorParameters) {
		super(ResponseCodeEnum.generateErrorMessageWithParameters(errorCodeEnum, errorParameters), ex);
		this.errorCodeEnum = errorCodeEnum;
		this.errorParameters = errorParameters;
	}

	public List<String> getErrorParameters() {
		return errorParameters;
	}

	public ResponseCodeEnum getErrorCodeEnum() {
		return errorCodeEnum;
	}
}
