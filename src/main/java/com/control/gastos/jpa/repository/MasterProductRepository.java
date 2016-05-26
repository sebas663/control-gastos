package com.control.gastos.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.control.gastos.entities.MasterProduct;

public interface MasterProductRepository extends JpaRepository<MasterProduct, Integer>{
}
