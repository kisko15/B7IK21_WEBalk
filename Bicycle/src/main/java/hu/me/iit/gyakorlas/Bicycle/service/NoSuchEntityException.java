package hu.me.iit.gyakorlas.Bicycle.service;

public class NoSuchEntityException extends RuntimeException {
	private Long id;
	
	public NoSuchEntityException(Long id) {
		super(String.format("No such entity: %d", id));
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}
