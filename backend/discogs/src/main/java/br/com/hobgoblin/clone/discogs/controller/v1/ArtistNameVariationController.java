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

import br.com.hobgoblin.clone.discogs.request.ArtistNameVariationRequest;
import br.com.hobgoblin.clone.discogs.request.input.ArtistNameVariationInputRequest;
import br.com.hobgoblin.clone.discogs.service.contract.ArtistNameVariationServiceInterface;

@RestController
@RequestMapping(value= "/api/v1/artists/variations")
public class ArtistNameVariationController {

	@Autowired
	private ArtistNameVariationServiceInterface service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addNameVariation(@RequestBody ArtistNameVariationInputRequest variation) {
		service.addNameVariation(variation);
	}
	
	@DeleteMapping("{variationId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeNameVariation(@PathVariable Long variationId) {
		service.removeNameVariation(variationId);
	}
	
	@GetMapping("{artistId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<ArtistNameVariationRequest>> findAll(@PathVariable Long artistId) {
		return ResponseEntity.ok(service.findByArtistId(artistId));
	}
}
