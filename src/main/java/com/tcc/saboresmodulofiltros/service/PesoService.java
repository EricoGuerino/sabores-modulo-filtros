package com.tcc.saboresmodulofiltros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.saboresmodulofiltros.pojo.Peso;
import com.tcc.saboresmodulofiltros.repositories.PesoRepository;
import com.tcc.saboresmodulofiltros.service.exceptions.DataIntegrityException;
import com.tcc.saboresmodulofiltros.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class PesoService {
	
	@Autowired
	private PesoRepository pesoRepository;
	
	public Peso obterPeloId(Integer id) {
		Optional<Peso> pseo = pesoRepository.findById(id);
		return pseo.orElseThrow(() -> new ObjetoNaoEncontradoException("Peso Não Encontrado para este ID"));
	}
	
	public List<Peso> listarTodos() {
		List<Peso> pseos = pesoRepository.findAll();
		return pseos;
	}
	
	public Peso insert(Peso pseo) {
		if (pseo.getId() == null) {
			return pesoRepository.save(pseo);
		}
		return null;
	}
	
	public Peso update(Peso pseo) {
		obterPeloId(pseo.getId());
		return pesoRepository.save(pseo);
	}
	
	public void delete(Integer id) {
		obterPeloId(id);
		try {
			pesoRepository.deleteById(id);
		} catch (DataIntegrityViolationException dive) {
			throw new DataIntegrityException("Não é possivel excluir o recurso, verifique dependências.");
		}
	}
}
