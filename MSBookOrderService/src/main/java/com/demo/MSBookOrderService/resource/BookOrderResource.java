package com.demo.MSBookOrderService.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.MSBookOrderService.dto.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.MSBookOrderService.model.BookOrder;
import com.demo.MSBookOrderService.repository.BookOrderRepository;

@RestController
@RequestMapping("/orders")
public class BookOrderResource {

	@Autowired
	BookOrderRepository repository;

	/**
	 * along with the list of orders placed by a customer
	 * analytics -> choice of the books
	 * @param email
	 * @return
	 */
	@GetMapping("/{email}")
	public List<BookOrder> getBooksOrderedByUser(@PathVariable String email)
	{
		List<BookOrder> orders = new ArrayList<>();
		return repository.findByEmail(email).stream()
				.map(order -> 
				{
					BookOrder obj = new BookOrder();
					obj.setBookid(order.getBookid());
					obj.setDatetime(order.getDatetime());
					return obj;
		}).collect(Collectors.toList());
	}
	@GetMapping("/wrapper/{email}")
	public ResponseWrapper getInfoForUser(@PathVariable String email)
	{
		ResponseWrapper wrapper = new ResponseWrapper();
		List<BookOrder> orders = repository.findByEmail(email).stream()
				.map(order ->
				{
					BookOrder obj = new BookOrder();
					obj.setBookid(order.getBookid());
					obj.setDatetime(order.getDatetime());
					return obj;
				}).collect(Collectors.toList());
		wrapper.setOrders(orders);
		wrapper.setIsMember("Yes");
		wrapper.setTitles(Arrays.asList("Twilight","Martin King"));
		return wrapper;
	}
	
}
