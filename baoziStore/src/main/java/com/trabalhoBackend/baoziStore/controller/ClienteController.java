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

import com.trabalhoBackend.baoziStore.DTO.ClienteDTO;
import com.trabalhoBackend.baoziStore.Service.ClienteService;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping(path = "/cadastro")
	public String cadastrarClientes(@RequestBody ClienteDTO cliente) {
		return clienteService.cadastrar(cliente);
	}

	@GetMapping(path = "/buscar/{id}")
	public ClienteDTO buscarClientesPorId(@PathVariable Long id) {
		return clienteService.buscarPorId(id);
	}

	@GetMapping(path = "buscar/todos")
	public List<ClienteDTO> buscarTodosClientes() {
		return clienteService.buscarTodos();
	}

	@DeleteMapping(path = "/deletar/{id}")
	public String deletarClientes(@PathVariable Long id) {
		return clienteService.deletar(id);
	}

}
