package com.grupo3.allshoesback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.allshoesback.data.ShoeRepository;
import com.grupo3.allshoesback.model.pojo.Shoe;

@Service
public class ShoeServiceImpl implements ShoeService{

	
	@Autowired
	private ShoeRepository repository;

	@Override
	public List<Shoe> getShoes() {
		List<Shoe> shoes = repository.findAll();
		return shoes.isEmpty() ? null : shoes;
	}

	@Override
	public Shoe getShoeid(String shoeid) {
		return repository.findById(Long.valueOf(shoeid)).orElse(null);
	}
	
	@Override
	public List<Shoe> getShoesByAttribute(String attr, String val) {
		
		switch(attr.toLowerCase()) {
			case "title":
				return repository.findByTitle(val.toLowerCase());
			case "description":
				return repository.findByDescription(val.toLowerCase());
			case "image":
				return repository.findByImage(val.toLowerCase());
			case "price":
				return repository.findByPrice(Float.valueOf(val.toLowerCase()));
			case "category":
				return repository.findByCategory(val.toLowerCase());
			case "brand":
				return repository.findByBrand(val.toLowerCase());
			default:
				//Invalid attribute
		}
		return null;
	}

	@Override
	public List<Shoe> getShoesByCombinedSearch(String title, String description, String image, Float price,
			String brand, String category) {
		return repository.findByTitleAndDescriptionAndImageAndPriceAndBrandAndCategory(title, description, image, price, brand, category);
	}

	
	
}
