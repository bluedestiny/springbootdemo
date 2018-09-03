package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.es.dao.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository repository;
	@Override
	public Iterable<User> findAll() {
		return repository.findAll();
		
	}
	@Override
	public void save(User user) {
		repository.save(user);
	}
}
