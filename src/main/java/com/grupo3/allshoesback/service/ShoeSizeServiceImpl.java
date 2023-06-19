/*package com.grupo3.allshoesback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.allshoesback.data.ShoeSizeRepository;
import com.grupo3.allshoesback.model.pojo.ShoeSize;

@Service
public class ShoeSizeServiceImpl implements ShoeSizeService{
	
	@Autowired
	private ShoeSizeRepository repository;
	
	@Override
	public List<ShoeSize> getShoeSizes(String shoeid) {
		List<ShoeSize> res = repository.findByShoeId(Long.valueOf(shoeid));
		if (res != null) return res;
		else return null;
	}
	
	@Override
	public Integer getStock(String shoeid, String sizeid) {
		// TODO Auto-generated method stub
		ShoeSize shoeSize = repository.findByShoeIdAndSizeId(Long.valueOf(shoeid), Long.valueOf(sizeid));
		if (shoeSize != null) return shoeSize.getStock();
		else return null;
	}

	@Override
	public Boolean decreaseStock(String shoeid, String sizeid, Integer amount) {
		// TODO Auto-generated method stub
		try {
			repository.decreaseStock(amount, Long.valueOf(shoeid), Long.valueOf(sizeid));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}


}
*/
