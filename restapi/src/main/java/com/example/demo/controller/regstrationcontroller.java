package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.regstration;
import com.example.demo.services.regstrationservice;

//it is used to connect html ,css(frontend) to backend.
//it connects frontend to backend

//to send data to postman restcontroller must be there , postman used to show errors.
@RestController

//it provide url in postman
@RequestMapping("/api/v1")

// to connect angular to restapi
@CrossOrigin("http://localhost:4200")

public class regstrationcontroller {

//	for two layers connecting we use autowired,here in controller we are connecting service layer
	@Autowired

	regstrationservice service;

//	here we are performing insertion so postmapping is used in postman we use this
	@PostMapping("/add")

//	requestbody is used to insert data same like executeupdate in prepare statement
	public regstration insertion(@RequestBody regstration reg) {
//		service is used to call crud operations
		return service.addingcustmor(reg);
	}

	@PostMapping("/multiadd")
	public Iterable<regstration> multipleinsertion(@RequestBody List<regstration> regs) {
		return service.addingallusers(regs);
	}

//	for fetching using getmapping
	@GetMapping("/multifetching")
	public List<regstration> multifetch() {
		return service.mutlifetch();
	}

	@GetMapping("/singlefetching/{id}")
	public Optional<regstration> singlefetch(@PathVariable int id) {
		return service.singlefetch(id);
	}

	@DeleteMapping("/deleting/{id}")
	public String deleteid(@PathVariable int id) {
		return service.deleteid(id);
	}
	
//	 for update use put
	@PutMapping("/update")
	public regstration updating(@RequestBody regstration reg2 ) {
		return service.updatedata(reg2);
	}
	
//	get by email here getemail method will not create inbuilt we have to create. it is created in repositary
	@GetMapping("/getemail/{email}")
	public regstration getemail( @PathVariable String email) {
		return service.getemail(email);
	}
}
