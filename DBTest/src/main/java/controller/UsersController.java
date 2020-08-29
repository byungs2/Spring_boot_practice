package controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import repositories.UsersRepository;
import usersDTO.Users;

@RestController
@SessionAttributes({"userNumber"})
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
	  public String newUser(@RequestBody Users newUser) {
		  //회원가입 시 동일 이메일을 가진 정보가 있는지 확인
		  Users user = repository.findByuserEmail(newUser.getUserEmail());
		  if(!(user == null)) {
			  return "redirect:/something.jsp";
		  }else {
			  return "redirect:/something.jsp";
		  }
	  }
	  //로그인
	  @GetMapping("/users/login")
	  public String userLogIn(Model model,@RequestParam("userEmail") String userEmail, @RequestParam("userPassword") String userPassword ) {
		  //입력받은 userEmail과 userPassword로 회원정보 검색
		  Users user = repository.findByuserEmailAnduserPassword(userEmail, userPassword);
		  if(user!=null) {
			  //session 저장
			  model.addAttribute("userNumber", user.getUserNumber());
			  return "redirect:/index.html";
		  }else {
			  //error advice or Exception 객체 생성하여 해당 error advice 객체에서 endview로 redirect or forward로 이동하는 방법이 좋아보인다.
			  return "redirect:/error.jsp";
		  }
		  
	  }
	  //로그아웃
	  @GetMapping("/users/logout")
	  public String userLogOut(SessionStatus status) {
		  status.setComplete();
		  return "redirect:/index.html";
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
