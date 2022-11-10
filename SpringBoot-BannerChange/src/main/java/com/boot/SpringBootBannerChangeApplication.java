package com.boot;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBannerChangeApplication {

	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(SpringBootBannerChangeApplication.class);
		app.setBannerMode(Mode.CONSOLE);
		app.run(args);
	}

}
