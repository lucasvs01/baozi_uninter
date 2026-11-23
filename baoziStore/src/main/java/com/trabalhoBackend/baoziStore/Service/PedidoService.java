package com.trabalhoBackend.baoziStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoBackend.baoziStore.DTO.PedidoDTO;
import com.trabalhoBackend.baoziStore.model.ClienteEntity;
import com.trabalhoBackend.baoziStore.model.PedidoEntity;
import com.trabalhoBackend.baoziStore.model.ProdutoEntity;
import com.trabalhoBackend.baoziStore.repository.ClienteRepository;
import com.trabalhoBackend.baoziStore.repository.PedidoRepository;
import com.trabalhoBackend.baoziStore.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public String cadastrar(Integer quantidade, Long clienteID, Long produtoID) {

		ProdutoEntity produto = produtoRepository.findById(produtoID)
				.orElseThrow(() -> new RuntimeException("Dgite um ID de produto válido."));

		ClienteEntity cliente = clienteRepository.findById(clienteID)
				.orElseThrow(() -> new RuntimeException("Dgite um ID de cliente válido."));

		if (produto.getEstoque() == false) {
			return "Produto fora de estoque.";
		}

		PedidoEntity pedido = new PedidoEntity();

		pedido.setCliente(cliente);
		pedido.setProduto(produto);
		pedido.setQuantidade(quantidade);

		pedidoRepository.save(pedido);

		return "Pedido cadastrado com sucesso!";
	}

	public PedidoDTO buscarPorId(Long Id) {

		PedidoEntity pedido = pedidoRepository.findById(Id).get();

		PedidoDTO pedidoDTO = new PedidoDTO(pedido);

		return pedidoDTO;

	}

	public List<PedidoDTO> buscarTodos() {

		List<PedidoEntity> pedidos = pedidoRepository.findAll();

		// Para cada item dentro de List<PedidoEntity> usa o map para percorrer e criar
		// um PedidoDTO do
		// item e transforma em uma List com todos
		return pedidos.stream().map(pedido -> new PedidoDTO(pedido)).toList();

	}

	public String deletar(Long id) {

		PedidoEntity pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Dgite um ID de pedido válido."));

		pedidoRepository.delete(pedido);

		return "Pedido deletado com sucesso!";
	}
}
