package com.control.gastos.services.interfaces;

import java.io.Serializable;
import java.util.List;

public interface ICRUDService<T, S, ID extends Serializable> {
	
	List<S> getAll();

	boolean isExist(ID id);

	void saveOrUpdate(S entity);

	S findById(ID id);

	void delete(S entity);
}
