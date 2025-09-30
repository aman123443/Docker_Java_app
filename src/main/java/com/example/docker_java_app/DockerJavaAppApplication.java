package com.example.docker_java_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// These two annotations are key for our application
@SpringBootApplication
@RestController // This tells Spring that this class will handle web requests
public class DockerJavaAppApplication {

	// This is the main method that starts the entire application
	public static void main(String[] args) {
		SpringApplication.run(DockerJavaAppApplication.class, args);
	}

	// This method creates the webpage endpoint
	@GetMapping("/") // Maps this method to the homepage URL (http://localhost:8080/)
	public String home() {
		return "Hello, Docker with Java! 🐳,Of course. Here is a detailed summary and a set of \"Viva Voce\" (Questions and Answers) that covers everything you did in Experiment 7. This is a perfect document to print and keep for your records.\n" +
				"\n" +
				"Experiment 7: Lab Report and Viva Voce\n" +
				"Title: Introduction to Containerization and Application Deployment using Docker\n" +
				"\n" +
				"Objective: To understand the fundamentals of containerization by packaging a Java Spring Boot web application into a Docker image, running it as a container, and exposing it to the local machine.\n" +
				"\n" +
				"## Summary of Implementation\n" +
				"The experiment was successfully conducted in a series of steps. First, a simple \"Hello World\" web application was created using the Java Spring Boot framework. A Dockerfile was then written in the project's root directory to provide instructions for building a container image. This Dockerfile utilized a multi-stage build process to create an optimized, lightweight final image.\n" +
				"\n" +
				"Using the Docker CLI, the docker build command was executed to create the image from the Dockerfile. After a successful build, the docker run command was used to start a container from the newly created image. During this process, a common port conflict was encountered because another service (Jenkins) was already using the target port (8080).\n" +
				"\n" +
				"The conflict was resolved by modifying the docker run command to map the container to a different host port (8081), demonstrating a practical troubleshooting step. Finally, the application was successfully accessed via a web browser, confirming that the containerized application was running correctly.";

	}
}