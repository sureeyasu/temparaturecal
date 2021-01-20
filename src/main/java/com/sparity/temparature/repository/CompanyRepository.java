package com.sparity.temparature.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.sparity.temparature.model.Company;

public interface CompanyRepository extends Neo4jRepository<Company,Long>{

}