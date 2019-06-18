package com.estacionapy.restfull.dao;

import com.estacionapy.restfull.model.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosDao extends CrudRepository<Usuarios, Integer> {

    Usuarios findById_usuario(int username);

}