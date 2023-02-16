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
public class Competitor {

	private String name;
	private String product;
	private String description;
	private List<CompetitiveMarket> competitiveMarkets;
}