package com.trabalhoBackend.baoziStore.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.trabalhoBackend.baoziStore.DTO.ProdutoDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class ProdutoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", length = 50, nullable = false, unique = false)
	private String nome;

	@Column(name = "preco", length = 50, nullable = false, unique = false)
	private BigDecimal preco;

	@Column(name = "estoque", nullable = false, unique = false)
	private Boolean estoque;

	@OneToMany(mappedBy = "produto", cascade = CascadeType.REMOVE)
	private List<PedidoEntity> pedidos;

	public ProdutoEntity(ProdutoDTO produtoDTO) {
		BeanUtils.copyProperties(produtoDTO, this);
	}

	public ProdutoEntity() {

	}

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

	public List<PedidoEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}

}
