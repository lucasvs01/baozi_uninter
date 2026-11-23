package com.trabalhoBackend.baoziStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoBackend.baoziStore.DTO.ClienteDTO;
import com.trabalhoBackend.baoziStore.model.ClienteEntity;
import com.trabalhoBackend.baoziStore.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public String cadastrar(ClienteDTO cliente) {

		ClienteEntity clienteCadastro = new ClienteEntity();
		
		if(cliente.getNome().isBlank() == true) {
			return "Digite um nome do cliente";
		}
		
		clienteCadastro.setNome(cliente.getNome());

		clienteRepository.save(clienteCadastro);

		return "Cliente cadastrado com sucesso";
	}

	public List<ClienteDTO> buscarTodos() {

		List<ClienteEntity> clientes = clienteRepository.findAll();
		return clientes.stream().map(cliente -> new ClienteDTO(cliente)).toList();
	}

	public ClienteDTO buscarPorId(Long id) {

		ClienteEntity clienteEntity = clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Digite um id válido"));

		return new ClienteDTO(clienteEntity);
	}

	public String deletar(Long id) {
		
		ClienteEntity cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Digite um id válido"));
		
		clienteRepository.delete(cliente);
		
		return "Cliente deletado com sucesso!";
	}
}
