package controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import picturesDTO.Pictures;
import repositories.PicturesRepository;

@RestController
public class PicturesController {
	  private final PicturesRepository repository;
	  
	  PicturesController(PicturesRepository repository) {
	    this.repository = repository;
	  }
	  //Picture 객체 저장
	  @PostMapping("/pictures")
	  public String uploadPicture(@RequestParam("img") MultipartFile img, @RequestBody Pictures newPicture) {
		  try {
			img.transferTo(new File("C:/somewhere/"+newPicture.getPictureNumber()));
			repository.save(newPicture);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		  return "redirect:/something.jsp";
	  }
	  
	  //Picture 삭제 (본인이 올린 사진만)
	  //한번에 여러개 삭제하는 기능 추가 예정
	  //관리자 기능 혹은 신고 기능으로 삭제하는 기능 추가 예정 
	  @DeleteMapping("/pictures/{pictureNumber}")
	  public String deletePicture(@PathVariable long pictureNumber) {
		  Pictures picture = repository.findById(pictureNumber).orElseThrow(()->null);
		  repository.delete(picture);
		  return "redirect:/something.jsp";
	  }
	  
}
