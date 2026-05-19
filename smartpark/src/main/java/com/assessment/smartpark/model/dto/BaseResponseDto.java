package com.assessment.smartpark.model.dto;

import java.util.List;

import com.assessment.smartpark.model.enums.ResponseCodeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BaseResponseDto {
    private String responseCode;

	@JsonIgnore
	private List<String> errorParameters;
	
	private String message;
	
	public BaseResponseDto() {}
	
	public BaseResponseDto(String message) {
		super();
		this.message = message;
	}

	public BaseResponseDto(ResponseCodeEnum responseEnum) {
		super();
		this.responseCode = responseEnum.getCode();
		this.message = responseEnum.getMessage();
	}

	public BaseResponseDto(ResponseCodeEnum responseEnum, List<String> errorParameters) {
		super();
		this.responseCode = responseEnum.getCode();
		this.errorParameters = errorParameters;
		this.message = ResponseCodeEnum.generateErrorMessageWithParameters(responseEnum, errorParameters);
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public List<String> getErrorParameters() {
		return errorParameters;
	}

	public void setErrorParameters(List<String> errorParameters) {
		this.errorParameters = errorParameters;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
