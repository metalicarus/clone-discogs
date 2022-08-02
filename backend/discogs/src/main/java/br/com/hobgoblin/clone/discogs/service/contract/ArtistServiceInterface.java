package br.com.hobgoblin.clone.discogs.service.contract;

import br.com.hobgoblin.clone.discogs.request.ArtistRequest;
import br.com.hobgoblin.clone.discogs.request.input.ArtistImageInputRequest;

public interface ArtistServiceInterface extends BaseServiceInterface<ArtistRequest, Long>{
	void addImage(ArtistImageInputRequest dto);
}
