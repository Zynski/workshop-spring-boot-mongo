package com.zynski.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zynski.workshopmongo.domain.User;
import com.zynski.workshopmongo.dto.UserDTO;
import com.zynski.workshopmongo.repository.UserRepository;
import com.zynski.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		return repo.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
		
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update (User obj) {
		User newObj = repo.findById(obj.getId())
				.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));;
		udateData(newObj,obj);
		return repo.save(newObj);
	}

	private void udateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
	
	
}
