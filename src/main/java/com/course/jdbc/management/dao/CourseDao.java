package com.course.jdbc.management.dao;

import com.course.jdbc.management.entity.CategoryCourseData;
import com.course.jdbc.management.entity.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    //insert into course


    public int save(Course course) {
        String insertQuery = "INSERT INTO course (courseId, description, price, title, categoryId) VALUES (?, ?, ?, ?, ?)";
        int updatedRows = jdbcTemplate.update(insertQuery,
                course.getCourseId(),
                course.getDescription(),
                course.getPrice(),
                course.getTitle(),
                course.getCategoryId());
        return updatedRows;
    }

    //get all courses

    public List<Course> getAllCourses() {
        String getAllCoursesQuery = "select * from course";
        List<Course> courses = jdbcTemplate.queryForList(getAllCoursesQuery, Course.class);
        return courses;
    }

    public List<Course> getAllCoursesUsingMapper() {
        String getAllCoursesQuery = "select * from course";
        List<Course> courses = jdbcTemplate.query(getAllCoursesQuery, (rs, num) -> {
            Course course = new Course();
            course.setCourseId(rs.getInt("courseId"));
            course.setDescription(rs.getString("description"));
            course.setPrice(rs.getInt("price"));
            course.setTitle(rs.getString("title"));
            course.setCategoryId(rs.getInt("categoryId"));
            return course;
        });
        return courses;
    }

    //get single course

    public Course getCourse(int courseId) {
        String query = "select * from course where courseId = ?";
        Course courseOp = jdbcTemplate.queryForObject(query, (rs, num) -> {
            Course course = new Course();
            course.setCourseId(rs.getInt("courseId"));
            course.setDescription(rs.getString("description"));
            course.setPrice(rs.getInt("price"));
            course.setTitle(rs.getString("title"));
            course.setCategoryId(rs.getInt("categoryId"));
            return course;
        }, courseId);
        return courseOp;
    }

    public List<Course> getCourseByCategory(int categoryId){
        String query = "select * from course where categoryId = ?";
        List<Course> courseList  = jdbcTemplate.query(query, (rs, num) -> {
            Course course = new Course();
            course.setCourseId(rs.getInt("courseId"));
            course.setDescription(rs.getString("description"));
            course.setPrice(rs.getInt("price"));
            course.setTitle(rs.getString("title"));
            //course.setCategoryId(rs.getInt("categoryId"));
            return course;
        }, categoryId);
        return courseList;
    }

    //update course

    //delete course


    public List<CategoryCourseData> getCategoryCourseData(){
      String query = "SELECT \n" +
              "    c.courseId, \n" +
              "    c.title, \n" +
              "    c.description, \n" +
              "    c.price, \n" +
              "    cat.name AS category_name\n" +
              "FROM \n" +
              "    course c\n" +
              "INNER JOIN \n" +
              "    category cat \n" +
              "ON \n" +
              "    c.categoryId = cat.id;\n";

        List<CategoryCourseData> data = jdbcTemplate.query(query, (rs, rowNum) -> {
            CategoryCourseData categoryCourseData = new CategoryCourseData();
            categoryCourseData.setCategory_name("cat name");
            categoryCourseData.setDescription("cat desc");
            categoryCourseData.setPrice("1000");
            categoryCourseData.setTitle("cat course title");
            categoryCourseData.setCourseId("10");
            return categoryCourseData;
        });
        return data;
    }

    public void insertbatchUpate(List<Course> courseList){
        String insertQuery = "INSERT INTO course (courseId, description, price, title, categoryId) VALUES (?, ?, ?, ?, ?)";
        int[][] ints = jdbcTemplate.batchUpdate(insertQuery, courseList, courseList.size(), ((ps, course) -> {
            ps.setInt(1, course.getCourseId());
            ps.setString(2, course.getDescription());
            ps.setInt(3, course.getPrice());
            ps.setString(4, course.getTitle());
            ps.setInt(5, course.getCategoryId());
        }));
    }
}
