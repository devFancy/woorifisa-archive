package dev.syntax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Major {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "major_id")
	private int id;

	@Column(name = "major_name", nullable = false)
	private String majorName;

	protected Major() {
		super();
	}
	
	

	public Major(String majorName) {
		super();
		this.majorName = majorName;
	}



	public Major(int id, String majorName) {
		super();
		this.id = id;
		this.majorName = majorName;
	}

	@Override
	public String toString() {
		return "Major [id=" + id + ", majorName=" + majorName + "]";
	}

	public String getMajorName() {
		return majorName;
	}

}
