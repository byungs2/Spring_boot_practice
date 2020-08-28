package runApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan(basePackages = {"usersDTO","tagsDTO","profilesDTO","picturesDTO","pictures.and.tagsDTO","followersDTO","favorite.picturesDTO"})
@ComponentScan(basePackages = {"controller","repositories","usersDTO","tagsDTO","profilesDTO","picturesDTO","pictures.and.tagsDTO","followersDTO","favorite.picturesDTO"})
public class DbTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbTestApplication.class, args);
	}

}
