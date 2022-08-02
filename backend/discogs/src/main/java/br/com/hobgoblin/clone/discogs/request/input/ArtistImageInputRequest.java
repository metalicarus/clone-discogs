package br.com.hobgoblin.clone.discogs.request.input;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class ArtistImageInputRequest {

	@NonNull
	private Long artistId;
	
	@NonNull
	private String imageUrl;
}
