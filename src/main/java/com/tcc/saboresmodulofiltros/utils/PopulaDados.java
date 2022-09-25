package com.tcc.saboresmodulofiltros.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcc.saboresmodulofiltros.pojo.Categoria;
import com.tcc.saboresmodulofiltros.repositories.CategoriaRepository;

@Component
public class PopulaDados {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostConstruct
	public void populaDados() {
		Categoria categoria1 = new Categoria(1, "Diet");
		Categoria categoria2 = new Categoria(2, "Doces");
		Categoria categoria3 = new Categoria(3, "Zero Lactose");
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
	}
	
}
