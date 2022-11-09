package com.EStockMarketApp.EStockMarketInfoReader.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString 
public class StockInfoModelDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long companyCode;
	private String stockPrice;
	private String dateTime;
	private Boolean isDeleted;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
