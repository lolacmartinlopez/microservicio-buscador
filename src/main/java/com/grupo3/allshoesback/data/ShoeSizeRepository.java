package com.grupo3.allshoesback.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.grupo3.allshoesback.model.pojo.ShoeSize;

public interface ShoeSizeRepository extends JpaRepository<ShoeSize, Long>{
	
	public ShoeSize findByShoeIdAndSizeId(Long shoeId, Long sizeId);
	
	public List<ShoeSize> findByShoeId(Long shoeid);
	
	@Transactional
    @Modifying
    @Query("update ShoeSize s set s.stock = s.stock - ?1 where s.shoe.id = ?2 and s.size.id = ?3")
    int decreaseStock(Integer amount, Long shoeId, Long sizeId);

}
