package com.trabalhoBackend.baoziStore.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.trabalhoBackend.baoziStore.DTO.ClienteDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", length = 50, nullable = false, unique = false)
	private String nome;

	@Column(name = "clienteDesde", nullable = false, unique = false)
	private LocalDate clienteDesde = LocalDate.now();

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
	private List<PedidoEntity> pedidos;

	public ClienteEntity(ClienteDTO clienteDTO) {
		BeanUtils.copyProperties(clienteDTO, this);
	}

	public ClienteEntity() {

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

	public LocalDate getClienteDesde() {
		return clienteDesde;
	}

	public void setClienteDesde(LocalDate clienteDesde) {
		this.clienteDesde = clienteDesde;
	}

	public List<PedidoEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}

}
