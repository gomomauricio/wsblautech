package com.udemy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo 
{
	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public void find()
	{
		JPAQuery<Course> query = new JPAQuery<Course>();
		
		Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(1)).fetchOne();
		
		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.price.between(10, 20)).fetch();
		
		
	}

}
