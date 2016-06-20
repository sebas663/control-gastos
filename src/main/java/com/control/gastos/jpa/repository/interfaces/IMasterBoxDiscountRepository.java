package com.control.gastos.jpa.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.control.gastos.entities.MasterBoxDiscount;
@Repository
public interface IMasterBoxDiscountRepository extends JpaRepository<MasterBoxDiscount, Integer>,IBaseRepository<MasterBoxDiscount, Integer>{
}
