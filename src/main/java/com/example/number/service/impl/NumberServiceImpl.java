package com.example.number.service.impl;

import com.example.number.dto.NumberDto;
import com.example.number.entity.Number;
import com.example.number.exception.GenericException;
import com.example.number.repository.NumberRepository;
import com.example.number.service.NumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for the Number Model/Entity
 *
 * @author Sanjeev
 */

@Service
public class NumberServiceImpl implements NumberService {

    @Autowired
    private NumberRepository repository;

    private Logger logger = LoggerFactory.getLogger(NumberServiceImpl.class);

    /**
     * Fetch the Number Object from the DB.
     * Then increase the number field value by 1 and save the updated Object in DB.
     *
     * @param id
     * @return the Number DTO object
     * @throws GenericException
     */

    @Override
    public NumberDto incrementNumber(Integer id) throws GenericException {
        try {
            synchronized (this) {
                Optional<Number> number = repository.findById(id);
                if (number.isPresent()) {
                    Number dbNumber = number.get();
                    int num = dbNumber.getNumber();
                    dbNumber.setNumber(++num);
                    repository.save(dbNumber);
                    return dbNumber.toNumberDTO();
                }
            }
            throw new GenericException("No Record found", HttpStatus.NO_CONTENT);
        } catch (GenericException e) {
            throw e;
        } catch (Exception e) {
            logger.error("Exception while fetching number : {}", e.toString());
            throw new GenericException("Failed to fetch record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Method to save new Number object to DB
     *
     * @param number
     * @return the Number DTO object
     * @throws GenericException
     */
    @Override
    public NumberDto saveNumber(NumberDto number) throws GenericException {
        try {
            Number numberEntity = repository.save(number.toNumberEntity());
            return numberEntity.toNumberDTO();
        } catch (Exception e) {
            logger.error("Exception while saving number : {}", e.toString());
            throw new GenericException("Failed to submit record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
