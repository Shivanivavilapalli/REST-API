package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.regstration;

//to implement crud operations use repository layer
@Repository
//here crudrepository is extended to use crud operations
//the <model name , first column datatype>
public interface registrationrepository extends CrudRepository<regstration, Integer>{

	regstration findByEmail(String email);

}
