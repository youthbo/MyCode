package se.plushogskolan.sdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.plushogskolan.sdj.model.User;
import se.plushogskolan.sdj.repository.UserRepository;

@Service
public class UserService {
    
	UserRepository repository;

	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public User createUser(User user){
		return repository.save(user);
	}
	
	public Page<User> getAllUsers(){
		Pageable pageable = new PageRequest(0, 5,Sort.Direction.ASC,"username");
		return repository.findAll(pageable);
	}
	
	
}
