package com.AlexFriely.RepuestosAutomoticez.Service;

import com.AlexFriely.RepuestosAutomoticez.Entity.Proveedor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProveedoresService {
    List<Proveedor> getAllProveedor();
    Proveedor getProveedorById(Integer id);
    Proveedor saveProveedor(Proveedor proveedor) throws RuntimeException;
    Proveedor updateProveedor(Integer id, Proveedor proveedor);
    void deleteProveedor(Integer id);
}
