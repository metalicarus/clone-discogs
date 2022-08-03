package br.com.hobgoblin.clone.discogs.service.implementation;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hobgoblin.clone.discogs.entity.ArtistNameVariation;
import br.com.hobgoblin.clone.discogs.mapper.ArtistNameVariationMapper;
import br.com.hobgoblin.clone.discogs.repository.contract.jpa.ArtistNameVariationRepositoryInterface;
import br.com.hobgoblin.clone.discogs.repository.contract.jpa.ArtistRepositoryInterface;
import br.com.hobgoblin.clone.discogs.request.ArtistNameVariationRequest;
import br.com.hobgoblin.clone.discogs.request.input.ArtistNameVariationInputRequest;
import br.com.hobgoblin.clone.discogs.service.contract.ArtistNameVariationServiceInterface;

@Service
public class ArtistNameVariationService implements ArtistNameVariationServiceInterface {
	
	@Autowired
	private ArtistRepositoryInterface artistRepository;
	
	@Autowired
	private ArtistNameVariationRepositoryInterface repository;

	@Override
	public void addNameVariation(ArtistNameVariationInputRequest dto) {
		ArtistNameVariation entity = new ArtistNameVariation();
		entity.setName(dto.getName());
		entity.setArtist(artistRepository.findById(dto.getArtistId()).orElseThrow(() -> {
			throw new EntityNotFoundException();
		}));
		repository.save(entity);
	}
	
	@Override
	public List<ArtistNameVariationRequest> findByArtistId(Long artistId) {
		return ArtistNameVariationMapper.listEntityToListDto(repository.findByArtist(artistRepository.findById(artistId).orElseThrow(() -> {
			throw new EntityNotFoundException();
		})));
	}
	
	@Override
	public void removeNameVariation(Long nameVariationId) {
		repository.findById(nameVariationId).orElseThrow(() -> {
			throw new EntityNotFoundException();
		});
		repository.deleteById(nameVariationId);
	}
}
