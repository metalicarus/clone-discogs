package br.com.hobgoblin.clone.discogs.mapper;

import java.util.List;

import br.com.hobgoblin.clone.discogs.entity.ArtistSite;
import br.com.hobgoblin.clone.discogs.request.ArtistSiteRequest;

public class ArtistSiteMapper {

	public static ArtistSiteRequest entityToDto(ArtistSite entity) {
		ArtistSiteRequest dto = new ArtistSiteRequest();
		dto.setSite(entity.getSite());
		return dto;
	}
	
	public static List<ArtistSiteRequest> listEntityToListDto(List<ArtistSite> sites) {
		return sites.stream().map(x -> {
			return entityToDto(x);
		}).toList();
	}
}
