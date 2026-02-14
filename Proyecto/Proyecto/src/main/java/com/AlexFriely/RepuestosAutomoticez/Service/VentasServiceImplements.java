package com.AlexFriely.RepuestosAutomoticez.Service;


import com.AlexFriely.RepuestosAutomoticez.Entity.Ventas;
import com.AlexFriely.RepuestosAutomoticez.Repository.VentasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VentasServiceImplements implements VentasService{
    private final VentasRepository ventasRepository;

    public VentasServiceImplements(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> getAllVentas() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas getVentasById(Integer id) {
        Ventas ventas = ventasRepository.findById(id).orElse(null);
        if (ventas == null ) {
            throw new IllegalArgumentException("venta no disponible");
        }
        return ventasRepository.findById(id).orElse(null);
    }

    @Override
    public Ventas saveVentas(Ventas ventas) throws RuntimeException {
        return ventasRepository.save(ventas);
    }

    @Override
    public Ventas updateVentas(Integer id, Ventas ventas) {
        Ventas ventas1 = ventasRepository.findById(id).orElse(null);
        if (ventas1 != null) {
            ventas1.setFecha_venta(ventas.getFecha_venta());
            ventas1.setCantidad(ventas.getCantidad());
            ventas1.setTotal(ventas.getTotal());
            ventas1.setId_empleado(ventas.getId_empleado());
            ventas1.setId_repuesto(ventas.getId_repuesto());
        }else {
            throw new IllegalArgumentException();
        }
        return ventasRepository.save(ventas1);
    }

    @Override
    public void deleteVentas(Integer id) {
        Ventas ventas = ventasRepository.findById(id).orElse(null);
        if(ventas == null) {
            throw new IllegalArgumentException("Venta no Disponible");
        }
        ventasRepository.deleteById(id);
    }
}
