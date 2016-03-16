package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	public void testConnection_CorrectServer_WithConnection() {
		msm.setConnection(true);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
	}
	
	@Test
	public void testConnection_CorrectServer_WithoutConnection() {
		msm.setConnection(false);
		assertEquals(1, messenger.testConnection(VALID_SERVER));
	}
	
	@Test
	public void testConnection_WrongServer_WithConnection() {
		msm.setConnection(true);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
	}
	
	@Test
	public void testConnection_WrongServer_WithoutConnection() {
		msm.setConnection(false);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
	}
	
	@Test
	public void testConnection_NullServer_WithConnection() {
		msm.setConnection(true);
		assertEquals(1, messenger.testConnection(null));
	}
	
	@Test
	public void testConnection_NullServer_WithoutConnection() {
		msm.setConnection(false);
		assertEquals(1, messenger.testConnection(null));
	}
	
	@Test
	public void checkSendingMessage_CorrectAll_MessageSent() {
		msm.setMessageSent(true);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessage_CorrectAll_MessageNotSent() {
		msm.setMessageSent(false);
		assertEquals(1, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessage_CorrectServer_WrongMessage() {
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessage_CorrectServer_NullMessage() {
		assertEquals(2, messenger.sendMessage(VALID_SERVER, null));
	}
	
	@Test
	public void checkSendingMessage_WrongServer_CorrectMessage() {
		assertEquals(2, messenger.sendMessage(INVALID_SERVER2, VALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessage_WrongServer_WrongMessage() {
		assertEquals(2, messenger.sendMessage(INVALID_SERVER2, INVALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessage_WrongServer_NullMessage() {
		assertEquals(2, messenger.sendMessage(INVALID_SERVER2, null));
	}
	
	@Test
	public void checkSendingMessage_NullServer_CorrectMessage() {
		assertEquals(2, messenger.sendMessage(null, VALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessage_NullServer_WrongMessage() {
		assertEquals(2, messenger.sendMessage(null, INVALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessage_NullServer_NullMessage() {
		assertEquals(2, messenger.sendMessage(null, null));
	}
}
