package controller;

import org.springframework.web.bind.annotation.RestController;

import repositories.PicturesAndTagsRepository;

@RestController
public class PicturesAndTagsController {
	  private final PicturesAndTagsRepository repository;
	  
	  PicturesAndTagsController(PicturesAndTagsRepository repository) {
	    this.repository = repository;
	  }
	  
}
