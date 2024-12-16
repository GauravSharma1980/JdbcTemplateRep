package com.course.jdbc.management.entity;

public class Course {

    private String title;
    private int courseId;
    private String description;
    private int price;

    public Course(String title, int courseId, String description, int price) {
        this.title = title;
        this.courseId = courseId;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

