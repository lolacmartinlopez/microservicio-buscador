package com.grupo3.allshoesback.service;

import java.util.List;

import com.grupo3.allshoesback.model.pojo.ShoeSize;

public interface ShoeSizeService {

	List<ShoeSize> getShoeSizes(String shoeid);
	
	Integer getStock(String shoeid, String sizeid);

	Boolean decreaseStock(String shoeid, String sizeid, Integer amount);
	
}
