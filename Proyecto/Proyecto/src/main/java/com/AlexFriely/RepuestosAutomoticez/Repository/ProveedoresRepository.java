package com.AlexFriely.RepuestosAutomoticez.Repository;

import com.AlexFriely.RepuestosAutomoticez.Entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedor, Integer>{


}
