package com.example.Entity;

import java.sql.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;
    @Column(name = "member_name")

    private String name;
    @Column(name = "member_address")

    private String address;
    @Column(name = "Contact")

    private long phone;

    @Column(name = "join_date")
    private Date joinDate;
    
    private int price;
    private String membership;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String name, String address, long phone, Date joinDate, int price, String membership,
			Trainer trainer) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.joinDate = joinDate;
		this.price = price;
		this.membership = membership;
		this.trainer = trainer;
	}
	
 
}