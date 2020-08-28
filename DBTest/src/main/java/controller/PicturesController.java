package controller;

import org.springframework.web.bind.annotation.RestController;

import repositories.PicturesRepository;

@RestController
public class PicturesController {
	  private final PicturesRepository repository;
	  
	  PicturesController(PicturesRepository repository) {
	    this.repository = repository;
	  }
}
