package com.trabalhoBackend.baoziStore.model;

import org.springframework.beans.BeanUtils;

import com.trabalhoBackend.baoziStore.DTO.PedidoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class PedidoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "produtoId_FK")
	private ProdutoEntity produto;

	@ManyToOne
	@JoinColumn(name = "clienteId_FK")
	private ClienteEntity cliente;

	@Column(name = "quantidade", nullable = false, unique = false)
	private Integer quantidade;

	public PedidoEntity(PedidoDTO pedido) {
		BeanUtils.copyProperties(pedido, this);
	}

	public PedidoEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public ClienteEntity getCliente() {
		return cliente;
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
