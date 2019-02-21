package com.dowglasmaia.maiati.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dowglasmaia.maiati.domain.Cargo;

@Repository
public interface CargoRepo extends JpaRepository<Cargo, Long> {

}
