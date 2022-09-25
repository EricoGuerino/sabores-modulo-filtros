package com.tcc.saboresmodulofiltros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.saboresmodulofiltros.pojo.Fabricante;
import com.tcc.saboresmodulofiltros.repositories.FabricanteRepository;
import com.tcc.saboresmodulofiltros.service.exceptions.DataIntegrityException;
import com.tcc.saboresmodulofiltros.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	public Fabricante obterPeloId(Integer id) {
		Optional<Fabricante> fabricante = fabricanteRepository.findById(id);
		return fabricante.orElseThrow(() -> new ObjetoNaoEncontradoException("Fabricante Não Encontrado para este ID"));
	}
	
	public List<Fabricante> listarTodos() {
		List<Fabricante> fabricantes = fabricanteRepository.findAll();
		return fabricantes;
	}
	
	public Fabricante insert(Fabricante fabricante) {
		if (fabricante.getId() == null) {
			return fabricanteRepository.save(fabricante);
		}
		return null;
	}
	
	public Fabricante update(Fabricante fabricante) {
		obterPeloId(fabricante.getId());
		return fabricanteRepository.save(fabricante);
	}
	
	public void delete(Integer id) {
		obterPeloId(id);
		try {
			fabricanteRepository.deleteById(id);
		} catch (DataIntegrityViolationException dive) {
			throw new DataIntegrityException("Não é possivel excluir o recurso, verifique dependências.");
		}
	}
}
