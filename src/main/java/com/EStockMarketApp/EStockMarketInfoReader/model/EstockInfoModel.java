package com.EStockMarketApp.EStockMarketInfoReader.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString 
@Document("EstockCompanyInfo")
public class EstockInfoModel {

	@Id
	private BigInteger _id;
	private String companyName;
	private String turnover;
	private String ceo;
	private String website;
	private String stockexchangeenlisted;
	private LocalDateTime dateTime;
	private List<StockModel> stocksList;

	public String getStockexchangeenlisted() {
		return stockexchangeenlisted;
	}

	public void setStockexchangeenlisted(String stockexchangeenlisted) {
		this.stockexchangeenlisted = stockexchangeenlisted;
	}

	public LocalDateTime getDateTime() { 
		return dateTime; 
	}

	public void setDateTime(LocalDateTime dateTime) { 
		this.dateTime = dateTime; 
	}

	public BigInteger getId() {
		return _id;
	}
	public void setId(BigInteger id) {
		this._id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public List<StockModel> getStocksList() {
		return stocksList;
	}
	public void setStocksList(List<StockModel> stocksList) {
		this.stocksList = stocksList;
	}	 
}
