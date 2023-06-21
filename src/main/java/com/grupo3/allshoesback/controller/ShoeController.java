/*package com.grupo3.allshoesback.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.allshoesback.model.pojo.Shoe;
import com.grupo3.allshoesback.service.ShoeService;

@RestController
public class ShoeController {

	private ShoeService service;
	
	@Autowired
	public ShoeController(ShoeService service) {this.service = service;}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/shoes")
	public ResponseEntity<List<Shoe>> getShoes() {
		List<Shoe> shoes =service.getShoes();
		if (shoes != null) {return ResponseEntity.ok(shoes);}
		else {return ResponseEntity.ok(Collections.emptyList());}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/shoes/{shoeid}")
	public ResponseEntity<Shoe> getShoeid(@PathVariable String shoeid) {
		Shoe shoe = service.getShoeid(shoeid);
		if (shoe != null) {return ResponseEntity.ok(shoe);}
		else {return ResponseEntity.notFound().build();}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/shoes")
	public ResponseEntity<List<Shoe>> getShoesByAttribute(@RequestParam String attr, @RequestParam String val) {
		List<Shoe> shoes = service.getShoesByAttribute(attr, val);
		if (shoes != null) {return ResponseEntity.ok(shoes); } 
		else { return ResponseEntity.notFound().build();}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/shoes")
	public ResponseEntity<List<Shoe>> getShoes(@RequestParam Optional<String> title, @RequestParam Optional<String> description, @RequestParam Optional<String> image,
			@RequestParam Optional<String> price, @RequestParam Optional<String> brand, @RequestParam Optional<String> category) {
		List<Shoe> shoes;
		if (price.isEmpty()) shoes = service.getShoesByCombinedSearch(title.orElse(null), description.orElse(null), image.orElse(null), null, brand.orElse(null), category.orElse(null));
		else shoes = service.getShoesByCombinedSearch(title.orElse(null), description.orElse(null), image.orElse(null), Float.valueOf(price.get()), brand.orElse(null), category.orElse(null));
		
		if (shoes != null) {return ResponseEntity.ok(shoes); } 
		else { return ResponseEntity.notFound().build();}
	}
}
*/