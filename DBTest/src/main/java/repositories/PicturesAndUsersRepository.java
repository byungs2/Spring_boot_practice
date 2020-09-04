package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pictures.and.usersDTO.PicturesAndUsers;

@Repository
public interface PicturesAndUsersRepository extends JpaRepository<PicturesAndUsers, Long>{

}
