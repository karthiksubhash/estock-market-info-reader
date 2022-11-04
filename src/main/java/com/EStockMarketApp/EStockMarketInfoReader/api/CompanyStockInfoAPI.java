package com.EStockMarketApp.EStockMarketInfoReader.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.EStockMarketApp.EStockMarketInfoReader.dto.EstockInfoModelDTO;
import com.EStockMarketApp.EStockMarketInfoReader.service.CompanyStockInfoService;


@RestController
public class CompanyStockInfoAPI {
	
	@Autowired
	CompanyStockInfoService companyStockInfoService;
	
	@GetMapping("info/{id}")
	public EstockInfoModelDTO getEstockInfo(@PathVariable Long id) {
		return companyStockInfoService.findInfoById(id);
	}

	
	@GetMapping("info/{id}/{startDate}/{endDate}")
	public EstockInfoModelDTO findStocksWithInDate(@PathVariable Long id, @PathVariable String startDate, @PathVariable String endDate) {
		return companyStockInfoService.findStocksWithInDate(id, startDate, endDate);
	}
}
