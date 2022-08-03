package br.com.hobgoblin.clone.discogs.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hobgoblin.clone.discogs.request.input.ArtistImageInputRequest;
import br.com.hobgoblin.clone.discogs.service.contract.ArtistImageServiceInterface;

@RestController
@RequestMapping(value= "/api/v1/artists/images")
public class ArtistImageController {

	@Autowired
	private ArtistImageServiceInterface service;
	
	@PostMapping("add-image")
	public void addImage(@RequestBody ArtistImageInputRequest image) {
		service.addImage(image);
	}
	
	@DeleteMapping("remove-image/{imageId}")
	public void removeImage(@PathVariable Long imageId) {
		service.removeImage(imageId);
	}
}
