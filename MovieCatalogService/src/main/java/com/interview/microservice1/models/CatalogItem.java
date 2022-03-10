package com.interview.microservice1.models;

import java.beans.ConstructorProperties;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public @Data   class CatalogItem {
	
	private String name;
	private String desc;
	private int rating;
	
}
