package com.example.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "trainers")

public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainer_id")
    private long id;

    @Column(name = "Trainer_name")
    private String name;
    
    private String Specialization;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<Member> members;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}


	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Trainer(String name, String specialization, List<Member> members) {
		super();
		this.name = name;
		Specialization = specialization;
		this.members = members;
	}

	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

