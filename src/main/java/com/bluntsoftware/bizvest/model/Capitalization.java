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
public class Capitalization {

	private Integer fundingGoal;
	private String fundingType;
	private List<FundingAllocation> fundingAllocation;
	private List<Ownership> ownership;
	private Integer estimateBusinessValue;
}