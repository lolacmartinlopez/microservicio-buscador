package com.grupo3.allshoesback.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.grupo3.allshoesback.model.pojo.ElasticShoeSize;

public interface ElasticShoeSizeRepository extends ElasticsearchRepository<ElasticShoeSize, String> {
	
	ElasticShoeSize save(ElasticShoeSize size);
	
	Boolean delete(ElasticShoeSize size);
	
	Optional<ElasticShoeSize> findById(String id);
	
	List<ElasticShoeSize> findAll();

}
