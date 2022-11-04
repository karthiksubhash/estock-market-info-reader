package com.EStockMarketApp.EStockMarketInfoReader.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.EStockMarketApp.EStockMarketInfoReader.model.EstockInfoModel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString 
public class CompanyInfoModelDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long code;
	private String name;
	private String ceo;
	private String turnover;
	private String website;
	private String stockexchangeenlisted;
	private String dateTime;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CompanyInfoModelDTO.class);
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
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

	
	public void mapperDTOToModel(EstockInfoModel estockInfoModel, CompanyInfoModelDTO companyInfoModelFrom) {
		estockInfoModel.setId(companyInfoModelFrom.getCode());
		estockInfoModel.setCeo(companyInfoModelFrom.getCeo());
		estockInfoModel.setCompanyName(companyInfoModelFrom.getName());
		estockInfoModel.setStockexchangeenlisted(companyInfoModelFrom.getStockexchangeenlisted());
		estockInfoModel.setTurnover(companyInfoModelFrom.getTurnover());
		estockInfoModel.setWebsite(companyInfoModelFrom.getWebsite());
		try {
			DateTimeFormatter inputFormatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
			LocalDateTime dateTime = LocalDateTime.parse(companyInfoModelFrom.getDateTime(), inputFormatter);
			estockInfoModel.setDateTime(dateTime);
		}catch (Exception ex) {
			LOGGER.error(ex.toString());
		}
	}
	@Override
	public String toString() {
		return "CompanyInfoModelDTO [code=" + code + ", name=" + name + ", ceo=" + ceo + ", turnover=" + turnover
				+ ", website=" + website + ", stockexchangeenlisted=" + stockexchangeenlisted + ", dateTime=" + dateTime
				+ "]";
	}
	  
//	  public void mapperModelToDTO(CompanyInfoModel companyInfoMode,
//			  CompanyInfoModelDTO companyInfoDTO) {
//		  companyInfoDTO.setCeo(companyInfoMode.getCeo());
//		  companyInfoDTO.setDateTime(companyInfoMode.getDateTime());
//		  companyInfoDTO.setName(companyInfoMode.getName());
//		  companyInfoDTO.setStockexchangeenlisted(companyInfoMode.
//				  getStockexchangeenlisted());
//		  companyInfoDTO.setTurnover(companyInfoMode.getTurnover());
//		  companyInfoDTO.setWebsite(companyInfoMode.getWebsite());
//		  companyInfoDTO.setCode(companyInfoMode.getCode());
//		  }
	 

}
