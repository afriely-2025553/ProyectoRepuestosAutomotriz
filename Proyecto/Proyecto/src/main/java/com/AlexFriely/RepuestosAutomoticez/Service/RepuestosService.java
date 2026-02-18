package com.AlexFriely.RepuestosAutomoticez.Service;

import com.AlexFriely.RepuestosAutomoticez.Entity.Repuestos;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RepuestosService {
    List<Repuestos> getAllRespuestos();
    Repuestos getRepuestosById(Integer id);
    Repuestos saveProveedor(Repuestos repuestos) throws RuntimeException;
    Repuestos updateRepuestos(Integer id, Repuestos repuestos);
    void deleteRepuestos(Integer id);
}
