package com.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mts.entity.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {

}
