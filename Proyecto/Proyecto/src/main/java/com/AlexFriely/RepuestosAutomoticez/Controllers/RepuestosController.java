package com.AlexFriely.RepuestosAutomoticez.Controllers;


import com.AlexFriely.RepuestosAutomoticez.Entity.Repuestos;
import com.AlexFriely.RepuestosAutomoticez.Service.RepuestosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestosController {
    private final RepuestosService repuestosService;


    public RepuestosController(RepuestosService repuestosService) {
        this.repuestosService = repuestosService;
    }

    @GetMapping
    public List<Repuestos> getAllProveedores(){
        return repuestosService.getAllRespuestos();
    }


    @PostMapping
    public ResponseEntity<Object> createProveedor(@Valid @RequestBody Repuestos repuestos){
        try {
            Repuestos createRepuestos = repuestosService.saveProveedor(repuestos);
            return new ResponseEntity<>(createRepuestos, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRepuestos(@PathVariable Integer id,@Valid @RequestBody Repuestos repuestos){
        try {
            Repuestos updateRepuestos = repuestosService.updateRepuestos(id, repuestos);
            return new ResponseEntity<>(updateRepuestos, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRepuestosById(@PathVariable Integer id, Repuestos repuestos) {
        try{
            Repuestos searchRepuestos = repuestosService.getRepuestosById(id);
            return new ResponseEntity<>(searchRepuestos,HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRepuestos(@PathVariable Integer id){
        try {
            repuestosService.deleteRepuestos(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
