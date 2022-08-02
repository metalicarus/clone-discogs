package br.com.hobgoblin.clone.discogs.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hobgoblin.clone.discogs.entity.ArtistImage;
import br.com.hobgoblin.clone.discogs.mapper.ArtistMapper;
import br.com.hobgoblin.clone.discogs.repository.contract.jpa.ArtistImageRepositoryInterface;
import br.com.hobgoblin.clone.discogs.repository.contract.jpa.ArtistRepositoryInterface;
import br.com.hobgoblin.clone.discogs.request.ArtistRequest;
import br.com.hobgoblin.clone.discogs.request.input.ArtistImageInputRequest;
import br.com.hobgoblin.clone.discogs.service.contract.ArtistServiceInterface;

@Service
public class ArtistService implements ArtistServiceInterface {
	
	@Autowired
	private ArtistImageRepositoryInterface artistImageRepository;
	
	@Autowired
	private ArtistRepositoryInterface repository;

	@Override
	public List<ArtistRequest> findAll() {
		return repository.findAll().stream().map(x -> {
			return ArtistMapper.entityToDto(x);
		}).collect(Collectors.toList());
	}
	
	@Override
	public ArtistRequest save(ArtistRequest dto) {
		return ArtistMapper.entityToDto(repository.save(ArtistMapper.dtoToEntity(dto)));
	}

	@Override
	public ArtistRequest find(Long identifier) {
		return ArtistMapper.entityToDto(repository.findById(identifier).orElseThrow(() -> {
			throw new EntityNotFoundException();
		}));
	}

	@Override
	public void addImage(ArtistImageInputRequest dto) {
		ArtistImage entity = new ArtistImage();
		entity.setImageUrl(dto.getImageUrl());
		entity.setArtist(repository.findById(dto.getArtistId()).orElseThrow(() -> {
			throw new EntityNotFoundException();
		}));
		artistImageRepository.save(entity);
	}
}
