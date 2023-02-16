package com.bluntsoftware.bizvest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketDto {

	private String name;
	private String description;
	private String driversForAdoption;
	private String barriersToAdoption;
	private List<String> marketEstimateSources;
	private Integer annualMarketSize;
	private String annualGrowthRate;
	private List<AssociatedProductDto> associatedProducts;
}