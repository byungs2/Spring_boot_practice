package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import repositories.UsersRepository;
import usersDTO.Users;

@RestController
public class UsersController {
	  private final UsersRepository repository;
	  
	  UsersController(UsersRepository repository) {
	    this.repository = repository;
	  }
	  
	  
	  //회원 가입
	  @PostMapping("/users")
	  public Users newUser(@RequestBody Users newUser) {
		  //회원가입 시 동일 이메일을 가진 정보가 있는지 확인
		  Users user = repository.findByName(newUser.getUserName());
		  if(!(user == null)) {
			  return user;
		  }else {
			  return repository.save(newUser);
		  }
	  }
	  
	  
}
