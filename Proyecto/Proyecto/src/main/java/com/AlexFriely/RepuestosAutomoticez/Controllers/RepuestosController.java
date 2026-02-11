package com.AlexFriely.RepuestosAutomoticez.Controllers;


import com.AlexFriely.RepuestosAutomoticez.Entity.Repuestos;
import com.AlexFriely.RepuestosAutomoticez.Service.RepuestosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api//repuestos")
public class RepuestosController {
    private final RepuestosService repuestosService;


    public RepuestosController(RepuestosService repuestosService) {
        this.repuestosService = repuestosService;
    }
    @GetMapping
    public ResponseEntity<Object> createProveedor(@Valid @RequestBody Repuestos repuestos){
        try {
            Repuestos createRepuestos = repuestosService.saveProveedor(repuestos);
            return new ResponseEntity<>(createRepuestos, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
