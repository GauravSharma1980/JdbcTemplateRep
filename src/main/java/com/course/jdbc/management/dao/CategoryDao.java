package com.course.jdbc.management.dao;


import com.course.jdbc.management.entity.Category;
import com.course.jdbc.management.mapper.CategoryRowMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @PostConstruct
    private void init(){
        String query = "CREATE TABLE IF NOT EXISTS category ( id INT PRIMARY KEY, name VARCHAR(255) NOT NULL )";
        jdbcTemplate.update(query);
    }

    //save

    public void save(Category category){
        String query = "insert into Category(id,name) values(?,?)";
        int updatedRows = jdbcTemplate.update(query, category.getId(), category.getName());
        System.out.println("rows affacted"+updatedRows);
    }

    public void update(Category toBeUpdatedCategory){
        String query = "update Category set name = ? where id = ?";
        int updatedRows = jdbcTemplate.update(query,toBeUpdatedCategory.getName(),toBeUpdatedCategory.getId());
        System.out.println("rows affacted after doing update"+updatedRows);
    }

    //get all categories

    public List<Category> getCategories(){
        String query = "select * from Category";
        List categories = jdbcTemplate.queryForList(query);
        return categories;

    }

    public List<Category> getCategoriesUsingRowMapper(){
        String query = "select * from Category";
        List categories = jdbcTemplate.query(query,new CategoryRowMapper());
        return categories;

    }

    public Category getCategoryById(String categoryId){
        String query = "select * from Category where id = ?";
        Category category = jdbcTemplate.queryForObject(query,Category.class,categoryId);
        return category;
    }

    public Category getCategoryByIdUsingRowMapper(String categoryId){
        String query = "select * from Category where id = ?";
        Category category = (Category) jdbcTemplate.queryForObject(query,new CategoryRowMapper(),categoryId);
        return category;
    }

    public void deleteCategory(String categoryId){
        String query = "delete from Category where id = ?";
        jdbcTemplate.update(query);
    }

}
