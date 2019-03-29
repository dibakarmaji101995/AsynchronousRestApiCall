package com.nt.arac.controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.arac.service.WishServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "getWishMessage", description = "This Rest api gives wish messages")
@RestController
public class WishRestController {

	@Autowired(required = true)
	public WishServiceImpl service;

	@ApiOperation(value = "getWishMessage",tags="getWish")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "200|ok"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/wish")
	public String getWistMessage() throws InterruptedException, ExecutionException {
		// invoke service class methods
        CompletableFuture<String> hiMsg=service.sayHello();
        
        
        CompletableFuture<String> helloMsg=service.sayHi();
        
        //this logic is for wait contol for last response then control proced to execute next line
        CompletableFuture.allOf(hiMsg,helloMsg).join();
        //return Both response(wish) together
        return hiMsg.get()+"........"+helloMsg.get();
    }
}
