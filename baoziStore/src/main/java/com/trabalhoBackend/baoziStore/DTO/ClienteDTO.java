package com.trabalhoBackend.baoziStore.DTO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trabalhoBackend.baoziStore.model.ClienteEntity;

@JsonPropertyOrder({ "id", "nome", "clienteDesde", "pedidos" })
public class ClienteDTO {

	private Long id;
	private String nome;
	private LocalDate clienteDesde;
	private List<PedidoDTO> pedidos;

	public ClienteDTO(ClienteEntity cliente) {
		BeanUtils.copyProperties(cliente, this);

		List<PedidoDTO> pedidosDTO = cliente.getPedidos().stream().map(p -> new PedidoDTO(p)).toList();

		this.pedidos = pedidosDTO;

	}

	public ClienteDTO() {

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

	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}

}
