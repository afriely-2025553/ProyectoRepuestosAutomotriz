package com.AlexFriely.RepuestosAutomoticez.Repository;

import com.AlexFriely.RepuestosAutomoticez.Models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {


}
