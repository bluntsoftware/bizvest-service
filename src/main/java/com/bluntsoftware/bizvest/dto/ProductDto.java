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
public class ProductDto {

	private String name;
	private String industry;
	private String yearAvailable;
	private String description;
	private Integer numberCustomers;
	private List<String> distribution;
	private List<String> features;
}