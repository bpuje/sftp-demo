package com.example.sftpdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SftpDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SftpDemoApplication.class, args);
		runAsService();
	}
	private static synchronized void runAsService() {
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println(LocalTime.now());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
