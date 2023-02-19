package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepositoy;

@Service
public class CategoryServices {

	@Autowired
	private CategoryRepositoy categoryRepositoy;

	public List<Category> findAll() {
		return categoryRepositoy.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = categoryRepositoy.findById(id);
		return obj.get();
	}

}
