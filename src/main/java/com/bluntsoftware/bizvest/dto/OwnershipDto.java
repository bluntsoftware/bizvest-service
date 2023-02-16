package com.bluntsoftware.bizvest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnershipDto {

	private String name;
	private String type;
	private String equityPercent;
}