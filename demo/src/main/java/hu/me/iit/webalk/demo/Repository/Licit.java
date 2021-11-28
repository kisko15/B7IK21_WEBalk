package hu.me.iit.webalk.demo.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Licit {
	private Integer licit;
	private Integer userId;
	@Id
	@GeneratedValue
	private Long id;
	
	public Licit() {
	}

	public Licit(int licit, int userId) {
		super();
		this.licit = licit;
		this.userId = userId;
	}

	public int getLicit() {
		return licit;
	}

	public Integer getUserid() {
		return userId;
	}

	public void setLicit(int licit) {
		this.licit = licit;
	}

	public void setUserid(Integer userId) {
		this.userId = userId;
	}
	
	
}
