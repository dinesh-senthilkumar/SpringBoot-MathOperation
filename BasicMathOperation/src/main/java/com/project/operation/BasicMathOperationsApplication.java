package com.project.operation;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasicMathOperationsApplication {
	public static final String READ_PREFERENCE = "secondaryPreferred";
	@Value("${documentDBClusterIp}")
	private String documentDBClusterIp;
	@Value("${dbConnectionString}")
	private String dbConnectionString;

	@Value("${defaultDocumentDBName}")
	private String defaultDocumentDBName;


	public static void main(String[] args) {
		SpringApplication.run(BasicMathOperationsApplication.class, args);
	}

	@Bean
	public String databaseName() {
		return defaultDocumentDBName;
	}


	@Bean
	public MongoClient getMongoClient() {
		return MongoClients.create(String.format(dbConnectionString,
				documentDBClusterIp, READ_PREFERENCE));
	}




}
