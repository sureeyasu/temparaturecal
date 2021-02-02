package com.sparity.temparature.config;
import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*@Configuration
@EnableNeo4jRepositories(basePackages = "com.sparity.temparature.repository")
@EnableTransactionManagement*/
public class Neo4jConfig {

	/*@Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "com.sparity.temparature.model");
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
    	org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
    	.uri("bolt://localhost:7687")
    	.credentials("neo4j", "suresh")
    	.autoIndex("none")
        .build();
    	return configuration;
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
	
	@Value("${NEO4J_URL}")
	String NEO4J_URL;

	@Bean
	public org.neo4j.ogm.config.Configuration getConfiguration() {
		System.out.println("NEO4J_URL = " + this.NEO4J_URL);

		String username = null;
		String password = null;

		if (this.NEO4J_URL.contains("localhost")) {
			username = "neo4j";
			password = "suresh";
		}

		org.neo4j.ogm.config.Configuration configuration = (new Builder()).uri(this.NEO4J_URL)
				.credentials(username, password).autoIndex("none").build();

		return configuration;
	}

	@Bean
	public SessionFactory sessionFactory() {
		return new SessionFactory(this.getConfiguration(),
				new String[] { "com.sparity.temparature.model"});
	}

	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(this.sessionFactory());
	}*/
}