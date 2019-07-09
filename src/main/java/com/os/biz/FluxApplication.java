package com.os.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;

@SpringBootApplication
//@ComponentScan("com.os.biz")
@EnableReactiveMongoRepositories
public class FluxApplication {

	public static void main(String[] args) {
	 SpringApplication.run(FluxApplication.class, args);
		
	}
	@Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }
 
    protected String getDatabaseName() {
        return "iots";
    }
}
