package br.com.hobgoblin.clone.discogs.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.hobgoblin.clone.discogs.entity.Artist;
import br.com.hobgoblin.clone.discogs.request.ArtistImageRequest;
import br.com.hobgoblin.clone.discogs.request.ArtistNameVariationRequest;
import br.com.hobgoblin.clone.discogs.request.ArtistRequest;
import br.com.hobgoblin.clone.discogs.request.output.ArtistOutputRequest;

public class ArtistMapper {

	public static ArtistRequest.Output entityToDto(Artist entity) {
		ArtistRequest.Output output = ArtistRequest.Output.factory();
		output.setId(entity.getId());
		output.setName(entity.getName());
		output.setProfile(entity.getProfile());
		output.setRealName(entity.getRealName());
		output.setImages(entity.getImages().stream().map(x -> {
			ArtistImageRequest image = new ArtistImageRequest();
			image.setImageUrl(x.getImageUrl());
			return image;
		}).toList());
		output.setVariations(entity.getVariations().stream().map(x -> {
			ArtistNameVariationRequest variation = new ArtistNameVariationRequest();
			variation.setName(x.getName());
			return variation;
		}).toList());
		return output;
	}
	
	public static List<ArtistRequest> listEntityToListDto(List<Artist> entities) {
		return entities.stream().map(entity -> {
			ArtistOutputRequest dto = new ArtistOutputRequest();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setProfile(entity.getProfile());
			dto.setRealName(entity.getRealName());
			return dto;
		}).collect(Collectors.toList());
	}
	
	public static Artist dtoToEntity(ArtistRequest dto) {
		Artist entity = new Artist();
		entity.setName(dto.getName());
		entity.setProfile(dto.getProfile());
		entity.setRealName(dto.getRealName());
		entity.setId(dto.getId());		
		return entity;
	}
}
