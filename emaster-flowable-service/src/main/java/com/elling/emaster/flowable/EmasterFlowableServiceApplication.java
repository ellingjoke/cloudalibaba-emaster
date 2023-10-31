package com.elling.emaster.flowable;

import org.apache.rocketmq.client.log.ClientLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmasterFlowableServiceApplication {

	public static void main(String[] args) {
		System.setProperty(ClientLogger.CLIENT_LOG_USESLF4J,"true");
		SpringApplication.run(EmasterFlowableServiceApplication.class, args);
	}

}
