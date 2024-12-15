/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laboratorio6.laboratorio6.controller;

import com.laboratorio6.laboratorio6.model.Proveedor;
import com.laboratorio6.laboratorio6.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService service;

    // Constructor para inyectar el servicio
    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    // Mostrar todos los proveedores
    @GetMapping
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", service.listarTodos());
        return "proveedores"; // Vista que muestra todos los proveedores
    }

    // Mostrar el formulario para crear un nuevo proveedor
    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "formularioProveedor"; // Vista para el formulario de nuevo proveedor
    }

    // Guardar un nuevo proveedor
    @PostMapping
    public String guardarProveedor(@ModelAttribute Proveedor proveedor) {
        service.guardar(proveedor);
        return "redirect:/proveedores"; // Redirigir a la lista de proveedores despues de guardar        
    }

    // Mostrar el formulario para editar un proveedor existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("proveedor", service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id)));
        return "formularioProveedor"; // Vista para el formulario de edición de proveedor
    }

    // Eliminar un proveedor por su ID
    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/proveedores"; // Redirigir a la lista después de eliminar
    }
}
