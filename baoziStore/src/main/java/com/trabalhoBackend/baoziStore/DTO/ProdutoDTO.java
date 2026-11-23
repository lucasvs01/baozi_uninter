package com.trabalhoBackend.baoziStore.DTO;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trabalhoBackend.baoziStore.model.ProdutoEntity;

@JsonPropertyOrder({ "id", "nome", "preco", "estoque", "{pedidos}" })
public class ProdutoDTO {

	public ProdutoDTO(ProdutoEntity produto) {
		BeanUtils.copyProperties(produto, this);

		List<PedidoDTO> pedidoDTO = produto.getPedidos().stream().map(pedido -> new PedidoDTO(pedido)).toList();

		this.pedidos = pedidoDTO;
	}

	public ProdutoDTO() {

	}

	private Long id;
	private String nome;
	private BigDecimal preco;
	private Boolean estoque;
	private List<PedidoDTO> pedidos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Boolean getEstoque() {
		return estoque;
	}

	public void setEstoque(Boolean estoque) {
		this.estoque = estoque;
	}

	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}
}
