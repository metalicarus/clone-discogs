package br.com.hobgoblin.clone.discogs.service.implementation;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hobgoblin.clone.discogs.entity.ArtistImage;
import br.com.hobgoblin.clone.discogs.repository.contract.jpa.ArtistImageRepositoryInterface;
import br.com.hobgoblin.clone.discogs.repository.contract.jpa.ArtistRepositoryInterface;
import br.com.hobgoblin.clone.discogs.request.input.ArtistImageInputRequest;
import br.com.hobgoblin.clone.discogs.service.contract.ArtistImageServiceInterface;

@Service
public class ArtistImageService implements ArtistImageServiceInterface {
	
	@Autowired
	private ArtistRepositoryInterface artistRepository;

	@Autowired
	private ArtistImageRepositoryInterface repository;
	
	@Override
	public void addImage(ArtistImageInputRequest dto) {
		ArtistImage entity = new ArtistImage();
		entity.setImageUrl(dto.getImageUrl());
		entity.setArtist(artistRepository.findById(dto.getArtistId()).orElseThrow(() -> {
			throw new EntityNotFoundException();
		}));
		repository.save(entity);
	}

	@Override
	public void removeImage(Long imageId) {
		repository.findById(imageId).orElseThrow(() -> {
			throw new EntityNotFoundException();
		});
		repository.deleteById(imageId);
	}
}
