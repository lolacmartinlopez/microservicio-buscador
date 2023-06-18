package com.grupo3.allshoesback.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.grupo3.allshoesback.model.pojo.ElasticSize;

public interface ElasticSizeRepository extends ElasticsearchRepository<ElasticSize, String>{
	
	ElasticSize save(ElasticSize size);
	
	Boolean delete(ElasticSize size);
	
	Optional<ElasticSize> findById(String id);
	
	List<ElasticSize> findAll();

}
