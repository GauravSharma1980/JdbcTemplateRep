package com.course.jdbc.management.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CourseDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;



}
