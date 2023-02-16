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
public class MarketAssessment {

	private String marketingPlan;
	private String salesPlan;
	private List<Market> markets;
}