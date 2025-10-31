package com.example.blogapi;

import org.springframework.boot.SpringApplication;

public class TestBlogapiApplication {

	public static void main(String[] args) {
		SpringApplication.from(BlogapiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
