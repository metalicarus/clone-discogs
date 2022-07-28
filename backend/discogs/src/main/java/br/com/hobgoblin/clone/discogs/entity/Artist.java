package br.com.hobgoblin.clone.discogs.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 150)
	private String realName;
	
	@Column(length = 3000)
	private String profile;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Set<ArtistImage> images;
	
}
