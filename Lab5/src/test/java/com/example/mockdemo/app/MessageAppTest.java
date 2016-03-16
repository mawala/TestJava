package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.messenger.MalformedRecipientException;

public class MessageAppTest {

	private MessageServiceMock msm;
	private Messenger messenger;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER2 = "abc";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Before
	public void setUp() throws Exception {
		msm = new MessageServiceMock();
		messenger = new Messenger(msm);
	}
	
	@After
	public void tearDown() throws Exception {
		messenger = null;
		msm = null;
	}

	@Test
	public void testConnectionCorrectServer_WithConnection() {
		msm.setConnection(true);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
	}
	
	@Test
	public void tesConnectionCorrectServer_WithoutConnection() {
		msm.setConnection(false);
		assertEquals(1, messenger.testConnection(VALID_SERVER));
	}
	
	@Test
	public void tesConnectionWrongServer_WithConnection() {
		msm.setConnection(true);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
	}
	
	@Test
	public void tesConnectionWrongServer_WithoutConnection() {
		msm.setConnection(false);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
	}
	
	@Test
	public void checkSendingMessageCorrect_MessageSent() {
		msm.setMessageSent(true);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessageCorrect_MessageNotSent() {
		msm.setMessageSent(false);
		assertEquals(1, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessageWrongServer() {
		assertEquals(2, messenger.sendMessage(INVALID_SERVER2, VALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessageWrongMessage() {
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessageNullServer() {
		assertEquals(2, messenger.sendMessage(null, VALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessageNullMessage() {
		assertEquals(2, messenger.sendMessage(VALID_SERVER, null));
	}
}
