package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cour {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Long id;
	String title;
	@ManyToMany(mappedBy= "cours",cascade= {CascadeType.PERSIST})
	Set<Student>students= new HashSet<>();
	public Cour(Long id, String title, Set<Student> students) {
		
		this.id = id;
		this.title = title;
		this.students = students;
	}
	public Cour() {
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public void addStudents(Student s) {
		students.add(s);
		s.getCours().add(this);
	}
	@Override
	public String toString() {
		return "Cour [id=" + id + ", title=" + title + ", students=" + students + "]";
	}
	
}
