package com.admin.ui.server.admin_ui_server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class AdminUiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminUiServerApplication.class, args);
	}

}
