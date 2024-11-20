package com.example.demo.service;

import com.example.demo.model.Pedido;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido salvar(Pedido pedido) {
        if (clienteRepository.findById(pedido.getIdCliente()).isEmpty()) {
            throw new IllegalArgumentException("Cliente inválido");
        }
        pedido.getIdsProdutos().forEach(id -> {
            if (produtoRepository.findById(id).isEmpty()) {
                throw new IllegalArgumentException("Produto inválido");
            }
        });
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
    }

    public List<Pedido> buscarPorIdCliente(Long idCliente) {
        return pedidoRepository.findByIdCliente(idCliente);
    }

    public List<Pedido> buscarPorIdProduto(Long idProduto) {
        return pedidoRepository.findByIdsProdutosContaining(idProduto);
    }
}
