package com.example.number.entity;

import com.example.number.dto.NumberDto;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Number entity class
 *
 * @author Sanjeev
 */
@Entity
@Table(name = "Number")
public class Number implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "number")
    private Integer number;

    /**
     * public default constructor
     */
    public Number() {
    }

    /**
     * public parametrize constructor
     *
     * @param number
     */
    public Number(Integer number) {
        this.number = number;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * @param id the id to set     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the number
     */
    public Integer getNumber() {
        return this.number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return method to map and return Number entity to Number DTO object
     */
    public NumberDto toNumberDTO() {
        return new NumberDto(this.id, this.number);
    }
}
