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
public class CapitalizationDto {

	private Integer fundingGoal;
	private String fundingType;
	private List<FundingAllocationDto> fundingAllocation;
	private List<OwnershipDto> ownership;
	private Integer estimateBusinessValue;
}