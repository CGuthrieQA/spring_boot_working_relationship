package com.qa.barn.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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

	public Animal() {
		super();
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Barn getBarn() {
		return barn;
	}

	public void setBarn(Barn barn) {
		this.barn = barn;
	}

	@Override
	public String toString() {
		return String.format("Animal [id=%s, type=%s, age=%s, name=%s, barn=%s]", id, type, age, name, barn);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((barn == null) ? 0 : barn.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		if (barn == null) {
			if (other.barn != null)
				return false;
		} else if (!barn.equals(other.barn))
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
