package com.grupo3.allshoesback.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.allshoesback.model.pojo.ElasticShoeSize;
import com.grupo3.allshoesback.model.request.CreateShoeSizeRequest;
import com.grupo3.allshoesback.service.ElasticShoeSizeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ElasticShoeSizeController {

	private final ElasticShoeSizeService service;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/shoesizes")
	public ResponseEntity<List<ElasticShoeSize>> getShoeSizess(
			@RequestParam(required = false) String shoeid,
			@RequestParam(required = false) String sizeid, 
			@RequestParam(required = false) Integer stock) {

		List<ElasticShoeSize> shoeSizes = service.getShoeSizes(shoeid, sizeid, stock);

		if (shoeSizes != null) {
			return ResponseEntity.ok(shoeSizes);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/shoesizes/{shoesizeId}")
	public ResponseEntity<ElasticShoeSize> getShoeSize(@PathVariable String shoesizeId) {

		ElasticShoeSize shoeSize = service.getShoeSize(shoesizeId);

		if (shoeSize != null) {
			return ResponseEntity.ok(shoeSize);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/shoesizes/{shoesizeId}")
	public ResponseEntity<Void> deleteShoeSize(@PathVariable String shoesizeId) {

		Boolean removed = service.removeShoeSize(shoesizeId);

		if (Boolean.TRUE.equals(removed)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/shoesizes")
	public ResponseEntity<ElasticShoeSize> createShoeSize(@RequestBody CreateShoeSizeRequest request) {
		ElasticShoeSize shoeSize = service.createShoeSize(request);
		
		if (shoeSize != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(shoeSize);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/shoesizes/{shoesizeId}")
	public ResponseEntity<Boolean> decreaseStock(@PathVariable String shoesizeId, @RequestParam Integer amount) {
		Boolean removed = service.decreaseStock(shoesizeId, amount);

		if (Boolean.TRUE.equals(removed)) {
			return ResponseEntity.ok(true);
		} else if (removed == null){
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.badRequest().body(false);
		}
	}
}
