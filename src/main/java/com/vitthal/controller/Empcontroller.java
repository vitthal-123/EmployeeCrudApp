package com.vitthal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitthal.entity.Employee;
import com.vitthal.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class Empcontroller {
	@Autowired
	private EmployeeRepository emprepo;
	
	@GetMapping
	public  List<Employee> getallemp()
	{
		return emprepo.findAll();
	}
	
	@PostMapping
	public  ResponseEntity<Employee>  addemp(@RequestBody  Employee emp1)
	{
	    Employee emp= emprepo.save(emp1);
	    if(emp!=null)
	    {
	    	return new ResponseEntity<>(HttpStatus.CREATED);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("get/{byid}")
	public ResponseEntity<Employee>  getempbyid(@PathVariable int byid)
	{
		Employee emp=emprepo.findById(byid).orElse(null);
		 if (emp == null) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		    return new ResponseEntity<>(emp, HttpStatus.OK);
		
	}
	
	@DeleteMapping("del/{byid}")
	public void delempbyid(@PathVariable int byid)
	{
		 emprepo.deleteById(byid);
	}
	
	
	@PutMapping("add/{byid}")
	public Employee updateemp(@PathVariable int byid,@RequestBody Employee emp2)
	{
		emp2.setId(byid);
		return emprepo.save(emp2);
	}
}
