package com.example.mockdemo.app;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import static org.junit.Assert.*;

import org.junit.Test;

public class MySteps extends Steps{
	
	Messenger test;
	MessageServiceMock ms;
	Integer result;
	String server, message;
	
	@BeforeStory
	public void setUp(){
		ms = new MessageServiceMock();
		test = new Messenger(ms);
		result = null;
		server = null;
		message = null;
	}
	
	@Given("server's address by $server")
	public void givenServersAddressByserver(String server){
		 this.server = server;
	}
	
	@Given("good connection")
	public void givenGoodConnection(){
		 ms.setConnection(true);
	}
	
	@Given("bad connection")
	public void givenBadConnection(){
		 ms.setConnection(false);
	}
	
	@Given("message by $message")
	public void givenMessageBymessage(String message){
		 this.message = message;
	}
	
	@When("messenger sends message")
	public void whenMessengerSendsMessage(){
		 result = test.sendMessage(server, message);
	}
	
	@When("message can be sent")
	public void whenMessageCanBeSent(){
		 ms.setMessageSent(true);
	}
	
	@When("message cannot be sent")
	public void whenMessageCannotBeSent(){
		ms.setMessageSent(false);
	}
	
	@When("connection of this server is tested")
	public void whenConnectionOfThisServerIsTested(){
		result = test.testConnection(server);
	}
	
	@Then("result should equal $result")
	public void thenTestConnectionShouldReturnresult(Integer result){
		assertEquals(result, this.result);
	}	
}