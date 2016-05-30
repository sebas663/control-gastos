package com.control.gastos.dtos;

public class BoxDiscountDTO {
	private Integer id;
	private Integer index;
	private Integer boxDiscountID;
	private Double amount;
	private Double percent;
	/**
	 * 
	 */
	public BoxDiscountDTO() {
		super();
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}
	/**
	 * @return the boxDiscountID
	 */
	public Integer getBoxDiscountID() {
		return boxDiscountID;
	}
	/**
	 * @param boxDiscountID the boxDiscountID to set
	 */
	public void setBoxDiscountID(Integer boxDiscountID) {
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