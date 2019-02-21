package com.dowglasmaia.maiati.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dowglasmaia.maiati.domain.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

}
