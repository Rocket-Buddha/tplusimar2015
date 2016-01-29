/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.rb.tplusimar2015.core.pojo;

/**
 *
 * @author Andres
 */
public enum Senority {
    
    SR("SR"), 
    SMS("SMS"),
    JR("JR");
    
    private final String codigo;
    
    private Senority(String senority) {  
       this.codigo = senority;
    }

    
    
}
