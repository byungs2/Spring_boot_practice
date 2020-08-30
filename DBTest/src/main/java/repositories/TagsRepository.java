package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tagsDTO.Tags;
@Repository
public interface TagsRepository extends JpaRepository<Tags, Long>{
	public Tags findByTagName(String tagName);
}
