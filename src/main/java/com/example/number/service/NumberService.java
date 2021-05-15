package com.example.number.service;

import com.example.number.dto.NumberDto;
import com.example.number.exception.GenericException;

/**
 * Number service interface
 *
 * @author sanjeev
 */
public interface NumberService {

    /**
     * The API to increase the Number Object field value By One.
     *
     * @param id
     * @return GenericResponse DTO of updated number
     */
    NumberDto incrementNumber(Integer id) throws GenericException;

    /**
     * API to save new Number object to DB
     *
     * @param number
     * @return GenericResponse DTO of updated number
     */
    NumberDto saveNumber(NumberDto number) throws GenericException;
}
