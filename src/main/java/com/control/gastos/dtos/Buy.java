package com.control.gastos.dtos;


public class Buy {
	private Long id;
	private Long index;
	private Long productID;
	private String external_code;
	private Double quantity;
	private Double price;
	private Double amount;
	/**
	 * 
	 */
	public Buy() {
		super();
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
	 * @return the index
	 */
	public Long getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(Long index) {
		this.index = index;
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
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}