package com.grupo3.allshoesback.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.grupo3.allshoesback.data.ElasticsearchRepository;
import com.grupo3.allshoesback.model.pojo.ElasticShoe;
import com.grupo3.allshoesback.model.request.CreateShoeRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ElasticShoeServiceImpl  implements ElasticShoeService{
	
	private final ElasticsearchRepository repository;

	@Override
	public List<ElasticShoe> getShoes(String title, String description, String image, Float price, String category,
			String brand) {
		// TODO Auto-generated method stub
		List<ElasticShoe> shoes = repository.findShoes(title, description, image, price, category, brand);
		return shoes.isEmpty() ? null : shoes;
	}

	@Override
	public ElasticShoe getShoe(String shoeId) {
		// TODO Auto-generated method stub
		return repository.findShoeById(shoeId).orElse(null);
	}

	@Override
	public Boolean removeShoe(String shoeId) {
		// TODO Auto-generated method stub
		ElasticShoe shoe = repository.findShoeById(shoeId).orElse(null);

		if (shoe != null) {
			repository.deleteShoe(shoe);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
	
	@Override
	public ElasticShoe createShoe(CreateShoeRequest request) {
		// TODO Auto-generated method stub
		
		if (request != null && StringUtils.hasLength(request.getTitle().trim()) && StringUtils.hasLength(request.getDescription().trim())
				&& StringUtils.hasLength(request.getImage().trim()) && StringUtils.hasLength(request.getBrand().trim())
				&& StringUtils.hasLength(request.getCategory().trim()) && request.getPrice() != null) {
			
			ElasticShoe shoe = new ElasticShoe();
			shoe.setTitle(request.getTitle());
			shoe.setDescription(request.getDescription());
			shoe.setImage(request.getImage());
			shoe.setPrice(request.getPrice());
			shoe.setBrand(request.getBrand());
			shoe.setCategory(request.getCategory());
			
			return repository.saveShoe(shoe);
			
		} else {
			return null;
		}
	}
}
