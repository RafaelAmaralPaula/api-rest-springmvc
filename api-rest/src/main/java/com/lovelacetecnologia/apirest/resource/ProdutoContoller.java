
package com.lovelacetecnologia.apirest.resource;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovelacetecnologia.apirest.model.Produto;
import com.lovelacetecnologia.apirest.repository.IProdutoRepository;

//@RestController
//@RequestMapping("/produtos")
public class ProdutoContoller {

	@Autowired
	private IProdutoRepository produtos;

	@PostMapping
	public Produto save(@RequestBody Produto produto) {
		return produtos.save(produto);
	}

	@GetMapping
	public List<Produto> findAll() {
		return produtos.findAll();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> change(@PathVariable long id, @RequestBody Produto produto) {

		Produto existente = produtos.findById(id);

		if (existente == null) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(produto, existente, "id");

		existente = produtos.save(existente);

		return ResponseEntity.ok(existente);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable long id) {

		Produto produto = produtos.findById(id);

		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		Produto produto = produtos.findById(id);

		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		
		produtos.delete(produto);
		
		return ResponseEntity.noContent().build();
	}

}