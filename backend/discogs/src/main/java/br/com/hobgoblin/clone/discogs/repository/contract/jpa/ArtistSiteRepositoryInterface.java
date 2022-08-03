package br.com.hobgoblin.clone.discogs.repository.contract.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hobgoblin.clone.discogs.entity.Artist;
import br.com.hobgoblin.clone.discogs.entity.ArtistSite;

@Repository
public interface ArtistSiteRepositoryInterface extends JpaRepository<ArtistSite, Long>{
	List<ArtistSite> findByArtist(Artist artist);
}
