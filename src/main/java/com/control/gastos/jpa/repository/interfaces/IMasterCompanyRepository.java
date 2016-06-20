package com.control.gastos.jpa.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.control.gastos.entities.MasterCompany;
@Repository
public interface IMasterCompanyRepository extends JpaRepository<MasterCompany, Integer>,IBaseRepository<MasterCompany, Integer>{
}
