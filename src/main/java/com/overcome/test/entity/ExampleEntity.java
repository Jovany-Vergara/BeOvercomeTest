package com.overcome.test.entity;

import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Entity;

@Entity
public class ExampleEntity {

	public ExampleEntity() {
  }

	public ExampleEntity(Long id, String name) {
    this.id = id;
    this.name = name;
  }
	@Id Long id;
	String name;


	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}

	public String getName() {return name;}
  public void setName(String name) {this.name = name;}

}
