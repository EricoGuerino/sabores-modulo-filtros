package com.tcc.saboresmodulofiltros.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcc.saboresmodulofiltros.pojo.Peso;
import com.tcc.saboresmodulofiltros.service.PesoService;

@RestController
@RequestMapping(value = "/pesos")
public class PesoResource {
	
	@Autowired
	private PesoService pesoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listarTodos() {
		List<Peso> pesos = pesoService.listarTodos();
		return ResponseEntity.ok().body(pesos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterPorId(@PathVariable("id")Integer id) throws Exception {
		Peso peso = pesoService.obterPeloId(id);
		return ResponseEntity.ok().body(peso);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Peso peso) {
		peso = pesoService.insert(peso);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(peso.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Peso peso, @PathVariable("id")Integer id) {
		peso.setId(id);
		peso = pesoService.update(peso);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id")Integer id) {
		pesoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
