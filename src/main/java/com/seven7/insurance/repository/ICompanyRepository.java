package com.seven7.insurance.repository;

import com.seven7.insurance.domain.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by FANFAN on 2017/6/7.
 */
@Repository
public interface ICompanyRepository extends CrudRepository<Company, String> {
}
