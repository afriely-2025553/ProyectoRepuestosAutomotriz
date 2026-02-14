package com.AlexFriely.RepuestosAutomoticez.Service;


import com.AlexFriely.RepuestosAutomoticez.Entity.Repuestos;
import com.AlexFriely.RepuestosAutomoticez.Repository.RepuestosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestosServiceEmplements implements RepuestosService{
    private final RepuestosRepository repuestosRepository;

    public RepuestosServiceEmplements(RepuestosRepository repuestosRepository) {
        this.repuestosRepository = repuestosRepository;
    }

    @Override
    public List<Repuestos> getAllRespuestos() {
        return repuestosRepository.findAll();
    }

    @Override
    public Repuestos getRepuestosById(Integer id) {
        Repuestos repuestos = repuestosRepository.findById(id).orElse(null);
        if (repuestos == null) {
            throw new IllegalArgumentException("Repeusto no encontrado");
        }
        return repuestosRepository.findById(id).orElse(null);
    }

    @Override
    public Repuestos saveProveedor(Repuestos repuestos) throws RuntimeException {
        return repuestosRepository.save(repuestos);
    }

    @Override
    public Repuestos updateRepuestos(Integer id, Repuestos repuestos) {
        Repuestos repuestos1 = repuestosRepository.findById(id).orElse(null);
        if (repuestos1 != null) {
            repuestos1.setNombre_repuesto(repuestos.getNombre_repuesto());
            repuestos1.setCategoria_repuesto(repuestos.getCategoria_repuesto());
            repuestos1.setPrecio_compra(repuestos.getPrecio_compra());
            repuestos1.setPrecio_venta(repuestos.getPrecio_venta());
            repuestos1.setId_proveedor(repuestos.getId_proveedor());
        }else {
            throw new IllegalArgumentException();
        }
        return repuestosRepository.save(repuestos);
    }

    @Override
    public void deleteRepuestos(Integer id) {
        Repuestos repuestos = repuestosRepository.findById(id).orElse(null);
        if(repuestos == null) {
            throw new IllegalArgumentException("Empleado no encontrado");
        }
        repuestosRepository.deleteById(id);
    }
}
