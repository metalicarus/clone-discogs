package br.com.hobgoblin.clone.discogs.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.hobgoblin.clone.discogs.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "artists_sites")
@Getter
@Setter
public class ArtistSite extends BaseEntity {
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artist_id", nullable = false)
	private Artist artist;
	
	private String site;
	
}
