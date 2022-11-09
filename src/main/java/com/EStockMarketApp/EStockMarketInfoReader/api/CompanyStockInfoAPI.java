package com.EStockMarketApp.EStockMarketInfoReader.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.EStockMarketApp.EStockMarketInfoReader.dto.EstockInfoModelDTO;
import com.EStockMarketApp.EStockMarketInfoReader.service.CompanyStockInfoService;

@CrossOrigin
@RestController
public class CompanyStockInfoAPI {

	@Autowired
	CompanyStockInfoService companyStockInfoService;

	@GetMapping("info/{id}")
	public ResponseEntity<EstockInfoModelDTO>  getEstockInfo(@PathVariable Long id) {

		EstockInfoModelDTO estockInfoModelDTO= companyStockInfoService.findInfoById(id);
		if(null != estockInfoModelDTO) {
			return new ResponseEntity<>(estockInfoModelDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(estockInfoModelDTO, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("info/{id}/{startDate}/{endDate}")
	public ResponseEntity<EstockInfoModelDTO> findStocksWithInDate(@PathVariable Long id, @PathVariable String startDate, @PathVariable String endDate) {
		EstockInfoModelDTO estockInfoModelDTO = companyStockInfoService.findStocksWithInDate(id, startDate, endDate);
		if(null != estockInfoModelDTO) {
			return new ResponseEntity<>(estockInfoModelDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(estockInfoModelDTO, HttpStatus.BAD_REQUEST); 
	}

	@GetMapping("info/all")
	public ResponseEntity<List<EstockInfoModelDTO>> getAll() {
		List<EstockInfoModelDTO> estockInfoModelDTOList = companyStockInfoService.getAll();
		if(null != estockInfoModelDTOList) {
			return new ResponseEntity<>(estockInfoModelDTOList, HttpStatus.OK);
		}
		return new ResponseEntity<>(estockInfoModelDTOList, HttpStatus.BAD_REQUEST);
	}
}
