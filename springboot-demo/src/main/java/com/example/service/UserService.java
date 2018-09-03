package com.example.service;

import com.example.domain.User;

public interface UserService {

	Iterable<User> findAll();

	void save(User user);

}
