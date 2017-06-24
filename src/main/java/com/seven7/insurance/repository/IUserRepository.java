package com.seven7.insurance.repository;

import com.seven7.insurance.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by FANFAN on 2017/6/7.
 */
@Repository
public interface IUserRepository extends CrudRepository<User, String> {
}
