package com.grupo3.allshoesback.service;

import java.util.List;

import com.grupo3.allshoesback.model.pojo.ElasticShoe;
import com.grupo3.allshoesback.model.request.CreateShoeRequest;

public interface ElasticShoeService {

	ElasticShoe createShoe(CreateShoeRequest request);

	List<ElasticShoe> getShoes(String title, String description, String image, Float price, String category,
			String brand);

	ElasticShoe getShoe(String shoeId);

	Boolean removeShoe(String shoeId);

}
