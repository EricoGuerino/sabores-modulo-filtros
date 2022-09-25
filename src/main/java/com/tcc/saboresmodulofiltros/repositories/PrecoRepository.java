package com.tcc.saboresmodulofiltros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.saboresmodulofiltros.pojo.Preco;

@Repository
public interface PrecoRepository extends JpaRepository<Preco, Integer>{

}
