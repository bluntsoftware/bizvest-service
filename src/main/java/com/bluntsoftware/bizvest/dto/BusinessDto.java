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
public class BusinessDto {

	private String id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phone;
	private String email;
	private String website;
	private String linkedIn;
	private String blog;
	private String twitter;
	private String ein;
	private String description;
	private String formation;
	private String industry;
	private String subIndustry;
	private String created;
	private String updated;
	private String founded;
	private Integer numberEmployees;
	private String mission;
	private List<MilestoneDto> milestones;
	private List<ProductDto> products;
	private ManagementDto management;
	private CapitalizationDto capitalization;
	private MarketAssessmentDto marketAssessment;
	private CompetitiveAssessmentDto competitiveAssessment;
	private FinancialSummaryDto financialSummary;
}