package br.com.hobgoblin.clone.discogs.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hobgoblin.clone.discogs.entity.Artist;
import br.com.hobgoblin.clone.discogs.repository.contract.jpa.ArtistRepositoryInterface;

@RestController
@RequestMapping(value= "/api/v1/artists")
public class ArtistController {

	@Autowired
	private ArtistRepositoryInterface repository;
	
	@PutMapping
	@PostMapping
	public ResponseEntity<Artist> save(@RequestBody Artist artist) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(artist));
	}
	
	@GetMapping
	public ResponseEntity<List<Artist>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
}
