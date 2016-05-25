import java.util.List;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.h2.message.DbException;
import org.junit.Test;

public class LibraryFunctionsTest extends DatabaseTestCase {

	private Connection jdbcConnection;
	private FlatXmlDataSet loadedDataSet;

    protected IDatabaseConnection getConnection() throws Exception {
		Class.forName("org.h2.Driver");
		jdbcConnection = DriverManager.getConnection("jdbc:h2:mem:test","sa","");
		SetupDatabase.Setup();
		DatabaseConnection result = new DatabaseConnection(jdbcConnection);
		//result.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
		return result;
	}

	protected IDataSet getDataSet() throws Exception {
		loadedDataSet = new FlatXmlDataSet(new File("IDataSets/dbunitData.xml"));
     	return loadedDataSet;
	}
	
	@Test
	public void testHowManyBooks() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		int result = function.HowManyBooks();
		assertEquals(result,2);
	}
	
	@Test
	public void testInsertAuthor() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		Author author = new Author("Czesio", "Kowalski");
		
		boolean result = function.insertAuthor(author);
		
		assertTrue(result);
	}
	
	@Test
	public void testInsertBook_Wrong(){
		LibraryFunctions function = new LibraryFunctions();
		Book book = new Book();
		book.setTitle(null);
		book.setYear(1992);
		try {
			function.insertBook(book);
			assertTrue(false);
		}
		catch(SQLException ex) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testFindBook() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		String title = "W pustyni i w puszczy";
		
		Book result = function.readBookByTitle(title);
	    
		assertEquals(title, result.getTitle());
	}
	
	@Test
	public void testDeleteBook() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		String title = "W pustyni i w puszczy";
		Book book = function.readBookByTitle(title);
		
		boolean result = function.deleteBook(book);
	    
		assertTrue(result);
	}
	
	@Test(expected=SQLException.class)
	public void testDeleteBook_Wrong() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		Book book = new Book();
		book.setId_book(1);
		
		function.deleteBook(book);
	}
	
	@Test
	public void testGetBooksOfAuthor() throws SQLException{
		LibraryFunctions function = new LibraryFunctions();
		Author author = new Author("Czesio", "Kowalski");
		function.insertAuthor(author);
		author = function.readAuthorByLastName("Kowalski");

		Book book = new Book();
		book.setTitle("cos");
		book.setYear(1990);
		function.insertBook(book);
		book = function.readBookByTitle("cos");
		function.addBookToAuthor(author, book);
		
		List<Book> books = function.readBooksOfAuthor(author);

		assertEquals(1, books.size());
		assertEquals("cos", books.get(0).getTitle());
	}
}
