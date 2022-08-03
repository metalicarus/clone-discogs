package br.com.hobgoblin.clone.discogs.request;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistRequest {
	private Long id;
	private String name;
	private String realName;
	private String profile;
	
	
	@Getter
	@Setter
	public static class Output extends ArtistRequest{
		private List<ArtistImageRequest> images = new ArrayList<>();
		private List<ArtistNameVariationRequest> variations = new ArrayList<>();
		public static Output factory() {
			return new Output();
		}
	}
	
}
