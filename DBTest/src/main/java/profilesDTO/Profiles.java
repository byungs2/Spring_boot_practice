package profilesDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class Profiles {
	@Id
	@GeneratedValue(generator = "Profiles_seq")
	@SequenceGenerator(name = "Profiles_seq", sequenceName = "Profiles_seq", allocationSize = 1)
	long profileNumber;
	
	String selfPicture;
	String introduction;
	String snsLink1;
	String snsLink2;
	String snsLink3;
	
	@OneToOne
	@JoinColumn(name = "USERS_ID")
	Users userId;

	public Profiles(long profileNumber, String selfPicture, String introduction, String snsLink1, String snsLink2,
			String snsLink3, Users userId) {
		super();
		this.profileNumber = profileNumber;
		this.selfPicture = selfPicture;
		this.introduction = introduction;
		this.snsLink1 = snsLink1;
		this.snsLink2 = snsLink2;
		this.snsLink3 = snsLink3;
		this.userId = userId;
	}
	
}
