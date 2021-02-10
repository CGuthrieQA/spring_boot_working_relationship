package com.qa.barn.persistance.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Barn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // needs a strategy
	private Long id;
	
	@NotNull
	private String colour;

	@NotNull
	private double area;

	@NotNull
	//@Column(name = "address")
	private String name;
	
	// one to many link
	@OneToMany(mappedBy="barn", fetch = FetchType.EAGER) // the mapped by refers to barn in animal class, fetch will be eager for this (can also be lazy)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Animal> animals;
	
	// update - takes id
	public Barn(Long id, @NotNull String colour, @NotNull double area, @NotNull String name) {
		super();
		this.id = id;
		this.colour = colour;
		this.area = area;
		this.name = name;
	}
	
	// create - no id
	public Barn(@NotNull String colour, @NotNull double area, @NotNull String name) {
		super();
		this.colour = colour;
		this.area = area;
		this.name = name;
	}
	
	
}
