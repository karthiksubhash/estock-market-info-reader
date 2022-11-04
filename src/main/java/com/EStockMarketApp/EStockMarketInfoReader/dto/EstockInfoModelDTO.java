package com.EStockMarketApp.EStockMarketInfoReader.dto;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString 
public class EstockInfoModelDTO {

	@Id
	private Long id;
	private String companyName;
	private String turnover;
	private String ceo;
	private String website;
	private String stockexchangeenlisted;
	private String dateTime;
	private List<StockInfoModelDTO> stocksList;

	public String getStockexchangeenlisted() {
		return stockexchangeenlisted;
	}

	public void setStockexchangeenlisted(String stockexchangeenlisted) {
		this.stockexchangeenlisted = stockexchangeenlisted;
	}

	public String getDateTime() { 
		return dateTime; 
	}

	public void setDateTime(String dateTime) { 
		this.dateTime = dateTime; 
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public List<StockInfoModelDTO> getStocksList() {
		return stocksList;
	}
	public void setStocksList(List<StockInfoModelDTO> stocksList) {
		this.stocksList = stocksList;
	}
}
