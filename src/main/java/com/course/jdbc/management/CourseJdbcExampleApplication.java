package com.course.jdbc.management;

import com.course.jdbc.management.dao.CategoryDao;
import com.course.jdbc.management.dao.CourseDao;
import com.course.jdbc.management.entity.Category;
import com.course.jdbc.management.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		course.setCourseId(5);
		int save = courseDao.save(course);
		System.out.println("no of rows affected"+save);

		courseDao.getCategoryCourseData().forEach(System.out::println);
	}


}
