package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import repositories.PicturesAndTagsRepository;

@RestController
public class PicturesAndTagsController {
	  private final PicturesAndTagsRepository repository;
	  
	  PicturesAndTagsController(PicturesAndTagsRepository repository) {
	    this.repository = repository;
	  }
	  //tagName이 포함된 모든 사진 불러오는 기능
	  @GetMapping("/pictures-and-tags")
	  public String getAll() {
		  
		  return null;
	  }
}
