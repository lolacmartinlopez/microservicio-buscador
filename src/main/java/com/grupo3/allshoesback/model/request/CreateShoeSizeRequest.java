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
public class CreateShoeSizeRequest {
	
	@JsonProperty("shoe") 
	private String shoe; 
	
	@JsonProperty("size") 
	private String size; 
	
	@JsonProperty("stock") 
	private Integer stock; 

}
