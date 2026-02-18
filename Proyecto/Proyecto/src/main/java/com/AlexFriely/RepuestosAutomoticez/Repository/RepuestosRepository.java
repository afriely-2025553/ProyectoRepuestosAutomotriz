package com.AlexFriely.RepuestosAutomoticez.Repository;

import com.AlexFriely.RepuestosAutomoticez.Entity.Repuestos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestosRepository extends JpaRepository<Repuestos, Integer> {
}
