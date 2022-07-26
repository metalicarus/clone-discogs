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

import br.com.hobgoblin.clone.discogs.request.ArtistImageRequest;
import br.com.hobgoblin.clone.discogs.request.input.ArtistImageInputRequest;
import br.com.hobgoblin.clone.discogs.service.contract.ArtistImageServiceInterface;

@RestController
@RequestMapping(value= "/api/v1/artists/images")
public class ArtistImageController {

	@Autowired
	private ArtistImageServiceInterface service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addImage(@RequestBody ArtistImageInputRequest image) {
		service.addImage(image);
	}
	
	@DeleteMapping("{imageId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeImage(@PathVariable Long imageId) {
		service.removeImage(imageId);
	}
	
	@GetMapping("{artistId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<ArtistImageRequest>> findAll(@PathVariable Long artistId) {
		return ResponseEntity.ok(service.findByArtistId(artistId));
	}
}
