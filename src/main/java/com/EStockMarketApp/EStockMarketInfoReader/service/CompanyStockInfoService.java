package com.EStockMarketApp.EStockMarketInfoReader.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EStockMarketApp.EStockMarketInfoReader.dto.EstockInfoModelDTO;
import com.EStockMarketApp.EStockMarketInfoReader.dto.StockInfoModelDTO;
import com.EStockMarketApp.EStockMarketInfoReader.mapper.StockInfoMapper;
import com.EStockMarketApp.EStockMarketInfoReader.model.EstockInfoModel;
import com.EStockMarketApp.EStockMarketInfoReader.model.StockModel;
import com.EStockMarketApp.EStockMarketInfoReader.repository.CompanyStockInfoRepository;


@Service
public class CompanyStockInfoService {

	@Autowired
	CompanyStockInfoRepository companyStockInfoRepository;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CompanyStockInfoService.class);
	
	public EstockInfoModelDTO findInfoById(Long id) {
		
		Optional<EstockInfoModel> estockInfoModel= companyStockInfoRepository.findById(id);
		
		if(estockInfoModel.isPresent()) {
			EstockInfoModelDTO estockInfoModelDTO = new EstockInfoModelDTO();
			EstockInfoModel estockInfo = estockInfoModel.get();
			StockInfoMapper.estockInfoModelToDTO(estockInfo, estockInfoModelDTO);
			if(null != estockInfoModelDTO.getId()) {
				return estockInfoModelDTO;
			}
		}
		return null;	
	}
	

	public EstockInfoModelDTO findStocksWithInDate(Long id, String startDate, String endDate) {
		
		Optional<EstockInfoModel> estockInfoModel= companyStockInfoRepository.findById(id);
		
		try {
		
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
			final LocalDateTime sDateTime = LocalDateTime.parse(startDate, inputFormatter);
			final LocalDateTime eDateTime = LocalDateTime.parse(endDate, inputFormatter);
			
		if(estockInfoModel.isPresent()) {
			EstockInfoModelDTO estockInfoModelDTO = new EstockInfoModelDTO();
			List<StockInfoModelDTO> stocksListDTO = new ArrayList<StockInfoModelDTO>();
			
			EstockInfoModel estockInfo = estockInfoModel.get();
			List<StockModel> stockList = estockInfo.getStocksList();
			
			estockInfo.setStocksList(null);
			StockInfoMapper.estockInfoModelToDTO(estockInfo, estockInfoModelDTO);
			
			if(null != stockList && !stockList.isEmpty()) {
				ArrayList<StockModel> stockListStream = stockList.stream().filter(stock -> stock.getDateTime().isAfter(sDateTime) && stock.getDateTime().isBefore(eDateTime))
						.collect(Collectors.
	                            toCollection(ArrayList::new));
				stockListStream.forEach(stockInfo -> {
					StockInfoMapper.stockInfoModelToDTOList(stockInfo,stocksListDTO);
				});
			}
			
			if(null != estockInfoModelDTO.getId()) {
				if(null != stocksListDTO && !stocksListDTO.isEmpty()) {
					estockInfoModelDTO.setStocksList(stocksListDTO);
					}
				return estockInfoModelDTO;
			}
		}
		}catch (Exception ex) {
			LOGGER.error(ex.toString());
		}
		return null;	
	}
}
