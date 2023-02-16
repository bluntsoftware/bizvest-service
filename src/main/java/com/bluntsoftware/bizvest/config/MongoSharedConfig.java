package com.bluntsoftware.bizvest.config;

import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.bluntsoftware.bizvest.shared.repository"},mongoTemplateRef = "sharedMongoTemplate")
public class MongoSharedConfig {
    @Value("${spring.data.mongodb.database}")
    String dbName;

    @Bean(name = "mongoSharedDBFactory")
    public MongoDatabaseFactory mongoSharedDatabaseFactory(MongoClient client) {
        return new SimpleMongoClientDatabaseFactory(client,dbName);
    }

    @Bean(name = "sharedMongoTemplate")
    public MongoTemplate mongoTemplate(@Qualifier("mongoSharedDBFactory") MongoDatabaseFactory mongoDatabaseFactory) {
        return new MongoTemplate(mongoDatabaseFactory);
    }

}
