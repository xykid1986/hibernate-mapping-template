package com.xiao.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Bidirectional many to many relationship. 
 * @author yi
 *
 */
@Entity
@Table(name="article")
public class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="article_tag",
		joinColumns=@JoinColumn(name="article_id",referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="tag_id",referencedColumnName="id"))
	private Set<Tag> tags;
	
	public Article(){
		this(null);
	}
	
	public Article(String name){
		this.name=name;
		this.tags = new HashSet<Tag>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	@Override
	public String toString(){
		return name+":"+tags.toString();
	}
	
}
