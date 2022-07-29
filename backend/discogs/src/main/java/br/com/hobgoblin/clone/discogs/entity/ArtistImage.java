package br.com.hobgoblin.clone.discogs.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import br.com.hobgoblin.clone.discogs.entity.pk.ArtistImagePk;
import lombok.Data;

@Entity
@Data
public class ArtistImage {

	@EmbeddedId
	private ArtistImagePk id;
}
