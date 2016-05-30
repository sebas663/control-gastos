package com.control.gastos.jpa.repository.interfaces;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBaseRepository <T, ID extends Serializable> extends JpaRepository<T, ID>{
	//aca puedo ingresar mis metodos personalizados en un futuro de necesitar.
//	void sharedCustomMethod(ID id);
}
