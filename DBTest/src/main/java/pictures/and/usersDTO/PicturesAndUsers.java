package pictures.and.usersDTO;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import picturesDTO.Pictures;
import usersDTO.Users;

@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Component
public class PicturesAndUsers {
	@Id
	@GeneratedValue(generator = "PicturesAndUsers_seq")
	@SequenceGenerator(name = "PicturesAndUserss_seq", sequenceName = "PicturesAndUsers_seq", allocationSize = 1)
	long pictureanduserNumber;
	
	long likeCounter;
	
	long reportCounter;
	
	@ManyToOne
	@JoinColumn(name = "Liked_PICTURES_ID")
	Pictures likedPictureId;
	
	@ManyToOne
	@JoinColumn(name = "Liked_Users_ID")
	Users likedUserId;

	public PicturesAndUsers(long pictureanduserNumber, long likeCounter,long reportCounter, Pictures likedPictureId, Users likedUserId) {
		this.pictureanduserNumber = pictureanduserNumber;
		this.likeCounter = likeCounter;
		this.reportCounter = reportCounter;
		this.likedPictureId = likedPictureId;
		this.likedUserId = likedUserId;
	}
	
	
}
