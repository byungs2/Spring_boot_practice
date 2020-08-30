package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import repositories.PicturesAndTagsRepository;
import repositories.PicturesRepository;
import repositories.TagsRepository;

@RestController
public class PicturesAndTagsController {
	  private final PicturesAndTagsRepository repository;
	  private final PicturesRepository pictureRepository;
	  private final TagsRepository tagRepository;
	  
	  PicturesAndTagsController(PicturesAndTagsRepository repository, PicturesRepository pictureRepository, TagsRepository tagRepository) {
	    this.repository = repository;
	    this.pictureRepository = pictureRepository;
	    this.tagRepository = tagRepository;
	  }
	  
	  //Tags, Pictures Mapping
	  //Picture와 Tag가 생성되는 시점에 Picture와 tag 사이의 관계가 함께 매칭되도록 하려면?
	  @PostMapping("/pictures-and-tags")
	  public void newPicturesAndTags() {
		  
	  }
	  
	  
	  
	  //tagName이 포함된 모든 사진 불러오는 기능
	  //여러개의 태그를 동시에 검색하는 기능도 추가 예정
	  @GetMapping("/pictures-and-tags")
	  public String getPicturesByTagName() {
		  
		  return null;
	  }
}
