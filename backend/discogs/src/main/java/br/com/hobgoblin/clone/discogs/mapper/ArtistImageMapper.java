package br.com.hobgoblin.clone.discogs.mapper;

import java.util.List;

import br.com.hobgoblin.clone.discogs.entity.ArtistImage;
import br.com.hobgoblin.clone.discogs.request.ArtistImageRequest;

public class ArtistImageMapper {

	public static ArtistImageRequest entityToDto(ArtistImage image) {
		ArtistImageRequest dto = new ArtistImageRequest();
		dto.setImageUrl(image.getImageUrl());
		return dto;
	}
	
	public static List<ArtistImageRequest> listEntityToListDto(List<ArtistImage> images) {
		return images.stream().map(x -> {
			return entityToDto(x);
		}).toList();
	}
}
