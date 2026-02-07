package com.AlexFriely.RepuestosAutomoticez.Controllers;

import com.AlexFriely.RepuestosAutomoticez.Models.Empleado;
import com.AlexFriely.RepuestosAutomoticez.Repository.EmpleadoRepository;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.AlexFriely.RepuestosAutomoticez.Service.EmpleadoService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/empleados")
public class Empleadocontroller {
    private final EmpleadoService empleadoService;

    public Empleadocontroller(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> getAllEmpleados(){
        return empleadoService.getAllEmpleado();
    }

    @PostMapping
    public ResponseEntity<Object> createEmpleado(@Valid @RequestBody Empleado empleado){
        try {
            Empleado createdEmpleado = empleadoService.saveEmpleado(empleado);
            return  new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmpleado(@Valid @RequestBody Empleado empleado, @PathVariable Integer id){
        try {
            Empleado updatedEmpleado = empleadoService.updateEmpleado(id, empleado);
            return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmpleadosById(@PathVariable Integer id){
        try {
            Empleado searchedEmpleado = empleadoService.getEmpleadoById(id);
            return new ResponseEntity<>(searchedEmpleado, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmpleadoById(@PathVariable Integer id){
        try {
            empleadoService.deleteEmpleado(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}



