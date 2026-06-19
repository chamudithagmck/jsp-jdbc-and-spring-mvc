package com.university.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

public class RegistrationDaoImpl implements RegistrationDao {

    private final JdbcTemplate jdbcTemplate;

    public RegistrationDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void registerStudent(int studentId, int courseId) {
        String sql = "INSERT INTO registrations (student_id, course_id, date) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, studentId, courseId, LocalDate.now());
    }
}
