package com.grupo3.allshoesback.service;

import java.util.List;

import com.grupo3.allshoesback.model.pojo.ElasticShoeSize;
import com.grupo3.allshoesback.model.request.CreateShoeSizeRequest;

public interface ElasticShoeSizeService {

	List<ElasticShoeSize> getShoeSizes(String shoeid, String sizeid, Integer stock);

	ElasticShoeSize getShoeSize(String shoesizeId);

	Boolean removeShoeSize(String shoesizeId);

	ElasticShoeSize createShoeSize(CreateShoeSizeRequest request);

	Boolean decreaseStock(String shoesizeId, Integer amount);

}
