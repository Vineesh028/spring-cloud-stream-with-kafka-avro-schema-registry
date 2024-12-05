package com.cloudstream.schema.config;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudstream.schema.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class MessageConsumerConfig {
	
	@Bean
	public Consumer<User> messageConsumer() {
		return message -> {
			log.info("Received " + message);
		};
	}

}
