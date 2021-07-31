package com.cg.quiz.service;

import java.util.Set;

import com.cg.quiz.entity.exam.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public Set<Category> getCategory();
	
	public Category  getCategory(Long categoryId);
	
	public void deleteCategory(Long CategoryId);
}
