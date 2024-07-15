package com.synechron.web.SpringBootRestDemo.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	// http://www.localhost:8080/get
	//@RequestMapping(path = "/get", method = RequestMethod.GET)
	@GetMapping("/get")
	public String getData() {
		return "Hey The response from web service";
	}
	
	@PostMapping("/post")
	//@PutMapping("/post")
	public String postData() {
		return "Hey post data";
	}
	@PutMapping("/put")
	public String putData() {
		return "Hey update";
	}
	@DeleteMapping("/delete")
	public String deleteData() {
		return "Hey delete";
	}
	
}

//mode (JSON / XML : XSD 01/02/2024) , medium - internet(protocol)
	// location + structure -> REST API(architecture)
	/**
	 * SOA -> WEb service -> SOAP and REST
	 * CRUD
	 * HTTP methods 
	 * GET -> fetching data READ
	 * POST -> CREATE
	 * PUT -> UPDATE
	 * DELETE -> DELETE
	 * PATCH
	 * 
	 * HTTP status codes
	 * Http headers
	 * 
	 * Endpoint -> URI defines where the data is located on the server
	 * resources
	 * 
	 * web services : do not have UI
	 * 
	 * @RestController -> @Controller and @ResponseBody
	 */
	// 
	/**
	 * zomato - .net
	 * pizzahut -> java
	 * android or ios 
	 * 
	 * // login 
	 * // ATC -> after checkout you login 
	 */
	