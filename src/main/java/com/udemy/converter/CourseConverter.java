package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {
	
	//transformar de entity a model
	public CourseModel entity2model(Course course)
	{
		CourseModel courseModel = new CourseModel();
		
		courseModel.setName(course.getName());
		courseModel.setDescripcion(course.getDescripcion());
		courseModel.setPrice(course.getPrice());
		
		return courseModel;
		
	}
	
	
	//transformar de model a entity
	public Course model2entity(CourseModel courseModel)
	{
		Course course = new Course();
		
		course.setName(courseModel.getName());
		course.setDescripcion(courseModel.getDescripcion());
		course.setPrice(courseModel.getPrice());
		
		return course;
	}
	

}
