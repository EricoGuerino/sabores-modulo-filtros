package com.tcc.saboresmodulofiltros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.saboresmodulofiltros.pojo.Categoria;
import com.tcc.saboresmodulofiltros.repositories.CategoriaRepository;
import com.tcc.saboresmodulofiltros.service.exceptions.DataIntegrityException;
import com.tcc.saboresmodulofiltros.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria obterPeloId(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjetoNaoEncontradoException("Categoria Não Encontrado para este ID"));
	}
	
	public List<Categoria> listarTodos() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias;
	}
	
	public Categoria insert(Categoria categoria) {
		if (categoria.getId() == null) {
			return categoriaRepository.save(categoria);
		}
		return null;
	}
	
	public Categoria update(Categoria categoria) {
		obterPeloId(categoria.getId());
		return categoriaRepository.save(categoria);
	}
	
	public void delete(Integer id) {
		obterPeloId(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException dive) {
			throw new DataIntegrityException("Não é possivel excluir o recurso, verifique dependências.");
		}
	}
}
