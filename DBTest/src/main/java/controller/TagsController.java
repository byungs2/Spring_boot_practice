package controller;

import org.springframework.web.bind.annotation.RestController;

import repositories.TagsRepository;

@RestController
public class TagsController {
	  private final TagsRepository repository;
	  TagsController(TagsRepository repository) {
	    this.repository = repository;
	  }
	  //tagName이 새로운 것일 때 추가하는 기능
	  //이때 RegisterDate는 항상 갱신된다 
	  
	  
	  //tagRegisterDate가 24시간 이내인 경우 트렌드에 출력
	  
	  
	  
}
