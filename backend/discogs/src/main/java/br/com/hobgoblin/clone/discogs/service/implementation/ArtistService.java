package br.com.hobgoblin.clone.discogs.service.implementation;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hobgoblin.clone.discogs.mapper.ArtistMapper;
import br.com.hobgoblin.clone.discogs.repository.contract.jpa.ArtistRepositoryInterface;
import br.com.hobgoblin.clone.discogs.request.ArtistRequest;
import br.com.hobgoblin.clone.discogs.service.contract.ArtistServiceInterface;

@Service
public class ArtistService implements ArtistServiceInterface<ArtistRequest, Long> {
	
	@Autowired
	private ArtistRepositoryInterface repository;

	@Override
	public List<ArtistRequest> findAll() {
		return ArtistMapper.listEntityToListDto(repository.findAll());
	}
	
	@Override
	public ArtistRequest save(ArtistRequest dto) {
		return ArtistMapper.entityToDto(repository.save(ArtistMapper.dtoToEntity(dto)));
	}

	@Override
	public ArtistRequest find(Long identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long identifier) {
		repository.findById(identifier).orElseThrow(() -> {
			throw new EntityNotFoundException();
		});
		repository.deleteById(identifier);
	} 
}
