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

import com.grupo3.allshoesback.model.pojo.ElasticSize;
import com.grupo3.allshoesback.model.request.CreateSizeRequest;
import com.grupo3.allshoesback.service.ElasticSizeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ElasticSizeController {

private final ElasticSizeService service;
	
	@GetMapping("/elastic/sizes")
	public ResponseEntity<List<ElasticSize>> getProducts(
			@RequestParam(required = false) String name) {

		List<ElasticSize> sizes = service.getSizes(name);

		if (sizes != null) {
			return ResponseEntity.ok(sizes);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}

	@GetMapping("/elastic/sizes/{sizeId}")
	public ResponseEntity<ElasticSize> getSize(@PathVariable String sizeId) {

		ElasticSize size = service.getSize(sizeId);

		if (size != null) {
			return ResponseEntity.ok(size);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/elastic/sizes/{sizeId}")
	public ResponseEntity<Void> deleteSize(@PathVariable String sizeId) {

		Boolean removed = service.removeSize(sizeId);

		if (Boolean.TRUE.equals(removed)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping("/elastic/sizes")
	public ResponseEntity<ElasticSize> createSize(@RequestBody CreateSizeRequest request) {
		ElasticSize size = service.createSize(request);
		
		if (size != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(size);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
