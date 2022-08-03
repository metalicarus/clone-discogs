package br.com.hobgoblin.clone.discogs.repository.contract.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hobgoblin.clone.discogs.entity.Artist;
import br.com.hobgoblin.clone.discogs.entity.ArtistNameVariation;

@Repository
public interface ArtistNameVariationRepositoryInterface extends JpaRepository<ArtistNameVariation, Long>{
	List<ArtistNameVariation> findByArtist(Artist artist);
}