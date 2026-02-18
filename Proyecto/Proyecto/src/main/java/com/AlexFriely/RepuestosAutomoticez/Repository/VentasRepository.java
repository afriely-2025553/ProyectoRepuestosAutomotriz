package com.AlexFriely.RepuestosAutomoticez.Repository;


import com.AlexFriely.RepuestosAutomoticez.Entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository  extends JpaRepository<Ventas, Integer> {
}
