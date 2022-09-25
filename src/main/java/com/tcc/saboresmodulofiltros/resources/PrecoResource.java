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

import com.tcc.saboresmodulofiltros.pojo.Preco;
import com.tcc.saboresmodulofiltros.service.PrecoService;

@RestController
@RequestMapping(value = "/precos")
public class PrecoResource {
	
	@Autowired
	private PrecoService precoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listarTodos() {
		List<Preco> precos = precoService.listarTodos();
		return ResponseEntity.ok().body(precos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterPorId(@PathVariable("id")Integer id) throws Exception {
		Preco preco = precoService.obterPeloId(id);
		return ResponseEntity.ok().body(preco);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Preco preco) {
		preco = precoService.insert(preco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(preco.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Preco preco, @PathVariable("id")Integer id) {
		preco.setId(id);
		preco = precoService.update(preco);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id")Integer id) {
		precoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
