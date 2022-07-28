package br.com.hobgoblin.clone.discogs.repository.contract.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hobgoblin.clone.discogs.entity.Artist;

@Repository
public interface ArtistRepositoryInterface extends JpaRepository<Artist, Long>{}
