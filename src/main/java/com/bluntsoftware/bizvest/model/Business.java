package com.bluntsoftware.bizvest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Business {

	@Id
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
	private List<Milestone> milestones;
	private List<Product> products;
	private Management management;
	private Capitalization capitalization;
	private MarketAssessment marketAssessment;
	private CompetitiveAssessment competitiveAssessment;
	private FinancialSummary financialSummary;
}