package com.grupo3.allshoesback.model.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Document(indexName = "shoes", createIndex = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ElasticShoe {
	
	@Id
	private String id;
	
	@Field(type = FieldType.Text, name = "title")
	private String title;
	
	@Field(type = FieldType.Search_As_You_Type, name = "description")
	private String description;
	
	@Field(type = FieldType.Text, name = "image")
	private String image;
	
	@Field(type = FieldType.Scaled_Float, name = "price")
	private Float price;
	
	@Field(type = FieldType.Keyword, name = "category")
	private String category;
	
	@Field(type = FieldType.Keyword, name = "brand")
	private String brand;

}
