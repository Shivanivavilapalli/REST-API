package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.regstration;
import com.example.demo.repository.registrationrepository;

@Service

//service name is given as modelname+service.
public class regstrationservice {

	@Autowired
	registrationrepository repo;
//	repo is one nickname to call curd operations from repository layer.

//	service layer performs  data insertion to database.
//	(model name ,nickname for model)
//	.save is used to send single data(data should send to database which is present in model layer so reg is used)
//	method except return type
	public regstration addingcustmor(regstration reg) {
		return repo.save(reg);
	}

//	creating another method to insert multiple data
//	list javautil:for multiple data we use list keyword <modelname >nickname for model
	public Iterable<regstration> addingallusers(List<regstration> reg) {
		return repo.saveAll(reg);
//		the above line should be iterateble(change) becoz one after the other data should insert

	}

//	to fetch multiple values list is used.
	public List<regstration> mutlifetch() {
//		type caste to convert to list
		return (List<regstration>) repo.findAll();
	}

	public Optional<regstration> singlefetch(int id) {
//if option suits it will fetch other wise it will not fetch so used opational
		return repo.findById(id);

	}

//	delet operation
	public String deleteid(int id) {

		repo.deleteById(id);
		return "sucessfully deleted" + id;
	}

//	update operation
//	to update the data 
	public regstration updatedata(regstration re) {
//	we are updating data by id so created object for id, .get() used to get the data according to id
		int id = re.getId();
		 regstration reg1 = repo.findById(id).get();
//		 we get email according to id given after we set the email with the updated data
		 reg1.setEmail(re.getEmail());
		 reg1.setPassword(re.getPassword());
		 reg1.setName(re.getPassword());
		return repo.save(re);
	}
	
	public regstration getemail(String email) {
		return repo.findByEmail(email);
	}
}
