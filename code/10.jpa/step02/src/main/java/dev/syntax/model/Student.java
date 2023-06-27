package dev.syntax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int id;

	@Column(name = "student_name", nullable = false)
	private String studentName;

	@ManyToOne // N명의 학생은 1개의 전공을 가질 수 있다.
	@JoinColumn(name = "major_id")
	// -> 외래키 매핑 시 사용, name 속성에 맵핑할 외래키 이름 지정
	private Major major;

	// 기본 생성자
	protected Student() {
	}

	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}

	public Student(int id, String studentName) {
		super();
		this.id = id;
		this.studentName = studentName;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + "]";
	}

}
