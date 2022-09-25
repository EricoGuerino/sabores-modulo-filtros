package com.tcc.saboresmodulofiltros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.saboresmodulofiltros.pojo.Peso;

@Repository
public interface PesoRepository extends JpaRepository<Peso, Integer>{

}
