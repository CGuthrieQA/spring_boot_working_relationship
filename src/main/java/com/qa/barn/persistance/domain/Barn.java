package com.qa.barn.persistance.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	@Column(name = "address")
	private String name;
	
	// one to many link
	@OneToMany(mappedBy="barn", fetch = FetchType.EAGER) // the mapped by refers to barn in animal class, fetch will be eager for this (can also be lazy)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Animal> animals;
	
	// default constructor
	public Barn() {
		super();
	}
	
	// CREATE - we don't have an id
	public Barn(@NotNull String colour, @NotNull double area, @NotNull String name, List<Animal> animals) {
		super();
		this.colour = colour;
		this.area = area;
		this.name = name;
		this.animals = animals;
	}
	
	// UPDATE - we have an id
	public Barn(Long id, @NotNull String colour, @NotNull double area, @NotNull String name, List<Animal> animals) {
		super();
		this.id = id;
		this.colour = colour;
		this.area = area;
		this.name = name;
		this.animals = animals;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		return String.format("Barn [id=%s, colour=%s, area=%s, name=%s, animals=%s]", id, colour, area, name, animals);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animals == null) ? 0 : animals.hashCode());
		long temp;
		temp = Double.doubleToLongBits(area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Barn other = (Barn) obj;
		if (animals == null) {
			if (other.animals != null)
				return false;
		} else if (!animals.equals(other.animals))
			return false;
		if (Double.doubleToLongBits(area) != Double.doubleToLongBits(other.area))
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

	
}
