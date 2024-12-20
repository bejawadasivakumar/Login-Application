package com.example.demo.service;

import com.example.demo.dto.Userdto;
import com.example.demo.model.User;

public interface UserService {

	User findByUsername(String username);
	User save(Userdto userdto);
}
