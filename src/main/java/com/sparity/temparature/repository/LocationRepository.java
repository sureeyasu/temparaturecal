package com.sparity.temparature.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.sparity.temparature.model.Location;

public interface LocationRepository extends Neo4jRepository<Location,Long>{
	
	public Location findByLonAndLat(String longitude,String latitude);

}