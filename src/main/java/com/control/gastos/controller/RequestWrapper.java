package com.control.gastos.controller;

import java.util.List;

import com.control.gastos.entities.Buy;

public class RequestWrapper {
	
	private List<Buy> buys;

	/**
	 * @return the buys
	 */
	public List<Buy> getBuys() {
		return buys;
	}

	/**
	 * @param buys the buys to set
	 */
	public void setBuys(List<Buy> buys) {
		this.buys = buys;
	}
	
}
