package com.grupo3.allshoesback.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.grupo3.allshoesback.data.ElasticsearchRepository;
import com.grupo3.allshoesback.model.pojo.ElasticSize;
import com.grupo3.allshoesback.model.request.CreateSizeRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ElasticSizeServiceImpl implements ElasticSizeService {
	
	private final ElasticsearchRepository repository;

	@Override
	public List<ElasticSize> getSizes(String name) {
		// TODO Auto-generated method stub
		List<ElasticSize> sizes = repository.findSizes(name);
		return sizes.isEmpty() ? null : sizes;
	}

	@Override
	public ElasticSize getSize(String sizeId) {
		// TODO Auto-generated method stub
		return repository.findSizeById(sizeId).orElse(null);
	}

	@Override
	public Boolean removeSize(String sizeId) {
		// TODO Auto-generated method stub
		ElasticSize size = repository.findSizeById(sizeId).orElse(null);

		if (size != null) {
			repository.deleteSize(size);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	@Override
	public ElasticSize createSize(CreateSizeRequest request) {
		// TODO Auto-generated method stub
		if (request != null && StringUtils.hasLength(request.getName().trim())) {
			
			ElasticSize size = new ElasticSize();
			size.setName(request.getName());
			
			return repository.saveSize(size);
			
		} else {
			return null;
		}
	}

}
