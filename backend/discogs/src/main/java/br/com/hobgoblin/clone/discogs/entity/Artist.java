package br.com.hobgoblin.clone.discogs.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.hobgoblin.clone.discogs.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "artists")
@Getter
@Setter
public class Artist extends BaseEntity {
	
	@Column(length = 100)
	private String name;

	@Column(length = 150)
	private String realName;

	@Column(length = 3000)
	private String profile;

    @OneToMany(mappedBy = "artist", orphanRemoval = true)
	private Set<ArtistImage> images = new HashSet<>();
    
    @OneToMany(mappedBy = "artist", orphanRemoval = true)
	private Set<ArtistNameVariation> variations = new HashSet<>();
    
    @OneToMany(mappedBy = "artist", orphanRemoval = true)
	private Set<ArtistSite> sites = new HashSet<>();
    
}
