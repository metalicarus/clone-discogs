package br.com.hobgoblin.clone.discogs.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import br.com.hobgoblin.clone.discogs.entity.pk.ArtistNameVariationPk;
import lombok.Data;

@Entity
@Data
public class ArtistNameVariation {

	@EmbeddedId
	private ArtistNameVariationPk id;
	
	@MapsId("artistId")
	@ManyToOne
	private Artist artist;
	
}
