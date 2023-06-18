package com.grupo3.allshoesback.data;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder.Type;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.stereotype.Repository;

import com.grupo3.allshoesback.model.pojo.ElasticShoe;
import com.grupo3.allshoesback.model.pojo.ElasticShoeSize;
import com.grupo3.allshoesback.model.pojo.ElasticSize;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ElasticsearchRepository {
	
	private final String[] descriptionSearchFields = { "description", "description._2gram", "description._3gram" };
	
	private final ElasticShoeRepository shoeRepository;
	private final ElasticSizeRepository sizeRepository;
	private final ElasticShoeSizeRepository shoeSizeRepository;
	private final ElasticsearchOperations elasticClient;
	
	//SHOES
	
	public ElasticShoe saveShoe(ElasticShoe shoe) {
		// TODO Auto-generated method stub
		return shoeRepository.save(shoe);
	}
	
	public Boolean deleteShoe(ElasticShoe shoe) {
		return shoeRepository.delete(shoe);
	}
	
	public Optional<ElasticShoe> findShoeById(String id) {
		return shoeRepository.findById(id);
	}
	
	public List<ElasticShoe> findShoes(String title, String description, String image, Float price, String category, String brand) {

		BoolQueryBuilder querySpec = QueryBuilders.boolQuery();

		if (!StringUtils.isEmpty(title)) {
			querySpec.must(QueryBuilders.matchQuery("title", title));
		}
		
		if (!StringUtils.isEmpty(image)) {
			querySpec.must(QueryBuilders.matchQuery("image", image));
		}
		
		if (price != null) {
			querySpec.must(QueryBuilders.termQuery("price", price));
		}
		
		if (!StringUtils.isEmpty(category)) {
			querySpec.must(QueryBuilders.termQuery("category", category));
		}
		
		if (!StringUtils.isEmpty(brand)) {
			querySpec.must(QueryBuilders.termQuery("brand", brand));
		}

		if (!StringUtils.isEmpty(description)) {
			querySpec.must(QueryBuilders.multiMatchQuery(description, descriptionSearchFields).type(Type.BOOL_PREFIX));
		}

		//Si no he recibido ningun parametro, busco todos los elementos.
		if (!querySpec.hasClauses()) {
			querySpec.must(QueryBuilders.matchAllQuery());
		}

		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withQuery(querySpec);

		Query query = nativeSearchQueryBuilder.build();
		SearchHits<ElasticShoe> result = elasticClient.search(query, ElasticShoe.class);
		
		return result.getSearchHits().stream().map(SearchHit::getContent).toList();
	}

	
	//SIZES

	public ElasticSize saveSize(ElasticSize size) {
		// TODO Auto-generated method stub
		return sizeRepository.save(size);
	}

	public Boolean deleteSize(ElasticSize size) {
		// TODO Auto-generated method stub
		return sizeRepository.delete(size);
	}

	public Optional<ElasticSize> findSizeById(String sizeId) {
		// TODO Auto-generated method stub
		return sizeRepository.findById(sizeId);
	}
	
	public List<ElasticSize> findSizes(String name) {
		// TODO Auto-generated method stub
		BoolQueryBuilder querySpec = QueryBuilders.boolQuery();
		
		if (!StringUtils.isEmpty(name)) {
			querySpec.must(QueryBuilders.termQuery("name", name));
		}

		//Si no he recibido ningun parametro, busco todos los elementos.
		if (!querySpec.hasClauses()) {
			querySpec.must(QueryBuilders.matchAllQuery());
		}

		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withQuery(querySpec);

		Query query = nativeSearchQueryBuilder.build();
		SearchHits<ElasticSize> result = elasticClient.search(query, ElasticSize.class);
		
		return result.getSearchHits().stream().map(SearchHit::getContent).toList();
	}
	
	//SHOESIZES

	public ElasticShoeSize saveShoeSize(ElasticShoeSize shoeSize) {
		// TODO Auto-generated method stub
		return shoeSizeRepository.save(shoeSize);
	}

	public Boolean deleteShoeSize(ElasticShoeSize shoeSize) {
		// TODO Auto-generated method stub
		return shoeSizeRepository.delete(shoeSize);
	}

	public Optional<ElasticShoeSize> findShoeSizeById(String shoesizeId) {
		// TODO Auto-generated method stub
		return shoeSizeRepository.findById(shoesizeId);
	}

	public List<ElasticShoeSize> findShoeSizes(String shoeid, String sizeid, Integer stock) {
		// TODO Auto-generated method stub
BoolQueryBuilder querySpec = QueryBuilders.boolQuery();
		
		if (!StringUtils.isEmpty(shoeid)) {
			querySpec.must(QueryBuilders.termQuery("shoe", shoeid));
		}
		
		if (!StringUtils.isEmpty(sizeid)) {
			querySpec.must(QueryBuilders.termQuery("size", shoeid));
		}
		
		if (stock != null) {
			querySpec.must(QueryBuilders.termQuery("stock", stock));
		}

		//Si no he recibido ningun parametro, busco todos los elementos.
		if (!querySpec.hasClauses()) {
			querySpec.must(QueryBuilders.matchAllQuery());
		}

		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withQuery(querySpec);

		Query query = nativeSearchQueryBuilder.build();
		SearchHits<ElasticShoeSize> result = elasticClient.search(query, ElasticShoeSize.class);
		
		return result.getSearchHits().stream().map(SearchHit::getContent).toList();
	}

	public Boolean decreaseStockShoeSize(ElasticShoeSize shoeSize, Integer amount) {
		// TODO Auto-generated method stub
		Integer updatedStock = shoeSize.getStock() - amount;
		if (updatedStock < 0) return false;
		shoeSize.setStock(updatedStock);
		
		shoeSizeRepository.save(shoeSize);
		return true;
	}
	

}
