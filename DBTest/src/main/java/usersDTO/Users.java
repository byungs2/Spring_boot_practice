package usersDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Component
public class Users {
	@Id
	@GeneratedValue(generator = "Users_seq")
	@SequenceGenerator(name = "Users_seq", sequenceName = "Users_seq", allocationSize = 1)
	long userNumber;
	String userName;
	String userEmail;
	String userPassword;
	String userRegisterDate;
	public Users(long userNumber, String userName, String userEmail, String userPassword, String userRegisterDate) {
		this.userNumber = userNumber;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRegisterDate = userRegisterDate;
	}


	
	
}
