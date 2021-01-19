package com.udemy.model;

import javax.persistence.Column;

public class CourseModel {

	private String name;

	private String descripcion;

	private Integer price;

	private Integer hours;

	public CourseModel() {
	}

	public CourseModel(String name, String descripcion, Integer price, Integer hours) {
		super();
		this.name = name;
		this.descripcion = descripcion;
		this.price = price;
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

}
