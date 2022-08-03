package br.com.hobgoblin.clone.discogs.service.contract;

import java.util.List;

import br.com.hobgoblin.clone.discogs.request.ArtistImageRequest;
import br.com.hobgoblin.clone.discogs.request.input.ArtistImageInputRequest;

public interface ArtistImageServiceInterface {
	void addImage(ArtistImageInputRequest dto);
	void removeImage(Long imageId);	
	List<ArtistImageRequest> findByArtistId(Long artistId);
}
