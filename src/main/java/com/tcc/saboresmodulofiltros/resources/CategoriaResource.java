package com.tcc.saboresmodulofiltros.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcc.saboresmodulofiltros.pojo.Categoria;
import com.tcc.saboresmodulofiltros.service.CategoriaService;
import com.tcc.saboresmodulofiltros.utils.Util;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listarTodos() {
		List<Categoria> categorias = categoriaService.listarTodos();
		return Util.buildResponse(HttpStatus.OK).body(categorias);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterPorId(@PathVariable("id")Integer id) throws Exception {
		Categoria categoria = categoriaService.obterPeloId(id);
		return Util.buildResponse(HttpStatus.OK).body(categoria);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Categoria categoria) {
		categoria = categoriaService.insert(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return Util.buildResponse(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable("id")Integer id) {
		categoria.setId(id);
		categoria = categoriaService.update(categoria);
		return Util.buildResponse(HttpStatus.NO_CONTENT).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id")Integer id) {
		categoriaService.delete(id);
		return Util.buildResponse(HttpStatus.NO_CONTENT).build();
	}
}
