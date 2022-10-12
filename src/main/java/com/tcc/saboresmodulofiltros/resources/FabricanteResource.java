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

import com.tcc.saboresmodulofiltros.pojo.Fabricante;
import com.tcc.saboresmodulofiltros.service.FabricanteService;
import com.tcc.saboresmodulofiltros.utils.Util;

@RestController
@RequestMapping(value = "/fabricantes")
public class FabricanteResource {
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listarTodos() {
		List<Fabricante> fabricantes = fabricanteService.listarTodos();
		return Util.buildResponse(HttpStatus.OK).body(fabricantes);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterPorId(@PathVariable("id")Integer id) throws Exception {
		Fabricante fabricante = fabricanteService.obterPeloId(id);
		return Util.buildResponse(HttpStatus.OK).body(fabricante);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Fabricante fabricante) {
		fabricante = fabricanteService.insert(fabricante);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fabricante.getId()).toUri();
		return Util.buildResponse(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Fabricante fabricante, @PathVariable("id")Integer id) {
		fabricante.setId(id);
		fabricante = fabricanteService.update(fabricante);
		return Util.buildResponse(HttpStatus.NO_CONTENT).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id")Integer id) {
		fabricanteService.delete(id);
		return Util.buildResponse(HttpStatus.NO_CONTENT).build();
	}
}
