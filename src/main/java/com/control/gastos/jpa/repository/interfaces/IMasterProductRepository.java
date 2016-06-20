package com.control.gastos.jpa.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.control.gastos.entities.MasterProduct;
@Repository
public interface IMasterProductRepository extends JpaRepository<MasterProduct, Integer>,IBaseRepository<MasterProduct, Integer>{
}
