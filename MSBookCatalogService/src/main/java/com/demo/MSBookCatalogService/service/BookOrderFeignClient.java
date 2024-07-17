package com.demo.MSBookCatalogService.service;

import java.util.List;

import com.demo.MSBookCatalogService.model.OrderWrapper;
import com.demo.MSBookCatalogService.model.OrderedBooks;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name="MSBOOKORDERSERVICE")
public interface BookOrderFeignClient {

	
	@RequestMapping("/orders/{email}")
	public List<OrderedBooks> getBookOrderDetails(@PathVariable String email);

	@RequestMapping("/orders/wrapper/{email}")
	public List<OrderWrapper> getBookOrderDetailsWrapper(@PathVariable String email);
}
