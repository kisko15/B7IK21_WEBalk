package hu.me.iit.gyakorlas.Bicycle.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bicycle {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String type;
	private int age;
	private int size;
	
	public Bicycle() {
		super();
	}

	public Bicycle(Long id, String type, int age, int size) {
		super();
		this.id = id;
		this.type = type;
		this.age = age;
		this.size = size;
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
	
}
