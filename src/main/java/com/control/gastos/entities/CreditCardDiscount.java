package com.control.gastos.entities;

public class CreditCardDiscount {
	private Long id;
	private Long index;
	private Long creditCardDiscountID;
	private Double amount;
	private Double base;
	/**
	 * 
	 */
	public CreditCardDiscount() {
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
	 * @return the creditCardDiscountID
	 */
	public Long getCreditCardDiscountID() {
		return creditCardDiscountID;
	}
	/**
	 * @param creditCardDiscountID the creditCardDiscountID to set
	 */
	public void setCreditCardDiscountID(Long creditCardDiscountID) {
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
