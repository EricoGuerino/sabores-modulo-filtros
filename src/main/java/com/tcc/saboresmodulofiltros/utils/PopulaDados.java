package com.tcc.saboresmodulofiltros.utils;

import java.util.Arrays;
import java.util.List;

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
		
		List<Categoria> categorias = categoriaRepository.findAll();
		if (categorias.isEmpty()) {
			Categoria categoria1 = new Categoria (1, "Doces");
			Categoria categoria2 = new Categoria (2, "Diet");
			Categoria categoria3 = new Categoria (3, "Zero Açucar");
			Categoria categoria4 = new Categoria (4, "Sem Adição de Açúcar");
			Categoria categoria5 = new Categoria (5, "Enriquecido com Proteínas");
			Categoria categoria6 = new Categoria (6, "Sem Lactose");
			Categoria categoria7 = new Categoria (7, "Sem Glúten");
			Categoria categoria8 = new Categoria (8, "Vegano");
			
			categoriaRepository.saveAll(
					Arrays.asList(
							categoria1, categoria2, categoria3, categoria4,
							categoria5, categoria6, categoria7, categoria8));
		}
		
		List<Fabricante> fabricantes = fabricanteRepository.findAll();
		if (fabricantes.isEmpty()) {
			Fabricante fabricante1 = new Fabricante (1, "Haribol");
			Fabricante fabricante2 = new Fabricante (2, "Famoso");
			Fabricante fabricante3 = new Fabricante (3, "Doce Amor");
			Fabricante fabricante4 = new Fabricante (4, "Doces Fazenda de Minas");
			Fabricante fabricante5 = new Fabricante (5, "Germanos");
			Fabricante fabricante6 = new Fabricante (6, "Yes");
			Fabricante fabricante7 = new Fabricante (7, "Avaré");
			Fabricante fabricante8 = new Fabricante (8, "Rio");
			Fabricante fabricante9 = new Fabricante (9, "Yoot");
			
			fabricanteRepository.saveAll(
					Arrays.asList(
							fabricante1, fabricante2, fabricante3, fabricante4,
							fabricante5, fabricante6, fabricante7, fabricante8,
							fabricante9));
		}
	}
	
}
