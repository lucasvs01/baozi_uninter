package com.trabalhoBackend.baoziStore.DTO;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trabalhoBackend.baoziStore.model.ClienteEntity;
import com.trabalhoBackend.baoziStore.model.ProdutoEntity;
import com.trabalhoBackend.baoziStore.model.PedidoEntity;

@JsonPropertyOrder({ "id", "quantidade", "produto", "cliente" })
public class PedidoDTO {

	private Long id;
	private ProdutoEntity produto;
	private ClienteEntity cliente;
	private Integer quantidade;

	public PedidoDTO(PedidoEntity pedido) {
		BeanUtils.copyProperties(pedido, this);
	}

	public PedidoDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto.getNome();
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public String getCliente() {
		return cliente.getNome();
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
