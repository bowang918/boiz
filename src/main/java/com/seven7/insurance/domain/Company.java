package com.seven7.insurance.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by FANFAN on 2017/6/7.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
@Table
public class Company extends AbstractPersistable implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7626897482731521156L;

    private String name;

    @ManyToOne
    private Address address;

    @ManyToOne
    private User owner;
}
