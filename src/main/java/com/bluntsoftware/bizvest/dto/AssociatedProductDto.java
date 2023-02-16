package com.bluntsoftware.bizvest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssociatedProductDto {

	private String name;
	private String year;
	private String marketShare;
}