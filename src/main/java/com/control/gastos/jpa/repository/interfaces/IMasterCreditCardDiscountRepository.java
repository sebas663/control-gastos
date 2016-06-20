package com.control.gastos.jpa.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.control.gastos.entities.MasterCreditCardDiscount;
@Repository
public interface IMasterCreditCardDiscountRepository extends JpaRepository<MasterCreditCardDiscount, Integer>,IBaseRepository<MasterCreditCardDiscount, Integer>{
}
