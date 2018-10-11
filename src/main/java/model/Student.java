package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
Long id;
String name;
@ManyToMany(cascade= {CascadeType.PERSIST})
@JoinTable(
		name="student_cour",
		joinColumns= { @JoinColumn(name="student_id")},
		inverseJoinColumns= {@JoinColumn(name="cour_id")}
		)
Set<Cour>cours = new HashSet<>();
public Student(Long id, String name, Set<Cour> cours) {
	
	this.id = id;
	this.name = name;
	this.cours = cours;
}
public Student() {
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<Cour> getCours() {
	return cours;
}
public void setCours(Set<Cour> cours) {
	this.cours = cours;
}

}
