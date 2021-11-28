package hu.me.iit.gyakorlas.Bicycle.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import hu.me.iit.gyakorlas.Bicycle.service.Bicycle;

public class BicycleCreateDto {

	private Long id;
	
	@NotEmpty
	private String type;
	
	@Min(2)
	private int age;
	
	@Min(100)
	private int size;

	public BicycleCreateDto() {
		super();
	}
	
	public BicycleCreateDto(Bicycle bicycle) {
		super();
		this.id = bicycle.getId();
		this.type = bicycle.getType();
		this.age = bicycle.getAge();
		this.size = bicycle.getSize();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Bicycle toBicycle() {
		return new Bicycle(null, type, age, size);
	}
	
}
