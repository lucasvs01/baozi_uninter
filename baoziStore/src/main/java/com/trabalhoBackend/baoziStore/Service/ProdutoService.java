package com.trabalhoBackend.baoziStore.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoBackend.baoziStore.DTO.ProdutoDTO;
import com.trabalhoBackend.baoziStore.model.ProdutoEntity;
import com.trabalhoBackend.baoziStore.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;

	public String cadastrar(ProdutoDTO produtoDTO) {

		ProdutoEntity produto = new ProdutoEntity();

		BigDecimal preco = produtoDTO.getPreco();

		produto.setNome(produtoDTO.getNome());
		produto.setEstoque(produtoDTO.getEstoque());
		produto.setPreco(preco);

		produtoRepository.save(produto);

		return "Produto cadastrado com sucesso!";

	}

	public List<ProdutoDTO> buscarTodos() {

		List<ProdutoEntity> produto = produtoRepository.findAll();

		return produto.stream().map(produtos -> new ProdutoDTO(produtos)).toList();

	}

	public ProdutoDTO buscarPorId(Long id) {

		ProdutoEntity produto = produtoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Digite um ID de produto válido."));

		return new ProdutoDTO(produto);

	}

	public String deletar(Long id) {
		
		ProdutoEntity produto = produtoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Digite um ID de produto válido."));
		
		produtoRepository.delete(produto);
		
		return "Produto deletado com sucesso.";
		
	}
}
