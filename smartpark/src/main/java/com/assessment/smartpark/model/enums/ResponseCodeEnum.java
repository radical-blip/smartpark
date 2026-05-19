package com.assessment.smartpark.model.enums;

import java.util.List;

public enum ResponseCodeEnum {
    SUCCESS("Success", "000", "Successful response."),
    INVALID_LOT_ID("Parking Lot", "500", "Invalid Lot ID."),
    LOT_ALREADY_FULL("Parking Lot", "501", "Parking Lot Is Already Full."),
    INVALID_LICENSE_PLATE("Vehicle", "600", "Invalid License Plate."),
    INVALID_PLATE_FORMAT("Vehicle", "601", "Invalid License Plate Format."),
    LICENSE_PLATE_NOT_REGISTERED("Vehicle", "602", "License Plate Not Yet Registered."),
    INVALID_VEHICLE_TYPE("Vehicle", "603", "Invalid Vehicle Type."),
    VEHICLE_ALREADY_PARKED("Vehicle", "604", "Vehicle is Already Parked."),
    VEHICLE_NOT_YET_PARKED("Vehicle", "605", "Vehicle is Not Yet Parked.");

    String category;
    String code;
    String message;

    private ResponseCodeEnum(String category, String code, String message) {
        this.category = category;
        this.code = code;
        this.message = message;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String generateErrorMessageWithParameters(ResponseCodeEnum errorCodeMessageEnum,
            List<String> errorParameters) {
        String message = errorCodeMessageEnum.getMessage();
        Integer index = 0;
        if (errorParameters != null) {
            for (String parameter : errorParameters) {
                message = message.replace("{" + index + "}", parameter);
                index++;
            }
        }

        return message;
    }
}
