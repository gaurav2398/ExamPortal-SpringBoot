package com.cg.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.quiz.entity.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
