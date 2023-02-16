package com.bluntsoftware.bizvest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinancialSummaryDto {

	private Integer lastYearRevenue;
	private Integer thisYearRevenue;
	private Integer projectedRevenue;
	private Integer lastYearExpense;
	private Integer thisYearExpense;
	private Integer projectedExpense;
}