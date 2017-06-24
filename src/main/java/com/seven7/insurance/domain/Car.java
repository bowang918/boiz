package com.seven7.insurance.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by FANFAN on 2017/6/7.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
public class Car extends AbstractPersistable implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3319414168390164726L;

    /**
     * 车牌
     */
    private String plateNumber;

    /**
     * VIN
     * 车架号
     */
    private String vehicleFrameNumber;

    private String color;

    /**
     * 车主
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;

    @ManyToMany
    private Set<Accident> accidents;
}
