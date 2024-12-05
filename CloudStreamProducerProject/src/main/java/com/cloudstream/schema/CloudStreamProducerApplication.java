package com.cloudstream.schema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.schema.registry.client.EnableSchemaRegistryClient;

@SpringBootApplication
@EnableSchemaRegistryClient
public class CloudStreamProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamProducerApplication.class, args);
	}

}
