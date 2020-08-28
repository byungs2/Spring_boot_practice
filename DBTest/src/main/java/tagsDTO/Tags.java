package tagsDTO;

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
public class Tags {
	@Id
	@GeneratedValue(generator = "Tags_seq")
	@SequenceGenerator(name = "Tags_seq", sequenceName = "Tags_seq", allocationSize = 1)
	long tagNumber;
	String tagName;
	String registerDate;
	public Tags(long tagNumber, String tagName, String registerDate) {
		this.tagNumber = tagNumber;
		this.tagName = tagName;
		this.registerDate = registerDate;
	}
}
