/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baozi.baozistore.controller;

import com.baozi.baozistore.model.Pedido;
import com.baozi.baozistore.repository.ClienteRepository;
import com.baozi.baozistore.repository.PedidoRepository;
import com.baozi.baozistore.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leandro
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    private ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private PedidoRepository repository;
    
    //GET - listar pedidos
    @GetMapping
    public List<Pedido> listar(){
        return repository.findAll();
    }
    
    //GET - consulta por id
    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id){
     return repository.findById(id).orElse(null);
    }
    
    //POST - salva
    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido){
        return repository.save(pedido);
    }
    
    //PUT - atualiza
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
