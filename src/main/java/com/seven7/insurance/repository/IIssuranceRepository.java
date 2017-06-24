package com.seven7.insurance.repository;

import com.seven7.insurance.domain.Issurance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by FANFAN on 2017/6/7.
 */
@Repository
public interface IIssuranceRepository extends CrudRepository<Issurance, String> {
}
