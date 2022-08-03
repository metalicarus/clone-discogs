package br.com.hobgoblin.clone.discogs.service.contract;

import br.com.hobgoblin.clone.discogs.request.input.ArtistImageInputRequest;

public interface ArtistImageServiceInterface {
	void addImage(ArtistImageInputRequest dto);
	void removeImage(Long imageId);	
}
