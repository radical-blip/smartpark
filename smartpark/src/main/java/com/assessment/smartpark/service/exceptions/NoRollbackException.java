package com.assessment.smartpark.service.exceptions;

import java.util.List;

import com.assessment.smartpark.model.enums.ResponseCodeEnum;

public class NoRollbackException extends BaseException{
    private static final long serialVersionUID = -332510208265909055L;
	
	public NoRollbackException(ResponseCodeEnum errorCode) {
		super(errorCode, null);
	}
	
	public NoRollbackException(ResponseCodeEnum errorCode, Throwable ex) {
		super(ex, errorCode, null);
	}

	public NoRollbackException(ResponseCodeEnum errorCode, List<String> errorParameters) {
		super(errorCode, errorParameters);
	}

	public NoRollbackException(ResponseCodeEnum errorCode, List<String> errorParameters, Throwable ex) {
		super(ex, errorCode, errorParameters);
	}
}
