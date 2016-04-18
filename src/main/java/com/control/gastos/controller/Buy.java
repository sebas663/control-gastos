package com.control.gastos.controller;

import java.util.Date;

public class Buy {
	private Long id;
	private Long companyID;
	private String external_code;
	private Double price;
	private int quantity;
	private Long productID;
	private Double total;
	private Date buyDate;
	/**
	 * 
	 */
	public Buy() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the companyID
	 */
	public Long getCompanyID() {
		return companyID;
	}
	/**
	 * @param companyID the companyID to set
	 */
	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}
	/**
	 * @return the external_code
	 */
	public String getExternal_code() {
		return external_code;
	}
	/**
	 * @param external_code the external_code to set
	 */
	public void setExternal_code(String external_code) {
		this.external_code = external_code;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the productID
	 */
	public Long getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}
	/**
	 * @return the buyDate
	 */
	public Date getBuyDate() {
		return buyDate;
	}
	/**
	 * @param buyDate the buyDate to set
	 */
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
}
