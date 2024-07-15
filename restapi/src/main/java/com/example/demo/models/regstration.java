package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//first layer (models) here what are required for database
//in models write attributes in small letters if u take capital letters data will not fetch
//@data contains all annotations  but it decreses perfomance.

//annotations(@) used for all columns to get setters,getters,constructors
//to send data getters is used
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//above:to create table entity is used
public class regstration {

//	writing columns
//	to provide security to access data private is provided
	
	@Id
//	to say where the starting column starts and where it ends the above annotation says
	@GeneratedValue(strategy = GenerationType.AUTO) 
//	 to generate id automatically
	private int id;
	
	private String name;
	
	@Email
//	then only the email syntax it generate
	private String email;
	
//	private Number phone;
	private String password;
	
//	@Size(max = 12,min = 10)
//	 to edit length of phoneno
	
	
	

}
