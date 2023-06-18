package com.grupo3.allshoesback.model.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(indexName = "shoesizes", createIndex = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ElasticShoeSize {

	@Id
	private String id;
	
	@Field(type = FieldType.Keyword, name = "shoe")
	private String shoe;
	
	@Field(type = FieldType.Keyword, name = "size")
	private String size;
	
	@Field(type = FieldType.Integer, name = "stock")
	private Integer stock;
	
}
