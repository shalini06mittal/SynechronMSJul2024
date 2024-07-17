package com.demo.MSBookCatalogService.service;

import java.util.List;
import java.util.stream.Collectors;

import com.demo.MSBookCatalogService.model.OrderWrapper;
import com.demo.MSBookCatalogService.model.OrderedBooks;
import com.demo.MSBookCatalogService.model.UserCatalog;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class BookCatalogService {

	@Autowired
	BookOrderFeignClient bookOrderFeignClient;
	
	@Autowired
	BookFeignClient bookFeignClient;


	@CircuitBreaker(name = "example", fallbackMethod = "fallbackAfterCircuitBreaker")
	public ResponseEntity<Object> getBooksOrdered(String email)
	{	
		List<OrderedBooks> orders = this.bookOrderFeignClient.getBookOrderDetails(email);
		
		List<UserCatalog> catalogs = orders.stream()
		.map(wrapper ->{
			System.out.println(wrapper.getBookid());
			UserCatalog catalog = this.bookFeignClient.getBookDetails(wrapper.getBookid());
			catalog.setEmail(email);
			catalog.setDatetime(wrapper.getDatetime());
			return catalog;
		}).collect(Collectors.toList());
		return ResponseEntity.ok(catalogs);
	}
	public ResponseEntity<Object> fallbackAfterCircuitBreaker(Exception ex) {
		//System.out.println(ex.getMessage());
		return ResponseEntity.badRequest().body("Fallback\n"+ex.getMessage());
	}
	public List<OrderWrapper> getBooksOrderedWrapper(String email)
	{
		List<OrderWrapper> orders = this.bookOrderFeignClient.getBookOrderDetailsWrapper(email);
		/**
		 * iterate over orders, get book id
		 * callBook service for details of book for every book id
		 * Create a UserCatalog object for every book
		 * then add this catalog in the catalog wrapper, along with email id
		 */
		return  orders;
	}
}
