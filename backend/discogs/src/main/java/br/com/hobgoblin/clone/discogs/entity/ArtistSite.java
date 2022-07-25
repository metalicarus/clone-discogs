package br.com.hobgoblin.clone.discogs.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import br.com.hobgoblin.clone.discogs.entity.pk.ArtistSitePk;
import lombok.Data;

@Entity
@Data
public class ArtistSite {
	
	@EmbeddedId
	private ArtistSitePk id;
	
	@MapsId("artistId")
	@ManyToOne
	private Artist artist;
	
}
