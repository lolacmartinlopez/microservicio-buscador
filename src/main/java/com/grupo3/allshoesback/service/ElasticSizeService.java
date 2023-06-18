package com.grupo3.allshoesback.service;

import java.util.List;

import com.grupo3.allshoesback.model.pojo.ElasticSize;
import com.grupo3.allshoesback.model.request.CreateSizeRequest;

public interface ElasticSizeService {

	List<ElasticSize> getSizes(String name);

	ElasticSize getSize(String sizeId);

	Boolean removeSize(String sizeId);

	ElasticSize createSize(CreateSizeRequest request);

}
