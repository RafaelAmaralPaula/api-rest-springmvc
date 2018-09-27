
package com.lovelacetecnologia.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/produtos")
@Api(value = "API REST Produtos")
@CrossOrigin(origins="")
public class ProdutoResource {

	@Autowired
	private IProdutoRepository produtos;

	@PostMapping
	@ApiOperation(value=" Salva produtos na base de dados")	
	public Produto save(@RequestBody Produto produto) {
		return produtos.save(produto);
	}
	
	@GetMapping
	@ApiOperation(value=" Retorna uma lista de produtos")
	public List<Produto> findAll(){
		return produtos.findAll();
	}
	
	@PutMapping
	@ApiOperation(value=" Atualiza produtos já existente na base de dados")
	public Produto change(@RequestBody Produto produto) {
		return produtos.save(produto);
	}
	
	@DeleteMapping
	@ApiOperation(value="Remove produtos da base de dados")
	public void delete(@RequestBody Produto produto){
		produtos.delete(produto);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value=" Retorna um produto unico")
	public Produto findById(@PathVariable long id){
		return produtos.findById(id);
	}
	

}