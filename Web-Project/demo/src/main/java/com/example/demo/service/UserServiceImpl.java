package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	 @Autowired
	    public UserRepository userRepository;

	    @Override
	    public List<User> findAll() {
	        return userRepository.findAll();
	    }

	    @Override
	    public User getUserById(Long id) {
	        Optional<User> optionalUser = userRepository.findById(id);
	        return optionalUser.orElse(null);
	    }

	    @Override
	    public User addUser(User user) {
	        return userRepository.save(user);
	    }

	    @Override
	    public User updateUser(Long id, User user) {
	       User existingUser = getUserById(id);
	        if (existingUser == null) {
	            return null;
	        }
	        existingUser.setEmail(user.getEmail());
	        existingUser.setPwd(user.getPwd());
	        existingUser.setFname(user.getFname());
	        existingUser.setLname(user.getLname());
	        return userRepository.save(existingUser);
	    }

	    @Override
	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }
	    
	   
	    
	    
	
}
