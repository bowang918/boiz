package com.seven7.insurance.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by FANFAN on 2017/6/7.
 */
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
public class Accident extends AbstractPersistable implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8714282338377007375L;

    private DateTime time;

    private Address address;

    private User driver;

    @ManyToMany
    private Set<Car> relatedCars;
}
