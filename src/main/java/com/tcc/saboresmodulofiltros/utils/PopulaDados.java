package com.tcc.saboresmodulofiltros.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcc.saboresmodulofiltros.pojo.Categoria;
import com.tcc.saboresmodulofiltros.pojo.Fabricante;
import com.tcc.saboresmodulofiltros.repositories.CategoriaRepository;
import com.tcc.saboresmodulofiltros.repositories.FabricanteRepository;

@Component
public class PopulaDados {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	@PostConstruct
	public void populaDados() {
		Categoria categoria1 = new Categoria(1, "Diet");
		Categoria categoria2 = new Categoria(2, "Doces");
		Categoria categoria3 = new Categoria(3, "Zero Lactose");
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		
		Fabricante fabricante1 = new Fabricante(1, "Haribol");
		Fabricante fabricante2 = new Fabricante(2, "Famoso");
		Fabricante fabricante3 = new Fabricante(3, "Doces da Fazenda");
		
		fabricanteRepository.saveAll(Arrays.asList(fabricante1, fabricante2, fabricante3));
	}
	
}
