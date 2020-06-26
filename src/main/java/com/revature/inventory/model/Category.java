package com.revature.inventory.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "category_seq", initialValue = 201)
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
	private Long id;
	private String name;
	private String description;

	public Category() {
	}

	public Category(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		description = description;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", Description=" + description + "]";
	}
}
