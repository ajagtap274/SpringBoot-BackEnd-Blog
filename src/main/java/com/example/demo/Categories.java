package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {
	
	@Id
	@GeneratedValue
	 private Long id2;
	@Column
	String Category;
	public Long getId() {
		return id2;
	}
	public void setId(Long id) {
		this.id2 = id;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	@Override
	public String toString() {
		return "Categories [id=" + id2 + ", Category=" + Category + "]";
	}
	
	
	
	
	

}
