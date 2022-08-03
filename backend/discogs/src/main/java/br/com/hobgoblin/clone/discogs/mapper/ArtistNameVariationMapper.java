package br.com.hobgoblin.clone.discogs.mapper;

import java.util.List;

import br.com.hobgoblin.clone.discogs.entity.ArtistNameVariation;
import br.com.hobgoblin.clone.discogs.request.ArtistNameVariationRequest;

public class ArtistNameVariationMapper {

	public static ArtistNameVariationRequest entityToDto(ArtistNameVariation entity) {
		ArtistNameVariationRequest dto = new ArtistNameVariationRequest();
		dto.setName(entity.getName());
		return dto;
	}
	
	public static List<ArtistNameVariationRequest> listEntityToListDto(List<ArtistNameVariation> variations) {
		return variations.stream().map(x -> {
			return entityToDto(x);
		}).toList();
	}
}
