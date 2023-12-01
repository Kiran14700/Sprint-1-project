package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private long id;

    @Column(name = "Member_name")
    private String name;
    
    @Column(name = "workout_type")
    private String description;
   


    public String getName() {
        return name;
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Workout() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Workout(String name, String description) {
		super();
//		this.id = id;
		this.name = name;
		this.description = description;
		
	}




}
