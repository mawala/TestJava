import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import EasyMock.Person;
import EasyMock.PersonDatabaseService;
import EasyMock.PersonException;
import EasyMock.PersonMockServiceImpl;
import static org.mockito.Mockito.*;

public class PersonDatabaseTestMockito {

	
	@Mock
	PersonDatabaseService service;
	private PersonMockServiceImpl serv;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		serv = new PersonMockServiceImpl();
		serv.setService(service);
	}

	@After
	public void tearDown() throws Exception {
		service = null;
		serv = null;	
	}

	@Test
	public void AddCorrectTest() throws SQLException, PersonException {
		Person person = new Person(1,"Adam",2500);
		when(service.addPerson(person)).thenReturn(new Integer(1));
		boolean result = serv.addPerson(person);
		assertTrue(result);
		verify(service).addPerson(person);
	}
	
	@Test
	public void AddWrongTest() throws SQLException, PersonException {
		Person person = new Person(1,"Adam",2500);
		when(service.addPerson(person)).thenReturn(new Integer(0));
		boolean result = serv.addPerson(person);
		assertFalse(result);
		verify(service).addPerson(person);
	}
	
	@Test(expected=PersonException.class)
	public void AddExceptionTest() throws SQLException, PersonException{
		Person person = new Person();
		when(service.addPerson(person)).thenThrow(new SQLException());
		boolean result = serv.addPerson(person);
		assertFalse(result);
		verify(service).addPerson(person);
	}
	
	@Test
	public void RemoveCorrectTest() throws SQLException, PersonException {
		int id = 1;
		when(service.remove(id)).thenReturn(new Integer(1));
		boolean result = serv.remove(id);
		assertTrue(result);
		verify(service).remove(id);
	}
	
	@Test
	public void RemoveWrongTest() throws SQLException, PersonException {
		int id = 1;
		when(service.remove(id)).thenReturn(new Integer(0));
		boolean result = serv.remove(id);
		assertFalse(result);
		verify(service).remove(id);
	}
	
	@Test(expected=PersonException.class)
	public void RemoveExceptionTest() throws SQLException, PersonException{
		int id = 1;
		when(service.remove(id)).thenThrow(new SQLException());
		boolean result = serv.remove(id);
		assertFalse(result);
		verify(service).remove(id);
	}

	@Test
	public void ReadCorrectTest() throws SQLException, PersonException {
		int id = 1;
		when(service.read(id)).thenReturn(new Person(1,"Bartek",20));
		boolean result = serv.read(id);
		assertTrue(result);
		verify(service).read(id);
	}
	
	@Test
	public void ReadWrongTest() throws SQLException, PersonException {
		int id = 1;
		when(service.read(id)).thenReturn(null);
		boolean result = serv.read(id);
		assertFalse(result);
		verify(service).read(id);
	}
	
	@Test(expected=PersonException.class)
	public void ReadExceptionTest() throws SQLException, PersonException{
		int id = 1;
		when(service.read(id)).thenThrow(new SQLException());
		boolean result = serv.read(id);
		assertFalse(result);
		verify(service).read(id);
	}
	
	@Test
	public void UpdateCorrectTest() throws SQLException, PersonException {
		int id = 1;
		when(service.update(id)).thenReturn(new Integer(1));
		boolean result = serv.update(id);
		assertTrue(result);
		verify(service).update(id);
	}
	
	@Test
	public void UpdateWrongTest() throws SQLException, PersonException {
		int id = 1;
		when(service.update(id)).thenReturn(new Integer(0));
		boolean result = serv.update(id);
		assertFalse(result);
		verify(service).update(id);
	}
	
	@Test(expected=PersonException.class)
	public void UpdateExceptionTest() throws SQLException, PersonException{
		int id = 1;
		when(service.update(id)).thenThrow(new SQLException());
		boolean result = serv.update(id);
		assertFalse(result);
		verify(service).update(id);
	}
}