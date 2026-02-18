package com.AlexFriely.RepuestosAutomoticez.Service;

import com.AlexFriely.RepuestosAutomoticez.Entity.Proveedor;
import com.AlexFriely.RepuestosAutomoticez.Repository.ProveedoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresServiceImplements  implements ProveedoresService{

    private final ProveedoresRepository proveedoresRepository;

     public ProveedoresServiceImplements(ProveedoresRepository proveedoresRepository, ProveedoresRepository proveedoresRepository1) {
         this.proveedoresRepository = proveedoresRepository1;
     }

    @Override
    public List<Proveedor> getAllProveedor() {
        return proveedoresRepository.findAll();
    }

    @Override
    public Proveedor getProveedorById(Integer id) {
        Proveedor proveedor = proveedoresRepository.findById(id).orElse(null);
        if(proveedor == null) {
            throw new IllegalArgumentException("Proveedor no encontrado");
        }
        return proveedoresRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedor saveProveedor(Proveedor proveedor) throws RuntimeException {
         return proveedoresRepository.save(proveedor);
    }

    @Override
    public Proveedor updateProveedor(Integer id, Proveedor proveedor) {
        Proveedor proveedor1 = proveedoresRepository.findById(id).orElse(null);
         if (proveedor1 != null) {
             proveedor1.setNombre_proveedor(proveedor.getNombre_proveedor());
             proveedor1.setTelefono_proveedor(proveedor.getTelefono_proveedor());
             proveedor1.setDireccion(proveedor.getDireccion());
             proveedor1.setEmail_proveedor(proveedor.getEmail_proveedor());
         }else {
             throw new IllegalArgumentException();
         }
         return proveedoresRepository.save(proveedor);
    }

    @Override
    public void deleteProveedor(Integer id) {
         Proveedor proveedor = proveedoresRepository.findById(id).orElse(null);
         if(proveedor == null) {
             throw new IllegalArgumentException("empleado no encontrado");
         }
         proveedoresRepository.deleteById(id);
    }
}
