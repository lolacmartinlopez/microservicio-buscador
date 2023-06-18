package com.grupo3.allshoesback.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.grupo3.allshoesback.model.pojo.ElasticShoe;

public interface ElasticShoeRepository extends ElasticsearchRepository<ElasticShoe, String>{
	
	ElasticShoe save(ElasticShoe shoe);
	
	Boolean delete(ElasticShoe shoe);
	
	Optional<ElasticShoe> findById(String id);
	
	Optional<ElasticShoe> findByTitle(String title);
	
	List<ElasticShoe> findByBrand(String brand);
	
	List<ElasticShoe> findByCategory(String category);
	
	List<ElasticShoe> findAll();

}
