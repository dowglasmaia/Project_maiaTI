package com.dowglasmaia.maiati.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dowglasmaia.maiati.domain.Departamento;

@Repository
public interface DepartamentoRepo extends JpaRepository<Departamento, Long>{

}
