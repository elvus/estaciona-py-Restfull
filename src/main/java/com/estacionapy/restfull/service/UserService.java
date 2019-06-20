package com.estacionapy.restfull.service;
import com.estacionapy.restfull.model.User;
import com.estacionapy.restfull.model.UserDto;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    void delete(int id);

    User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);
}
