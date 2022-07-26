package br.com.hobgoblin.clone.discogs.repository.contract.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hobgoblin.clone.discogs.entity.Artist;
import br.com.hobgoblin.clone.discogs.entity.ArtistImage;

@Repository
public interface ArtistImageRepositoryInterface extends JpaRepository<ArtistImage, Long>{
	List<ArtistImage> findByArtist(Artist artist);
}
