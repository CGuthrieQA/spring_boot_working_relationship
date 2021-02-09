package com.qa.barn.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BarnDto {
	
	private Long id;
	private String colour;
	private double area;
	private String name;
	private List<AnimalDto> animals = new ArrayList<>();
	
//	// default
//	public BarnDto() {
//		super();
//	}
//	
//	public BarnDto(String colour, double area, String name, List<AnimalDto> animals) {
//		super();
//		this.colour = colour;
//		this.area = area;
//		this.name = name;
//		this.animals = animals;
//	}
//
//	public BarnDto(Long id, String colour, double area, String name, List<AnimalDto> animals) {
//		super();
//		this.id = id;
//		this.colour = colour;
//		this.area = area;
//		this.name = name;
//		this.animals = animals;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getColour() {
//		return colour;
//	}
//
//	public void setColour(String colour) {
//		this.colour = colour;
//	}
//
//	public double getArea() {
//		return area;
//	}
//
//	public void setArea(double area) {
//		this.area = area;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public List<AnimalDto> getAnimals() {
//		return animals;
//	}
//
//	public void setAnimals(List<AnimalDto> animals) {
//		this.animals = animals;
//	}
//
//	@Override
//	public String toString() {
//		return String.format("BarnDto [id=%s, colour=%s, area=%s, name=%s, animals=%s]", id, colour, area, name,
//				animals);
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((animals == null) ? 0 : animals.hashCode());
//		long temp;
//		temp = Double.doubleToLongBits(area);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BarnDto other = (BarnDto) obj;
//		if (animals == null) {
//			if (other.animals != null)
//				return false;
//		} else if (!animals.equals(other.animals))
//			return false;
//		if (Double.doubleToLongBits(area) != Double.doubleToLongBits(other.area))
//			return false;
//		if (colour == null) {
//			if (other.colour != null)
//				return false;
//		} else if (!colour.equals(other.colour))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
//	
//	
	
}
