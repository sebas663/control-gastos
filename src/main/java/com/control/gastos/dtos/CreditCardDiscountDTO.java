package com.control.gastos.dtos;

public class CreditCardDiscountDTO {
	private Integer id;
	private Integer index;
	private Integer creditCardDiscountID;
	private Double amount;
	private Double base;
	/**
	 * 
	 */
	public CreditCardDiscountDTO() {
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
	 * @return the creditCardDiscountID
	 */
	public Integer getCreditCardDiscountID() {
		return creditCardDiscountID;
	}
	/**
	 * @param creditCardDiscountID the creditCardDiscountID to set
	 */
	public void setCreditCardDiscountID(Integer creditCardDiscountID) {
		this.creditCardDiscountID = creditCardDiscountID;
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
	 * @return the base
	 */
	public Double getBase() {
		return base;
	}
	/**
	 * @param base the base to set
	 */
	public void setBase(Double base) {
		this.base = base;
	}
}
