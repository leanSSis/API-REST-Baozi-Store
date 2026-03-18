/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baozi.baozistore.controller;

import com.baozi.baozistore.model.Produto;
import com.baozi.baozistore.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leandro
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository repository;
    
    //GET - listar todos
    @GetMapping
    public List<Produto>listar(){
        return repository.findAll();
    }
    
    //GET - consulta por id
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }
    
    //POST - salva
    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        return repository.save(produto);
    }
    
    //PUT - atualiza
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto){
        produto.setId(id);
        return repository.save(produto);
    }
    
    //DELETE - deleta
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
