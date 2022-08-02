package br.com.hobgoblin.clone.discogs.mapper;

import br.com.hobgoblin.clone.discogs.entity.Artist;
import br.com.hobgoblin.clone.discogs.request.ArtistRequest;
import br.com.hobgoblin.clone.discogs.request.output.ArtistOutputRequest;

public class ArtistMapper {

	public static ArtistRequest entityToDto(Artist entity) {
		ArtistOutputRequest dto = new ArtistOutputRequest();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setProfile(entity.getProfile());
		dto.setRealName(entity.getRealName());
		return dto;
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
