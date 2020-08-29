package picturesDTO;

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
import usersDTO.Users;

@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Component
public class Pictures {
	@Id
	@GeneratedValue(generator = "Pictures_seq")
	@SequenceGenerator(name = "Pictures_seq", sequenceName = "Pictures_seq", allocationSize = 1)
	long pictureNumber;
	
	String uploadDate;
	
	@ManyToOne
	@JoinColumn(name = "USERS_ID")
	Users userId;

	public Pictures(long pictureNumber, String uploadDate, Users userId) {
		this.pictureNumber = pictureNumber;
		this.uploadDate = uploadDate;
		this.userId = userId;
	}
	

}
