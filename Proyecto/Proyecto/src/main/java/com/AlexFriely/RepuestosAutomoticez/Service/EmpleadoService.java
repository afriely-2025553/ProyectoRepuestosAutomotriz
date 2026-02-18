package com.AlexFriely.RepuestosAutomoticez.Service;

import com.AlexFriely.RepuestosAutomoticez.Entity.Empleado;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmpleadoService {
    List<Empleado> getAllEmpleado();
    Empleado getEmpleadoById(Integer id);
    Empleado saveEmpleado(Empleado empleado) throws  RuntimeException;
    Empleado updateEmpleado(Integer id, Empleado  empleado);
    void deleteEmpleado(Integer id);

}
