package com.seven7.insurance.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
//import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by FANFAN on 2017/6/7.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
public class Issurance extends AbstractPersistable implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6323070597334977838L;

//    private DateTime startTime;
//
//    private DateTime endTime;

    @ManyToOne
    private Car car;

    private Double price;

//    private Set<String> contents;
}
