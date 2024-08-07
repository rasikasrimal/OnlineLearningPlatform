package com.learningplatform.learning_platform;

import com.learningplatform.learning_platform.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningPlatformApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LearningPlatformApplication.class, args);
	}


	@Override
	public void run(String... args) {

	}
}
