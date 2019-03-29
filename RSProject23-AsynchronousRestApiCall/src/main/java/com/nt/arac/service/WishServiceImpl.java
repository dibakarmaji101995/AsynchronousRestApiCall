package com.nt.arac.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("wishService")
public class WishServiceImpl{

	@Async
	public CompletableFuture<String> sayHello() throws InterruptedException {
		System.out.println("sayHello() method execution is started");
		String helloMsg="Hello,Welcome to Spring rest api";
		System.out.println("sayHello() method execution is ended");
		return CompletableFuture.completedFuture(helloMsg);
	}

	@Async
	public CompletableFuture<String> sayHi() {
		System.out.println("sayHi() method execution is started");
		String hiMsg="Hi,Welcome to spring rest api";
		System.out.println("sayHi() method execution is ended");
		return CompletableFuture.completedFuture(hiMsg);
	}

}
