package com.trabalhoBackend.baoziStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoBackend.baoziStore.DTO.ProdutoDTO;
import com.trabalhoBackend.baoziStore.Service.ProdutoService;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping(path = "/cadastro")
	public String cadastrarProdutos(@RequestBody ProdutoDTO produtoDTO) {
		return produtoService.cadastrar(produtoDTO);
	}

	@GetMapping(path = "/buscar/todos")
	public List<ProdutoDTO> buscarTodosProdutos() {
		return produtoService.buscarTodos();
	}

	@GetMapping(path = "/buscar/{id}")
	public ProdutoDTO buscarProdutosPorId(@PathVariable Long id) {
		return produtoService.buscarPorId(id);
	}

	@DeleteMapping(path = "/deletar/{id}")
	public String deletarProdutos(@PathVariable Long id) {
		return produtoService.deletar(id);
	}

}
