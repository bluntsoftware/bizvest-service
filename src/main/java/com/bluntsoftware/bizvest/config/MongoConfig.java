package com.bluntsoftware.bizvest.config;

import com.bluntsoftware.bizvest.tenant.TenantResolver;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoClientFactory;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoDatabaseFactorySupport;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.stream.Collectors;

@Configuration
@EnableMongoRepositories(basePackages = {"com.bluntsoftware.bizvest.repository"},mongoTemplateRef = "mongoTemplate")
public class MongoConfig {
    @Value("${spring.data.mongodb.database}")
    String dbName;
    @Value("${spring.data.mongodb.uri}")
    String mongoUri;
    @Bean
    @Primary
    MongoDatabaseFactorySupport<MongoClient> mongoDbFactory(MongoClient client){
        return new SimpleMongoClientDatabaseFactory(client,dbName){
            @NotNull
            @Override
            public MongoDatabase getMongoDatabase(@NotNull String dbName) {
                return super.getMongoDatabase(dbName + "_" + TenantResolver.resolve());
            }
        };
    }

    @Bean
    public MongoClient mongo( ) {
        final ConnectionString connectionString = new ConnectionString(mongoUri);
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean(name = "mongoTemplate")
    @Primary
    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDatabaseFactory) {
        return new MongoTemplate(mongoDatabaseFactory);
    }
}
