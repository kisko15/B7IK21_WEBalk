package hu.me.iit.gyakorlas.Bicycle.service;

public class Bicycle {

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
	
	public Bicycle(hu.me.iit.gyakorlas.Bicycle.repository.Bicycle bicycle) {
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
	
	public hu.me.iit.gyakorlas.Bicycle.repository.Bicycle toEntity() {
		return new hu.me.iit.gyakorlas.Bicycle.repository.Bicycle(id, type, age, size);
	}
	
	
}
