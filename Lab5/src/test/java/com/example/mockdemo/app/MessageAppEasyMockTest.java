package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MessageService;

public class MessageAppEasyMockTest {

	private Messenger messenger;
	private MessageService mockService;
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER2 = "abc";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@Before
	public void setUp() throws Exception {
		mockService = createMock(MessageService.class);
		messenger = new Messenger(mockService);
	}

	@After
	public void tearDown() throws Exception {
		messenger = null;
		mockService = null;
	}

	@Test
	public void testConnectionCorrect() {
		expect(mockService.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS);
		replay(mockService);
		int result = messenger.testConnection(VALID_SERVER);
		assertEquals(0, result);
		verify(mockService);
	}

}
