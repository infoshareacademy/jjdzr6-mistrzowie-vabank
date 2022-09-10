package com.infoshareacademy.mistrzowieVaBank;

import com.infoshareacademy.mistrzowieVaBank.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MistrzowieVaBankApplication {

	public static void main(String[] args) {

		SpringApplication.run(MistrzowieVaBankApplication.class, args);
//
//		User user = new User();
//
//		user.setUsername("admin");
//		user.setPassword("admin");
//		System.out.println(user.getRoles());
	}

}
