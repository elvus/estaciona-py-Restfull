package com.estacionapy.restfull.service;
import com.estacionapy.restfull.model.Usuarios;
import com.estacionapy.restfull.model.UsuariosDto;

import java.util.List;

public interface UsuariosService {
    Usuarios save(UsuariosDto user);
    List<Usuarios> findAll();
    void delete(int id);

    Usuarios findOne(String username);

    Usuarios findById(int id);

    UsuariosDto update(UsuariosDto userDto);
}
