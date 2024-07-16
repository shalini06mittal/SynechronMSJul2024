package com.currex.MSCurrencyConverterService.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.currex.MSCurrencyConverterService.model.ConversionBean;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private RestTemplate template;
	@RequestMapping("/exchange/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean calculateAmount(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity)
	{
		/**
		 * 1. unaware about the location, hardcoded url
		 * 2. template object
		 * 3. more than 1 instance of FEXS => load balancers
		 * 4. locate the services service discovery
		 * 5. unique id
		 * Eureka server
		 */
		//RestTemplate template = new RestTemplate();
		String url = "http://MSForexExchangeService/forex-exchange/from/{from}/to/{to}";
		Map<String, String> map = new HashMap<>();
		map.put("from", from);
		map.put("to", to);
		//ConversionBean bean = template.getForObject(url, ConversionBean.class,map);
		ResponseEntity<ConversionBean> responseEntity = template.exchange(url, HttpMethod.GET,null, ConversionBean.class, map);
		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.getHeaders());
		ConversionBean bean = responseEntity.getBody();
		bean.setQuantity(quantity);
		bean.setTotalCalculatedAmount( bean.getConversionMultiple().multiply(quantity));
		return responseEntity.getBody();
	}
	
}
