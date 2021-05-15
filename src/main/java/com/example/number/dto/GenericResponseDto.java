package com.example.number.dto;

/**
 * This the generic response dto
 *
 * @author Sanjeev
 */
public class GenericResponseDto {
    private Object response;
    private String status;
    private int code;

    /**
     * public default constructor
     */
    public GenericResponseDto() {
    }

    /**
     * public parametrize constructor
     *
     * @param response
     * @param status
     * @param code
     */
    public GenericResponseDto(Object response, String status, int code) {
        this.response = response;
        this.status = status;
        this.code = code;
    }

    /**
     * @return the response
     */
    public Object getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(Object response) {
        this.response = response;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the status code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the status code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
}
