package com.control.gastos.entities;

public class BoxDiscount {
	private Long id;
	private Long index;
	private Long boxDiscountID;
	private Double amount;
	private Double percent;
	/**
	 * 
	 */
	public BoxDiscount() {
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
	 * @return the boxDiscountID
	 */
	public Long getBoxDiscountID() {
		return boxDiscountID;
	}
	/**
	 * @param boxDiscountID the boxDiscountID to set
	 */
	public void setBoxDiscountID(Long boxDiscountID) {
		this.boxDiscountID = boxDiscountID;
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
	/**
	 * @return the percent
	 */
	public Double getPercent() {
		return percent;
	}
	/**
	 * @param percent the percent to set
	 */
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	
}
