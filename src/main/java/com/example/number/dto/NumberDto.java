package com.example.number.dto;

import com.example.number.entity.Number;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This is the number dto
 *
 * @author Sanjeev
 */
public class NumberDto {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("number")
    @Expose
    private Integer number;

    /**
     * public default constructor
     */
    public NumberDto() {
    }

    /**
     * public parametrize constructor
     *
     * @param id
     * @param number
     */
    public NumberDto(Integer id, Integer number) {
        this.id = id;
        this.number = number;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the id to set
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * the number to set
     *
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return method to map and return Number DTO to Number entity object
     */
    public Number toNumberEntity() {
        return new Number(this.number);
    }
}
