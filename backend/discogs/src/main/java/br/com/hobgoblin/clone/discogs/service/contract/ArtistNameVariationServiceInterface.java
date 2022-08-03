package br.com.hobgoblin.clone.discogs.service.contract;

import java.util.List;

import br.com.hobgoblin.clone.discogs.request.ArtistNameVariationRequest;
import br.com.hobgoblin.clone.discogs.request.input.ArtistNameVariationInputRequest;

public interface ArtistNameVariationServiceInterface {
	void addNameVariation(ArtistNameVariationInputRequest dto);
	void removeNameVariation(Long nameVariationId);
	List<ArtistNameVariationRequest> findByArtistId(Long artistId);
}
