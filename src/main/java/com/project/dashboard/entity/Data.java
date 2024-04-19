package com.project.dashboard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "my_data_table")
@Getter
@Setter

@RequiredArgsConstructor

@ToString
public class Data {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	 private int year;
    private int intensity;
    private String topic;
    private String insight;
    private String url;
    private double added;
    private double published;
    private int relevance;
    private String pestle;
    private String source;
    private String region;
    private String title;
    private int likelihood;
    
    private String country;
    
   
	public Data(Long id, int year, int intensity, String topic, String insight, String url, double added,
			double published, int relevance, String pestle, String source, String region, String title, int likelihood,
			String country, String city, String sector, String swot) {
		super();
		this.id = id;
		this.year = year;
		this.intensity = intensity;
		this.topic = topic;
		this.insight = insight;
		this.url = url;
		this.added = added;
		this.published = published;
		this.relevance = relevance;
		this.pestle = pestle;
		this.source = source;
		this.region = region;
		this.title = title;
		this.likelihood = likelihood;
		this.country = country;
		this.city = city;
		this.sector = sector;
		this.swot = swot;
	}

	private String city;
    private String sector;
    
    private String swot;
    
    
    
    
  

}
