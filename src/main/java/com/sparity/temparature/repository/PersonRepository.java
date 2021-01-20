package com.sparity.temparature.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.sparity.temparature.model.Person;

public interface PersonRepository extends Neo4jRepository<Person,Long>{

}