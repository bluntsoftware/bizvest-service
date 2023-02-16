package com.bluntsoftware.bizvest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssociatedProduct {

	private String name;
	private String year;
	private String marketShare;
}