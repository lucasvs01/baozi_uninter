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

import com.trabalhoBackend.baoziStore.DTO.PedidoDTO;
import com.trabalhoBackend.baoziStore.Service.PedidoService;

@RestController
@RequestMapping(path = "/pedido")
public class PedidoCotroller {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping(path = "/cadastro/{clienteId_FK}/{produtoId_FK}")
	public String cadastrarPedidos(@PathVariable Long clienteId_FK, @PathVariable Long produtoId_FK,
			@RequestBody PedidoDTO pedidoDTO) {
		Integer quantidade = pedidoDTO.getQuantidade();
		return pedidoService.cadastrar(quantidade, clienteId_FK, produtoId_FK);
	}

	@GetMapping(path = "/buscar/{id}")
	public PedidoDTO buscarPedidosPorId(@PathVariable Long id) {
		return pedidoService.buscarPorId(id);
	}

	@GetMapping(path = "/buscar/todos")
	public List<PedidoDTO> buscarTodosPedidos() {
		return pedidoService.buscarTodos();
	}

	@DeleteMapping(path = "/deletar/{id}")
	public String deletarPedidos(@PathVariable Long id) {
		return pedidoService.deletar(id);
	}
}
