package br.com.hobgoblin.clone.discogs.service.implementation;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hobgoblin.clone.discogs.mapper.ArtistMapper;
import br.com.hobgoblin.clone.discogs.repository.contract.jpa.ArtistRepositoryInterface;
import br.com.hobgoblin.clone.discogs.request.ArtistRequest;
import br.com.hobgoblin.clone.discogs.request.ArtistRequest.Output;
import br.com.hobgoblin.clone.discogs.service.contract.ArtistServiceInterface;

@Service
public class ArtistOutputService implements ArtistServiceInterface<ArtistRequest.Output, Long> {

	@Autowired
	private ArtistRepositoryInterface repository;
	
	@Override
	public Output save(Output dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Output find(Long identifier) {
		return ArtistMapper.entityToDto(repository.findById(identifier).orElseThrow(() -> {
			throw new EntityNotFoundException();
		}));
	}

	@Override
	public List<Output> findAll() {
		// TODO Auto-generated method stub
		return null;
	}	
}
