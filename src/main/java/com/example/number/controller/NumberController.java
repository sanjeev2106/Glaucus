package com.example.number.controller;

import com.example.number.dto.GenericResponseDto;
import com.example.number.dto.NumberDto;
import com.example.number.enums.StatusMsg;
import com.example.number.exception.GenericException;
import com.example.number.service.NumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * The Controller contains 2 api. One for to submit number record and another to increment number value.
 *
 * @author sanjeev
 */
@RestController
@RequestMapping(path = "/number", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class NumberController {

    private static final Logger logger = LoggerFactory.getLogger(NumberController.class);

    @Autowired
    private NumberService numberService;

    /**
     * The API to increase the Number Object field value By One.
     *
     * @param id
     * @return GenericResponse DTO of updated number
     */
    @GetMapping("/{id}/increment")
    public GenericResponseDto incrementNumber(@PathVariable int id) {
        try {
            NumberDto number = numberService.incrementNumber(id);
            return new GenericResponseDto(number, StatusMsg.SUCCESS.toString(), HttpStatus.OK.value());
        } catch (GenericException e) {
            logger.error("Error while increasing value : {}", e.toString());
            return new GenericResponseDto(e.getErrorMessage(), StatusMsg.ERROR.getValue(), e.getStatus().value());
        }
    }

    /**
     * API to save new Number object to DB
     *
     * @param number
     * @return GenericResponse DTO of updated number
     */
    @PostMapping
    public GenericResponseDto saveNumber(@RequestBody NumberDto number) {
        GenericResponseDto responseDto;
        try {
            NumberDto numberDto = numberService.saveNumber(number);
            responseDto = new GenericResponseDto(numberDto, StatusMsg.SUCCESS.getValue(), HttpStatus.OK.value());
        } catch (GenericException e) {
            logger.error("Error while increasing value : {}", e.toString());
            responseDto = new GenericResponseDto(e.getErrorMessage(), StatusMsg.ERROR.toString(), e.getStatus().value());
        }
        return responseDto;
    }
}
