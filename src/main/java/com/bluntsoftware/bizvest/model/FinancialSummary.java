package com.bluntsoftware.bizvest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinancialSummary {

	private Integer lastYearRevenue;
	private Integer thisYearRevenue;
	private Integer projectedRevenue;
	private Integer lastYearExpense;
	private Integer thisYearExpense;
	private Integer projectedExpense;
}