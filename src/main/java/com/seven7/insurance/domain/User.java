package com.seven7.insurance.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by FANFAN on 2017/6/7.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
public class User extends AbstractPersistable implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -9182714117662941766L;

    /**
     * 身份证号
     */
    private String idNumber;

    private String name;

    private String firstName;

    private String middleName;

    private String lastName;

    @OneToMany(mappedBy = "owner")
    private Set<Car> cars;

    @OneToMany(mappedBy = "owner")
    private Set<Address> addresses;

    public String fullName() {
        return String.join("", Arrays.asList(lastName, middleName, firstName));
    }

}
