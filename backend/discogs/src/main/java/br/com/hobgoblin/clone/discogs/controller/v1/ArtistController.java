package br.com.hobgoblin.clone.discogs.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<ArtistRequest> save(@RequestBody ArtistRequest artist) {
		return ResponseEntity.status(HttpStatus.CREATED).body(genericService.save(artist));
	}
		
	@GetMapping
	public ResponseEntity<List<ArtistRequest>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(genericService.findAll());
	}
	
	@GetMapping("{artistId}")
	public ResponseEntity<ArtistRequest> find(@PathVariable Long artistId) {
		return ResponseEntity.status(HttpStatus.OK).body(outputService.find(artistId));
	}
}
