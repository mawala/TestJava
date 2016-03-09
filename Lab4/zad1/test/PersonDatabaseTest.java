import static org.junit.Assert.*;

import java.sql.SQLException;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import EasyMock.Person;
import EasyMock.PersonDatabaseService;
import EasyMock.PersonException;
import EasyMock.PersonMockServiceImpl;


public class PersonDatabaseTest {

	private PersonMockServiceImpl serv;
	private PersonDatabaseService mockService;
	
	@Before
	public void setUp() throws Exception {
		mockService = EasyMock.createMock(PersonDatabaseService.class);
		serv = new PersonMockServiceImpl();
		serv.setService(mockService);
	}

	@After
	public void tearDown() throws Exception {
		mockService = null;
		serv = null;
	}

	@Test
	public void test() throws SQLException, PersonException {
		Person person = new Person(1, "Jan", 2000);
		EasyMock.expect(mockService.addPerson(person)).andReturn(1);
		EasyMock.replay(mockService);
		boolean result = serv.addPerson(person);
		assertTrue(result);
		EasyMock.verify(mockService);
	}
}
