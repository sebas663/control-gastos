package com.control.gastos.jpa.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.control.gastos.entities.MasterCompany;

public interface MasterCompanyRepository extends JpaRepository<MasterCompany, Integer>{
}
