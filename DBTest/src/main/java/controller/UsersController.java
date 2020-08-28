package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	  //모든 회원 검색
	  @GetMapping("/users")
	  public List<Users> getAll(){
		  return repository.findAll();
	  }
	  
	  //회원 가입
	  @PostMapping("/users")
	  public Users newUser(@RequestBody Users newUser) {
		  //회원가입 시 동일 이메일을 가진 정보가 있는지 확인
		  Users user = repository.findByuserEmail(newUser.getUserEmail());
		  if(!(user == null)) {
			  return user;
		  }else {
			  return repository.save(newUser);
		  }
	  }
	  
	  //이메일로 회원 한명 검색
	  @GetMapping("/users/{userEmail}")
	  public Users getOne(@PathVariable String userEmail) {
		  return repository.findByuserEmail(userEmail);
	  }
	  
	  //비밀번호 입력 후 닉네임 혹은 패스워드 변경 로직 구현해야한다 
	  @PutMapping("/users/{userEmail}")
	  public Users updateUser(@RequestBody Users newUser, @PathVariable String userEmail) {
		  Users existingUser = repository.findByuserEmail(userEmail);
		  if(existingUser != null ) {
			  existingUser.setUserName(newUser.getUserName());
			  existingUser.setUserPassword(newUser.getUserPassword());
			  return existingUser;
		  }else {
			  return null;
		  }
		 
	  }
}
