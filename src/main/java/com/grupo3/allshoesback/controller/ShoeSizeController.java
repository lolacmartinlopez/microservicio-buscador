/*package com.grupo3.allshoesback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.allshoesback.model.pojo.ShoeSize;
import com.grupo3.allshoesback.model.request.DecreaseStockRequest;
import com.grupo3.allshoesback.service.ShoeSizeService;

@RestController
public class ShoeSizeController {
	
private ShoeSizeService service;
	
	@Autowired
	public ShoeSizeController(ShoeSizeService service) {this.service = service;}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/shoes/{shoeid}/sizes")
	public ResponseEntity<List<ShoeSize>> getShoeSizes(@PathVariable String shoeid) {
		List<ShoeSize> shoeSizes = service.getShoeSizes(shoeid);
		if (shoeSizes != null) {return ResponseEntity.ok(shoeSizes);}
		else {return ResponseEntity.notFound().build();}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/shoes/{shoeid}/sizes/{sizeid}")
	public ResponseEntity<Integer> getStock(@PathVariable String shoeid, @PathVariable String sizeid) {
		Integer stock = service.getStock(shoeid, sizeid);
		if (stock != null) {return ResponseEntity.ok(stock); } 
		else { return ResponseEntity.notFound().build();}
	}
	
	@PutMapping("shoes/{shoeid}/sizes/{sizeid}")
	public ResponseEntity<Boolean> decreaseStock(@PathVariable String shoeid, @PathVariable String sizeid, @RequestParam String amount) {
		Boolean res = service.decreaseStock(shoeid, sizeid, Integer.valueOf(amount));
		if (res != null) {return ResponseEntity.ok(res); } 
		else { return ResponseEntity.notFound().build();}
	}

}
*/
