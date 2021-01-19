package com.udemy.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.entity.Course;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;


@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
	
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository; 

	@Override
	public List<Course> listAllCourses()
	{LOG.info("Entra en listAllCourses  del servicio .... ");
		 return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		LOG.info("Entra en listAllCourses del servicio ...");
		return courseJpaRepository.save(course);
	}

	@Override
	public Integer removeCourse(Integer id) {
		 courseJpaRepository.deleteById(id);
		 return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		 
		return courseJpaRepository.save(course);
	}

}
