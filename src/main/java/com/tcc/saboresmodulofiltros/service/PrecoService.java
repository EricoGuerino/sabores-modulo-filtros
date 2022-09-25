package com.tcc.saboresmodulofiltros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.saboresmodulofiltros.pojo.Preco;
import com.tcc.saboresmodulofiltros.repositories.PrecoRepository;
import com.tcc.saboresmodulofiltros.service.exceptions.DataIntegrityException;
import com.tcc.saboresmodulofiltros.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class PrecoService {
	
	@Autowired
	private PrecoRepository precoRepository;
	
	public Preco obterPeloId(Integer id) {
		Optional<Preco> preco = precoRepository.findById(id);
		return preco.orElseThrow(() -> new ObjetoNaoEncontradoException("Preco Não Encontrado para este ID"));
	}
	
	public List<Preco> listarTodos() {
		List<Preco> precos = precoRepository.findAll();
		return precos;
	}
	
	public Preco insert(Preco preco) {
		if (preco.getId() == null) {
			return precoRepository.save(preco);
		}
		return null;
	}
	
	public Preco update(Preco preco) {
		obterPeloId(preco.getId());
		return precoRepository.save(preco);
	}
	
	public void delete(Integer id) {
		obterPeloId(id);
		try {
			precoRepository.deleteById(id);
		} catch (DataIntegrityViolationException dive) {
			throw new DataIntegrityException("Não é possivel excluir o recurso, verifique dependências.");
		}
	}
}
