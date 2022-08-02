package br.com.hobgoblin.clone.discogs.repository.contract.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hobgoblin.clone.discogs.entity.ArtistImage;

@Repository
public interface ArtistImageRepositoryInterface extends JpaRepository<ArtistImage, Long>{}
