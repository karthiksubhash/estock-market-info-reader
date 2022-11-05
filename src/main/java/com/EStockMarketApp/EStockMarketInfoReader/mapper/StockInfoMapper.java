package com.EStockMarketApp.EStockMarketInfoReader.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.EStockMarketApp.EStockMarketInfoReader.dto.EstockInfoModelDTO;
import com.EStockMarketApp.EStockMarketInfoReader.dto.StockInfoModelDTO;
import com.EStockMarketApp.EStockMarketInfoReader.model.EstockInfoModel;
import com.EStockMarketApp.EStockMarketInfoReader.model.StockModel;

public interface StockInfoMapper {
	
	public static void estockInfoModelToDTO(EstockInfoModel estockInfo, EstockInfoModelDTO estockInfoModelDTO) {
		estockInfoModelDTO.setCeo(estockInfo.getCeo());
		estockInfoModelDTO.setCompanyName(estockInfo.getCompanyName());
		estockInfoModelDTO.setId(estockInfo.getId());
		estockInfoModelDTO.setStockexchangeenlisted(estockInfo.getStockexchangeenlisted());
		estockInfoModelDTO.setTurnover(estockInfo.getTurnover());
		estockInfoModelDTO.setWebsite(estockInfo.getWebsite());
		if(null != estockInfo.getDateTime()) {
		estockInfoModelDTO.setDateTime(estockInfo.getDateTime().toString());
		}
		if(null != estockInfo.getStocksList() && !estockInfo.getStocksList().isEmpty()) {
			List<StockInfoModelDTO> stocksList = stockInfoModelToDTOList(estockInfo.getStocksList());
			if(null != stocksList && !stocksList.isEmpty()) {
				estockInfoModelDTO.setStocksList(stocksList);
			}
		}
	}	
	
//	public static void mapperToStockDTO(StockModel stockModel, StockInfoModelDTO stockInfoModelDTO) {
//		if(null != stockModel) {
//			List<StockInfoModelDTO> stocksList = stockInfoModelDTO.mapperToDTOList(stockModel.getStocksList());
//			if(null != stocksList && !stocksList.isEmpty()) {
//				EstockInfoModelDTO estockInfoModelDTO = new EstockInfoModelDTO();
//				estockInfoModelDTO .setStocksList(stocksList);
//			}
//		}
//	}	
	
	
	public static void stockInfoModelToDTO(StockModel stockModel, StockInfoModelDTO stockModelDTO) {
		stockModelDTO.setCompanyCode(stockModel.getCompanyCode());
		stockModelDTO.setId(stockModel.getId());
		stockModelDTO.setStockPrice(stockModel.getStockPrice());
		if(null != stockModel.getDateTime() ) {
			stockModelDTO.setDateTime(stockModel.getDateTime().toString());
		}
		stockModelDTO.setIsDeleted(stockModel.getIsDeleted());
	}
	
	public static List<StockInfoModelDTO> stockInfoModelToDTOList(List<StockModel> stockModelList) {
		List<StockInfoModelDTO> stockInfoModelDTOList = new ArrayList<StockInfoModelDTO>();
		if(null != stockModelList && !stockModelList.isEmpty()) {
			for(StockModel stockModel: stockModelList) {
				StockInfoModelDTO stockInfoModelDTO = new StockInfoModelDTO();
				stockInfoModelToDTO(stockModel, stockInfoModelDTO);
				stockInfoModelDTOList.add(stockInfoModelDTO);
			}
		}
		return stockInfoModelDTOList; 
	}
	
	public static List<StockInfoModelDTO> stockInfoModelToDTOList(StockModel stockInfoModel, List<StockInfoModelDTO> stockInfoModelDTOList ) {
		if(null != stockInfoModel ) {
				StockInfoModelDTO stockInfoModelDTO = new StockInfoModelDTO();
				stockInfoModelToDTO(stockInfoModel, stockInfoModelDTO);
				stockInfoModelDTOList.add(stockInfoModelDTO);
		}
		return stockInfoModelDTOList; 
	}

}
