package com.thiagobandeira.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiagobandeira.workshopmongo.domain.User;
import com.thiagobandeira.workshopmongo.dto.UserDto;
import com.thiagobandeira.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {

		List<User> list = service.findall();
		List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable String id) {

		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDto(obj));
	}
	

}
