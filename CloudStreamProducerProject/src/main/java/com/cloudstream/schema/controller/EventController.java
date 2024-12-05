package com.cloudstream.schema.controller;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudstream.schema.model.User;

@RestController
public class EventController {

	@Autowired
	private StreamBridge streamBridge;

	@PostMapping("/event")
	public ResponseEntity<String> sendMessage(@RequestBody User user) throws InterruptedException, ExecutionException {

		Message<User> message = MessageBuilder.withPayload(user)
				.setHeader(KafkaHeaders.KEY, UUID.randomUUID().toString()).build();

		boolean sent = streamBridge.send("producer-out-0", message);

		if (sent) {
			return ResponseEntity.status(HttpStatus.OK).body("Message sent!");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Message sending failed!");
		}

	}
}