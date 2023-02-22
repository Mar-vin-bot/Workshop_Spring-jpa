package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepositoy;

@Service
public class UserServices {

	@Autowired
	private UserRepositoy userRepositoy;

	public List<User> findAll() {
		return userRepositoy.findAll();
	}
	
	public User findById(Long id) {
		Optional <User> obj = userRepositoy.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return userRepositoy.save(obj);
	}
	
	public void delete(Long id) {
		userRepositoy.deleteById(id);
	}

	public User update(Long id, User obj) {
		User aux = userRepositoy.getReferenceById(id);
		updateData(aux, obj);
		return userRepositoy.save(aux);
	}

	private void updateData(User aux, User obj) {
		aux.setName(obj.getName());
		aux.setEmail(obj.getEmail());
		aux.setPhone(obj.getPhone());
		
	}
	
}
