package com.grupo3.allshoesback.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
public class CreateShoeRequest {
	
	@JsonProperty("title") 
	private String title; 
	
	@JsonProperty("description") 
	private String description; 
	
	@JsonProperty("image") 
	private String image; 
	
	@JsonProperty("price") 
	private Float price; 
	
	@JsonProperty("category") 
	private String category; 
	
	@JsonProperty("brand") 
	private String brand; 

}
