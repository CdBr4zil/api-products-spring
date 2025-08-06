package com.exemplo.apiproducts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ProductsApiApplication implements CommandLineRunner {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProductsApiApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.setLogStartupInfo(false);
		app.run(args);
	}

	@Override
	public void run(String... args) {
		String port = env.getProperty("server.port", "8080");
		String contextPath = env.getProperty("server.servlet.context-path", "");
		String url = String.format("http://localhost:%s%s", port, contextPath);

		System.out.println("\n----------------------------------------");
		System.out.println("              API INICIADA               " );
		System.out.println("  H2 Console:    " + url + "/h2-console");
		System.out.println("  Swagger UI:    " + url + "/swagger-ui.html");
		System.out.println("----------------------------------------\n");
	}
}