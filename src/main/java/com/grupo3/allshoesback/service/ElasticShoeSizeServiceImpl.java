package com.grupo3.allshoesback.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.grupo3.allshoesback.data.ElasticsearchRepository;
import com.grupo3.allshoesback.model.pojo.ElasticShoe;
import com.grupo3.allshoesback.model.pojo.ElasticShoeSize;
import com.grupo3.allshoesback.model.request.CreateShoeSizeRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ElasticShoeSizeServiceImpl implements ElasticShoeSizeService{
	
	private final ElasticsearchRepository repository;
	
	@Override
	public List<ElasticShoeSize> getShoeSizes(String shoeid, String sizeid, Integer stock) {
		// TODO Auto-generated method stub
		List<ElasticShoeSize> shoeSizes = repository.findShoeSizes(shoeid, sizeid, stock);
		return shoeSizes.isEmpty() ? null : shoeSizes;
	}

	@Override
	public ElasticShoeSize getShoeSize(String shoesizeId) {
		// TODO Auto-generated method stub
		return repository.findShoeSizeById(shoesizeId).orElse(null);
	}

	@Override
	public Boolean removeShoeSize(String shoesizeId) {
		// TODO Auto-generated method stub
		ElasticShoeSize shoeSize = repository.findShoeSizeById(shoesizeId).orElse(null);

		if (shoeSize != null) {
			repository.deleteShoeSize(shoeSize);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	@Override
	public ElasticShoeSize createShoeSize(CreateShoeSizeRequest request) {
		// TODO Auto-generated method stub
		if (request != null && StringUtils.hasLength(request.getShoe().trim()) && StringUtils.hasLength(request.getSize().trim())
				&& request.getStock() != null) {
			
			ElasticShoeSize shoeSize = new ElasticShoeSize();
			shoeSize.setShoe(request.getShoe());
			shoeSize.setSize(request.getSize());
			shoeSize.setStock(request.getStock());
			
			return repository.saveShoeSize(shoeSize);
			
		} else {
			return null;
		}
	}

	@Override
	public Boolean decreaseStock(String shoesizeId, Integer amount) {
		// TODO Auto-generated method stub
		ElasticShoeSize shoeSize = repository.findShoeSizeById(shoesizeId).orElse(null);
		if (shoeSize == null) return null;
		return repository.decreaseStockShoeSize(shoeSize, amount);
	}

}
