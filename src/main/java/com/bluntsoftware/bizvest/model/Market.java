package com.bluntsoftware.bizvest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Market {

	private String name;
	private String description;
	private String driversForAdoption;
	private String barriersToAdoption;
	private List<String> marketEstimateSources;
	private Integer annualMarketSize;
	private String annualGrowthRate;
	private List<AssociatedProduct> associatedProducts;
}