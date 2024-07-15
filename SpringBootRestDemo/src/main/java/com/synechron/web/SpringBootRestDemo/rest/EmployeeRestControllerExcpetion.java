package com.synechron.web.SpringBootRestDemo.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.web.SpringBootRestDemo.entity.Employee;
import com.synechron.web.SpringBootRestDemo.service.EmployeeService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/employeesex")
public class EmployeeRestControllerExcpetion {

	@Autowired
	private EmployeeService eService;
	
	@GetMapping(produces = {"application/json","application/xml"})
	public List<Employee> getAllEmployees(
			@RequestParam(required = false) String city){
		System.out.println("City "+city);
		if(city == null)
			return this.eService.findAll();
		return this.eService.findAllByCity(city);
	}
	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<Object> handleEntityExistsException(EntityExistsException ex) {
		System.out.println();
		Map<String, Object> map = new HashMap();
		map.put("message", "Insertion unsuccessful, returned from handler");
		map.put("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	/**
	 * {
        "name": "name 51",
        "city": "city 51",
        "country": "country 51"
    }
	 * @param employee
	 * @return
	 */
	@PostMapping// insert
	public ResponseEntity<Object> addNewEmployee(@RequestBody Employee employee) {
			Employee emp = this.eService.addEmployee(employee);
			Map<String, Object> map = new HashMap();
			map.put("message", "Insertion successful");
			map.put("employee", employee);
			return ResponseEntity.ok(map);
	}
	@PutMapping// update
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
			Employee emp = this.eService.updateEmployee(employee);
			Map<String, Object> map = new HashMap();
			map.put("message", "Update successful");
			map.put("employee", employee);
			return ResponseEntity.ok(map);
	}
	@GetMapping("/{eid}")
	public ResponseEntity<Object> getEmployee(@PathVariable int eid) {
			Employee emp = this.eService.getEmployeeById(eid);
			Map<String, Object> map = new HashMap();
			map.put("employee", emp);
			return ResponseEntity.ok(map);
	}
	
}
