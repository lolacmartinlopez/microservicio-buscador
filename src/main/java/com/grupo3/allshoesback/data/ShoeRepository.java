/*package com.grupo3.allshoesback.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo3.allshoesback.model.pojo.Shoe;

public interface ShoeRepository extends JpaRepository<Shoe, Long>{
	
	public Optional<Shoe> findById(Long shoeid);

	public List<Shoe> findByTitle(String title);

	public List<Shoe> findByDescription(String description);

	public List<Shoe> findByImage(String image);

	public List<Shoe> findByPrice(Float price);

	public List<Shoe> findByCategory(String Category);

	public List<Shoe> findByBrand(String Brand);

	@Query("SELECT s FROM Shoe s WHERE (:title is null or s.title = :title) and (:description is null or s.description = :description)" +
			" and (:image is null or s.image = :image) and (:price is null or s.price = :price) and (:brand is null or s.brand = :brand)" +
			" and (:category is null or s.category = :category)")
	public List<Shoe> findByTitleAndDescriptionAndImageAndPriceAndBrandAndCategory(String title, String description,
			String image, Float price, String brand, String category);

}
*/