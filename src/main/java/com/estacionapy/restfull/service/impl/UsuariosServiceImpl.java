package com.estacionapy.restfull.service.impl;

import com.estacionapy.restfull.dao.UsuariosDao;
import com.estacionapy.restfull.model.Usuarios;
import com.estacionapy.restfull.model.UsuariosDto;
import com.estacionapy.restfull.service.UsuariosService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service(value = "userService")
public class UsuariosServiceImpl implements UserDetailsService, UsuariosService {

    @Autowired
    private UsuariosDao userDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getId_usuario(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<Usuarios> findAll() {
        List<Usuarios> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(int id) {
        userDao.deleteById(id);
    }

    @Override
    public Usuarios findOne(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Usuarios findById(int id) {
        Optional<Usuarios> optionalUser = userDao.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @Override
    public UsuariosDto update(UsuariosDto userDto) {
        Usuarios user = findById(userDto.getId_usuario());
        if(user != null) {
            BeanUtils.copyProperties(userDto, user, "password");
            userDao.save(user);
        }
        return userDto;
    }

    @Override
    public Usuarios save(UsuariosDto user) {
        Usuarios newUser = new Usuarios();
        newUser.setId_usuario(user.getId_usuario());
        newUser.setNombre(user.getNombre());
        newUser.setDocumento(user.getDocumento());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setNum_documento(user.getNum_documento());
        return userDao.save(newUser);
    }
}