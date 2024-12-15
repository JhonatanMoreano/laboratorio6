/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laboratorio6.laboratorio6.service;

import com.laboratorio6.laboratorio6.model.Proveedor;
import com.laboratorio6.laboratorio6.repository.ProveedorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class ProveedorService {
    
    @Autowired
    private ProveedorRepository repository;
    
    // Listar todos losp proveedores
    public List<Proveedor> listarTodos() {
        return repository.findAll();
    }
    
    // Guardar un proveedor
    public void guardar(Proveedor proveedor){
        repository.save(proveedor);
    }
    
    // Buscar proveedor por su ID
    public Optional<Proveedor> buscarPorId(Long id) {
        return repository.findById(id);   
    }
    
    // Eliminar un proveedor por su ID 
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
