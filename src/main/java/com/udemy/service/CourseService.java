package com.udemy.service;

import java.util.List;

import com.udemy.entity.Course;

public interface CourseService 
{

	public abstract List<Course> listAllCourses();
	public abstract Course addCourse(Course course);
	public abstract Integer removeCourse(Integer id); 
	public abstract Course updateCourse(Course course);
	
}
