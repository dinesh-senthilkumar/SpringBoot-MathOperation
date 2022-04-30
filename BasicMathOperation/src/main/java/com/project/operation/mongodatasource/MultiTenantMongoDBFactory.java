package com.project.operation.mongodatasource;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MultiTenantMongoDBFactory extends SimpleMongoClientDatabaseFactory {

    @Autowired
    private MongoDataSources mongoDataSources;

    private static final Logger LOGGER = LogManager.getLogger(MultiTenantMongoDBFactory.class);

    public MultiTenantMongoDBFactory(@Qualifier("getMongoClient") MongoClient mongoClient, String databaseName) {
        super(mongoClient, databaseName);
    }

    @Override
    protected MongoDatabase doGetMongoDatabase(String dbName) {
        LOGGER.info("Default DB Name: {}", dbName);
        return mongoDataSources.getDatabase();
    }
}