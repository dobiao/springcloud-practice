package com.caicongyang.springcloudapp.dao.mysql.entities;

/**
 * student
 */
public class TStudent {
    /**
     * student.Id
     */
    private Integer id;

    /**
     * student.Name
     */
    private String name;

    /**
     * student.Age
     */
    private Integer age;

    /**
     * student.Id
     *
     * @return the value of student.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * student.Id
     *
     * @param id the value for student.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * student.Name
     *
     * @return the value of student.Name
     */
    public String getName() {
        return name;
    }

    /**
     * student.Name
     *
     * @param name the value for student.Name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * student.Age
     *
     * @return the value of student.Age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * student.Age
     *
     * @param age the value for student.Age
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}