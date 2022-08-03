package br.com.hobgoblin.clone.discogs.service.contract;

import java.util.List;

import br.com.hobgoblin.clone.discogs.request.ArtistSiteRequest;
import br.com.hobgoblin.clone.discogs.request.input.ArtistSiteInputRequest;

public interface ArtistSiteServiceInterface {
	void addSite(ArtistSiteInputRequest dto);
	void removeSite(Long siteId);
	List<ArtistSiteRequest> findByArtistId(Long artistId);
}
