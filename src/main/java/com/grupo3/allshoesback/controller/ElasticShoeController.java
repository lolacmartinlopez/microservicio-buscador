package com.grupo3.allshoesback.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.allshoesback.model.pojo.ElasticShoe;
import com.grupo3.allshoesback.model.request.CreateShoeRequest;
import com.grupo3.allshoesback.service.ElasticShoeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ElasticShoeController {

	private final ElasticShoeService service;
	
	@GetMapping("/elastic/shoes")
	public ResponseEntity<List<ElasticShoe>> getShoes(
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String description, 
			@RequestParam(required = false) String image, 
			@RequestParam(required = false) Float price,
			@RequestParam(required = false) String category,
			@RequestParam(required = false) String brand) {

		List<ElasticShoe> shoes = service.getShoes(title, description, image, price, category, brand);

		if (shoes != null) {
			return ResponseEntity.ok(shoes);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}

	@GetMapping("/elastic/shoes/{shoeId}")
	public ResponseEntity<ElasticShoe> getShoe(@PathVariable String shoeId) {

		ElasticShoe shoe = service.getShoe(shoeId);

		if (shoe != null) {
			return ResponseEntity.ok(shoe);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/elastic/shoes/{shoeId}")
	public ResponseEntity<Void> deleteShoe(@PathVariable String shoeId) {

		Boolean removed = service.removeShoe(shoeId);

		if (Boolean.TRUE.equals(removed)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping("/elastic/shoes")
	public ResponseEntity<ElasticShoe> createShoe(@RequestBody CreateShoeRequest request) {
		ElasticShoe shoe = service.createShoe(request);
		
		if (shoe != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(shoe);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
