package br.com.hobgoblin.clone.discogs.service.implementation;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hobgoblin.clone.discogs.entity.ArtistSite;
import br.com.hobgoblin.clone.discogs.mapper.ArtistSiteMapper;
import br.com.hobgoblin.clone.discogs.repository.contract.jpa.ArtistRepositoryInterface;
import br.com.hobgoblin.clone.discogs.repository.contract.jpa.ArtistSiteRepositoryInterface;
import br.com.hobgoblin.clone.discogs.request.ArtistSiteRequest;
import br.com.hobgoblin.clone.discogs.request.input.ArtistSiteInputRequest;
import br.com.hobgoblin.clone.discogs.service.contract.ArtistSiteServiceInterface;

@Service
public class ArtistSiteService implements ArtistSiteServiceInterface {
	
	@Autowired
	private ArtistRepositoryInterface artistRepository;
	
	@Autowired
	private ArtistSiteRepositoryInterface repository;

	@Override
	public void addSite(ArtistSiteInputRequest dto) {
		ArtistSite entity = new ArtistSite();
		entity.setSite(dto.getSite());
		entity.setArtist(artistRepository.findById(dto.getArtistId()).orElseThrow(() -> {
			throw new EntityNotFoundException();
		}));
		repository.save(entity);
	}

	@Override
	public void removeSite(Long siteId) {
		repository.findById(siteId).orElseThrow(() -> {
			throw new EntityNotFoundException();
		});
		repository.deleteById(siteId);
	}

	@Override
	public List<ArtistSiteRequest> findByArtistId(Long artistId) {
		return ArtistSiteMapper.listEntityToListDto(repository.findByArtist(artistRepository.findById(artistId).orElseThrow(() -> {
			throw new EntityNotFoundException();
		})));
	}	
}
