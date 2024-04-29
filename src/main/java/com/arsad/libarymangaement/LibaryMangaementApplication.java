package com.arsad.libarymangaement;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibaryMangaementApplication {

	public static void main(String[] args) throws LifecycleException {

		SpringApplication.run(LibaryMangaementApplication.class, args);
		Tomcat tomcat = new Tomcat();
		tomcat.start();
		tomcat.getServer().await();
	}

}
