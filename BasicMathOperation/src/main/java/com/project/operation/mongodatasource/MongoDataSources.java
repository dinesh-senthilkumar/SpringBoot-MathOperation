package com.project.operation.mongodatasource;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MongoDataSources {
    @Value("${defaultDocumentDBName}")
    private String defaultDocumentDBName;

    @Autowired
    private MongoClient mongoClient;

    /**
     * This will get called for each DB operations
     *
     * @return MongoDatabase
     */
    public MongoDatabase getDatabase() {
        return mongoClient.getDatabase(defaultDocumentDBName);
    }
}