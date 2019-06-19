package com.estacionapy.restfull.dao;

import com.estacionapy.restfull.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}