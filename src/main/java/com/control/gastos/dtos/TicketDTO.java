package com.control.gastos.dtos;

import java.util.Date;
import java.util.List;

public class TicketDTO {
	private Long id;
	private Long companyID;
	private Date buyDate;
	private Double subtotal;
	private Double subtotalBoxDiscount;
	private Double subtotalCreditCardDiscount;
	private Double total;
	private List<Buy> buys;
	private List<BoxDiscount> boxDiscounts;
	private List<CreditCardDiscount> creditCardDiscounts;

	/**
	 * Constructor.
	 */
	public TicketDTO() {
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

	/**
	 * @return the subtotal
	 */
	public Double getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * @return the subtotalBoxDiscount
	 */
	public Double getSubtotalBoxDiscount() {
		return subtotalBoxDiscount;
	}

	/**
	 * @param subtotalBoxDiscount the subtotalBoxDiscount to set
	 */
	public void setSubtotalBoxDiscount(Double subtotalBoxDiscount) {
		this.subtotalBoxDiscount = subtotalBoxDiscount;
	}

	/**
	 * @return the subtotalCreditCardDiscount
	 */
	public Double getSubtotalCreditCardDiscount() {
		return subtotalCreditCardDiscount;
	}

	/**
	 * @param subtotalCreditCardDiscount the subtotalCreditCardDiscount to set
	 */
	public void setSubtotalCreditCardDiscount(Double subtotalCreditCardDiscount) {
		this.subtotalCreditCardDiscount = subtotalCreditCardDiscount;
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

	/**
	 * @return the boxDiscounts
	 */
	public List<BoxDiscount> getBoxDiscounts() {
		return boxDiscounts;
	}

	/**
	 * @param boxDiscounts the boxDiscounts to set
	 */
	public void setBoxDiscounts(List<BoxDiscount> boxDiscounts) {
		this.boxDiscounts = boxDiscounts;
	}

	/**
	 * @return the creditCardDiscounts
	 */
	public List<CreditCardDiscount> getCreditCardDiscounts() {
		return creditCardDiscounts;
	}

	/**
	 * @param creditCardDiscounts the creditCardDiscounts to set
	 */
	public void setCreditCardDiscounts(List<CreditCardDiscount> creditCardDiscounts) {
		this.creditCardDiscounts = creditCardDiscounts;
	}
	
}
