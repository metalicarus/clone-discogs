package br.com.hobgoblin.clone.discogs.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistRequest {
	private Long id;
	private String name;
	private String realName;
	private String profile;
}
