package com.qa.barn.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // needs a strategy
	private Long id;

	@NotNull
	private String type;

	@NotNull
	private int age;

	@NotNull
	private String name;

	// foreign key
	@ManyToOne
	@JoinColumn(name = "barn_id", nullable = false)
	private Barn barn = null;

	public Animal(@NotNull String type, @NotNull int age, @NotNull String name) {
		super();
		this.type = type;
		this.age = age;
		this.name = name;
	}

	public Animal(Long id, @NotNull String type, @NotNull int age, @NotNull String name) {
		super();
		this.id = id;
		this.type = type;
		this.age = age;
		this.name = name;
	}

}
