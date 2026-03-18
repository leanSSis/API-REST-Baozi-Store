/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.baozi.baozistore.repository;

import com.baozi.baozistore.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Leandro
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
