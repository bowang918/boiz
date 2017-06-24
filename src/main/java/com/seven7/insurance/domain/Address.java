package com.seven7.insurance.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by FANFAN on 2017/6/7.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
public class Address extends AbstractPersistable implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7222829287618201111L;

    private String value;

    private Type type;

    @ManyToMany
    private Set<User> owner;

    enum Type {
        HOME, COMPANY
    }
}
