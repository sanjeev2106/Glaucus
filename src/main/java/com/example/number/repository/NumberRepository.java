package com.example.number.repository;

import com.example.number.entity.Number;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository to perform DB CRUD operation
 *
 * @author Sanjeev
 */
@Repository
public interface NumberRepository extends CrudRepository<Number, Integer> {
    Optional<Number> findById(Integer id);
}
