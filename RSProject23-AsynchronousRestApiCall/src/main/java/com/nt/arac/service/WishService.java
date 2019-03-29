package com.nt.arac.service;

import java.util.concurrent.CompletableFuture;

public interface WishService {
     public CompletableFuture<String> sayHello();
     public CompletableFuture<String> sayHi();
}
