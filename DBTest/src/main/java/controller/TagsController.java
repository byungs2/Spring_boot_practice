package controller;

import org.springframework.web.bind.annotation.RestController;

import repositories.TagsRepository;

@RestController
public class TagsController {
	  private final TagsRepository repository;
	  
	  TagsController(TagsRepository repository) {
	    this.repository = repository;
	  }
	  
}
