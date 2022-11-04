package com.EStockMarketApp.EStockMarketInfoReader.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.EStockMarketApp.EStockMarketInfoReader.model.EstockInfoModel;

public interface CompanyStockInfoRepository  extends MongoRepository<EstockInfoModel, Long> {

//	@Query("{'id':?0, 'stocksList':{'gt'} ")
//	@Query("{'dateTime' :{ $gte:?0, $lte: ?1}}")
	//EstockInfoModel findStocksWithInDate(Long id, String startDate, String endDate);
}
