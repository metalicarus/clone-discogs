package br.com.hobgoblin.clone.discogs.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hobgoblin.clone.discogs.request.ArtistRequest;
import br.com.hobgoblin.clone.discogs.service.contract.ArtistServiceInterface;

@RestController
@RequestMapping(value= "/api/v1/artists")
public class ArtistController {

	@Autowired
	private ArtistServiceInterface<ArtistRequest, Long> genericService;
	
	@Autowired
	private ArtistServiceInterface<ArtistRequest.Output, Long> outputService;
	
	@PutMapping
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ArtistRequest> save(@RequestBody ArtistRequest artist) {
		return ResponseEntity.ok(genericService.save(artist));
	}
		
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<ArtistRequest>> findAll() {
		return ResponseEntity.ok(genericService.findAll());
	}
	
	@GetMapping("{artistId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ArtistRequest> find(@PathVariable Long artistId) {
		return ResponseEntity.ok(outputService.find(artistId));
	}
	
	@DeleteMapping("{artistId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long artistId) {
		genericService.remove(artistId);
	}
}
