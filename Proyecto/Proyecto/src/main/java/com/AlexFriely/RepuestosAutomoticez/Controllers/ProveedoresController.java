package com.AlexFriely.RepuestosAutomoticez.Controllers;


import com.AlexFriely.RepuestosAutomoticez.Entity.Empleado;
import com.AlexFriely.RepuestosAutomoticez.Entity.Proveedor;
import com.AlexFriely.RepuestosAutomoticez.Service.ProveedoresService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {
    private final ProveedoresService proveedoresService;


    public ProveedoresController(ProveedoresService proveedoresService) {
        this.proveedoresService = proveedoresService;
    }

    @GetMapping
    public List<Proveedor> getAllProveedores(){
        return proveedoresService.getAllProveedor();
    }

    @PostMapping
    public ResponseEntity<Object> createProveedor(@Valid @RequestBody Proveedor proveedor){
        try {
            Proveedor createProveedor = proveedoresService.saveProveedor(proveedor);
            return new ResponseEntity<>(createProveedor, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProveedor(@PathVariable Integer id,@Valid @RequestBody Proveedor proveedor){
        try {
            Proveedor updateProveedo = proveedoresService.updateProveedor(id, proveedor);
            return new ResponseEntity<>(updateProveedo, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProveedorById(@PathVariable Integer id, Proveedor proveedor) {
        try{
            Proveedor searchProveedor = proveedoresService.getProveedorById(id);
            return new ResponseEntity<>(searchProveedor,HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProveedor(@PathVariable Integer id){
        try {
            proveedoresService.deleteProveedor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}





