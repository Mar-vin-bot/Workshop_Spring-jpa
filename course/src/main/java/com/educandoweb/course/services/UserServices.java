package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepositoy;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServices {

	@Autowired
	private UserRepositoy userRepositoy;

	public List<User> findAll() {
		return userRepositoy.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = userRepositoy.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return userRepositoy.save(obj);
	}

	public void delete(Long id) {
		try {
			userRepositoy.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public User update(Long id, User obj) {
		try {
			User aux = userRepositoy.getReferenceById(id);
			updateData(aux, obj);
			return userRepositoy.save(aux);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User aux, User obj) {
		aux.setName(obj.getName());
		aux.setEmail(obj.getEmail());
		aux.setPhone(obj.getPhone());

	}

}
