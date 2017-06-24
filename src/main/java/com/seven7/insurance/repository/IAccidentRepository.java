package com.seven7.insurance.repository;

import com.seven7.insurance.domain.Accident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by FANFAN on 2017/6/7.
 */
@Repository
public interface IAccidentRepository extends CrudRepository<Accident, String> {
}
