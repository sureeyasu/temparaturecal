package com.sparity.temparature.model;
import java.util.Date;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@NodeEntity
@Data @Getter @Setter
public class Location {

    
    @Id
	@GeneratedValue
    private Long entityId;
       
    private String country;
	private String lat;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-MM hh:mm")
	private Date localtime;
	private String lon;
	private String name;
	private String region;
	private String temparature;

}