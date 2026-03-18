/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baozi.baozistore.controller;

import com.baozi.baozistore.model.Cliente;
import com.baozi.baozistore.repository.ClienteRepository;
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
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository repository;
    
    //GET - listar todos
    @GetMapping
    public List<Cliente> listar(){
        return repository.findAll();
    }
        
    //GET - consulta por id
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id){
     return repository.findById(id).orElse(null);
    }
    
    //POST - criar cliente
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }
    
    //PUT - atualizar 
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        cliente.setId(id);
        return repository.save(cliente);
    }
    
    //DERETE - deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
