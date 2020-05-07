package dev.ranieri.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Spring will use Hibernate under the hood to help persist your information
// Spring DATA is a a module of spring responsible for using hibernate and performing persistence in your application

@Entity
@Table(name = "associate")
public class Associate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id")
	private int aId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "points")
	private int points;

	public Associate() {
		super();
	}

	public Associate(int aId, String name, int points) {
		super();
		this.aId = aId;
		this.name = name;
		this.points = points;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Associate [aId=" + aId + ", name=" + name + ", points=" + points + "]";
	}


}
