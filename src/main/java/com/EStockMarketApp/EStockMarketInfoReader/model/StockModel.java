package com.EStockMarketApp.EStockMarketInfoReader.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString 
@Document("EstockCompanyInfo")
public class StockModel {

	private Long id;
	private Long companyCode;
	private String stockPrice;
	private LocalDateTime dateTime;
	private Boolean isDeleted;

	public Long getId() {
		return id;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
