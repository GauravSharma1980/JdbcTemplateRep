package com.course.jdbc.management;

import com.course.jdbc.management.dao.CategoryDao;
import com.course.jdbc.management.dao.CourseDao;
import com.course.jdbc.management.entity.Category;
import com.course.jdbc.management.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CourseJdbcExampleApplication implements CommandLineRunner {

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	CourseDao courseDao;

	public static void main(String[] args) {
		SpringApplication.run(CourseJdbcExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Category category = new Category("3","Horror");
		//categoryDao.save(category);

		//categoryDao.update(category);

		//Category categoryCaptured =  categoryDao.getCategoryById(category.getId());
		//System.out.println(categoryCaptured.getId() + "***"+categoryCaptured.getName());

		/*List<Category> categories = categoryDao.getCategories();
		System.out.println(categories);
		System.out.println("***************");
*/
		List<Category> categoriesUsingRowMapper = categoryDao.getCategoriesUsingRowMapper();
		categoriesUsingRowMapper.forEach(category -> {
			System.out.println(category.getName());
		});

		Category category = categoryDao.getCategoryByIdUsingRowMapper("3");
		System.out.println("name"+category.getName());

		Course course = new Course();
		course.setCategoryId(2);
		course.setPrice(100);
		course.setTitle("Main hoo");
		course.setDescription("desc");
		course.setCourseId(9);
		//int save = courseDao.save(course);
		//System.out.println("no of rows affected"+save);

		//courseDao.getCategoryCourseData().forEach(System.out::println);

		List<Course> courseList = new ArrayList<>();

		Course course2 = new Course();
		course2.setCategoryId(2);
		course2.setPrice(100);
		course2.setTitle("Main hoo 2");
		course2.setDescription("desc 2");
		course2.setCourseId(22);

		courseList.add(course2);

		Course course3 = new Course();
		course3.setCategoryId(2);
		course3.setPrice(100);
		course3.setTitle("Main hoo3");
		course3.setDescription("desc 3");
		course3.setCourseId(21);

		courseList.add(course3);

		Course course4 = new Course();
		course4.setCategoryId(2);
		course4.setPrice(100);
		course4.setTitle("Main hoo 4");
		course4.setDescription("desc 4");
		course4.setCourseId(20);

		courseList.add(course4);


		courseDao.insertbatchUpate(courseList);
	}


}
