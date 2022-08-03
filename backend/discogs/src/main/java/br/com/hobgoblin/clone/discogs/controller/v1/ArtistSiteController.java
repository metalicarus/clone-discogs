package br.com.hobgoblin.clone.discogs.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hobgoblin.clone.discogs.request.ArtistSiteRequest;
import br.com.hobgoblin.clone.discogs.request.input.ArtistSiteInputRequest;
import br.com.hobgoblin.clone.discogs.service.contract.ArtistSiteServiceInterface;

@RestController
@RequestMapping(value= "/api/v1/artists/sites")
public class ArtistSiteController {

	@Autowired
	private ArtistSiteServiceInterface service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addSite(@RequestBody ArtistSiteInputRequest site) {
		service.addSite(site);
	}
	
	@DeleteMapping("{siteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeSite(@PathVariable Long siteId) {
		service.removeSite(siteId);
	}
	
	@GetMapping("{siteId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<ArtistSiteRequest>> findAll(@PathVariable Long siteId) {
		return ResponseEntity.ok(service.findByArtistId(siteId));
	}
}
