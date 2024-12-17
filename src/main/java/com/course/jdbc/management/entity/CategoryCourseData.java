package com.course.jdbc.management.entity;

public class CategoryCourseData {

    private String courseId;
    private String title;
    private String description;
    private String price;
    private String category_name;

    public CategoryCourseData(String courseId, String title, String description, String price, String category_name) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category_name = category_name;
    }

    public CategoryCourseData() {

    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
