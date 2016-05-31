package com.control.gastos.services.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T, S, ID extends Serializable> {
	
	List<S> getAll(final Class<S> destType);

	boolean isExist(ID id);

	void saveOrUpdate(S entity, final Class<T> destType);

	S findById(ID id, final Class<S> destType);

	void delete(S entity, final Class<T> destType);
}
