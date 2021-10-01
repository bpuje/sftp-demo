package com.example.sftpdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SftpDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SftpDemoApplication.class, args);
		System.out.println("Success");
		runAsService();
	}
	private static synchronized void runAsService() {
		while (true) {
			try {
				TimeUnit.MINUTES.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
