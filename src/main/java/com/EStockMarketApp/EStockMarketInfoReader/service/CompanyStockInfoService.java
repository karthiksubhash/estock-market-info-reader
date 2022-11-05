package com.EStockMarketApp.EStockMarketInfoReader.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

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

	private Double max= null;
	private Double min = null;
	
	public EstockInfoModelDTO findInfoById(Long id) {

		Optional<EstockInfoModel> estockInfoModel= companyStockInfoRepository.findById(id);
	
		if(estockInfoModel.isPresent()) {
			EstockInfoModelDTO estockInfoModelDTO = new EstockInfoModelDTO();
			EstockInfoModel estockInfo = estockInfoModel.get();
			StockInfoMapper.estockInfoModelToDTO(estockInfo, estockInfoModelDTO);		
			if(null != estockInfoModelDTO.getId()) {
				estockInfoModelDTO.getStocksList()
				.forEach(stock -> getMaxMin(stock));
				estockInfoModelDTO.setMaxStockPrice(String.valueOf(max));
				estockInfoModelDTO.setMinStockPrice(String.valueOf(min));
				return estockInfoModelDTO;
			}
			
		}
		return null;	
	}


	private void getMaxMin(StockInfoModelDTO stock) {
		if(null != stock.getStockPrice()) {
			Double stockPrice= Double.valueOf(stock.getStockPrice());
			if(null == min ) {
				min = stockPrice;
			}
			if(null == max) {
				max= stockPrice;
			} 

			if(stockPrice < min ) {
				min = stockPrice;
			}
			if(stockPrice > max) {
				max = stockPrice; 
			}
		}
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
						stocksListDTO.forEach(stock -> { 
							getMaxMin(stock);
							});
						estockInfoModelDTO.setMaxStockPrice(String.valueOf(max));
						estockInfoModelDTO.setMinStockPrice(String.valueOf(min));
					}
					
					return estockInfoModelDTO;
				}
			}
		}catch (Exception ex) {
			LOGGER.error(ex.toString());
		}
		return null;	
	}

	public List<EstockInfoModelDTO> getAll() {	
		List<EstockInfoModel> estockInfoModel= companyStockInfoRepository.findAll();
		List<EstockInfoModelDTO> estockInfoModelDTOList = new ArrayList<EstockInfoModelDTO>();
		if(!estockInfoModel.isEmpty()) {
			estockInfoModel.forEach(estockInfo -> createList(estockInfo, estockInfoModelDTOList));
		}
		return estockInfoModelDTOList;
	}

	private void createList(EstockInfoModel estockInfo, List<EstockInfoModelDTO> estockInfoModelDTOList) {
		EstockInfoModelDTO estockInfoModelDTO = new EstockInfoModelDTO();
		StockInfoMapper.estockInfoModelToDTO(estockInfo, estockInfoModelDTO);
		estockInfoModelDTOList.add(estockInfoModelDTO);
	}
}
