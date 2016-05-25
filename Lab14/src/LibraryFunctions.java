import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LibraryFunctions {

  private Connection getConnection() throws SQLException {
	  return DriverManager.getConnection("jdbc:h2:mem:test","sa","");
  }
 
  public int HowManyBooks() throws SQLException {
	Statement stmt = getConnection().createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM Books;");
	int howBooks = 0;
	while(rs.next()){
		howBooks++;
	}
	getConnection().close();
	return howBooks;
  }
  
  public boolean insertAuthor(Author author) throws SQLException {
	PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO Authors(firstname, lastname) VALUES (?,?);");
	stmt.setString(1, author.getFirstName());
	stmt.setString(2, author.getLastName());
	int rs = stmt.executeUpdate();
	return rs != 0;
  }
  
  public boolean insertBook(Book book) throws SQLException {
		PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO Books(title, year) VALUES (?,?);");
		stmt.setString(1, book.getTitle());
		stmt.setInt(2, book.getYear());
		int rs = stmt.executeUpdate();
		return rs != 0;
  }
  
  public boolean deleteBook(Book book) throws SQLException {
		PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM Books WHERE id_book=?;");
		stmt.setInt(1, book.getId_book());
		int rs = stmt.executeUpdate();
		return rs != 0;
  }
  
  public Book readBookByTitle(String title) throws SQLException {
	  PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Books WHERE title=?;");
	  stmt.setString(1, title);
	  ResultSet rs = stmt.executeQuery();
	  Book book = new Book();
	  if(rs.next()){
		  book.setId_book(rs.getInt("id_book"));
		  book.setTitle(rs.getString("title"));
		  book.setYear(rs.getInt("year"));
	  }
	  else {
		  book = null;
	  }
	  getConnection().close();
	  return book;
  }
  
  public Author readAuthorByLastName(String name) throws SQLException {
	  PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Authors WHERE lastname=?;");
	  stmt.setString(1, name);
	  ResultSet rs = stmt.executeQuery();
	  Author author = new Author();
	  if(rs.next()){
		  author.setId_author(rs.getInt("id_author"));
		  author.setFirstName(rs.getString("firstname"));
		  author.setLastName(rs.getString("lastname"));
	  }
	  else {
		  author = null;
	  }
	  getConnection().close();
	  return author;
  }
  
  public boolean addBookToAuthor(Author author, Book book) throws SQLException {
	  PreparedStatement stmt =
	    getConnection().prepareStatement("INSERT INTO Books_has_authors VALUES(?,?);");
	  stmt.setInt(1, book.getId_book());
	  stmt.setInt(2, author.getId_author());
	  int rs = stmt.executeUpdate();
	  return rs != 0;
  }
  
  public List<Book> readBooksOfAuthor(Author author) throws SQLException {
	  PreparedStatement stmt =
	    getConnection().prepareStatement("SELECT b.id_book, b.title, b.year FROM Books b JOIN Books_has_authors ba ON b.id_book=ba.Books_id_book WHERE ba.Authors_id_author=?;");
	  stmt.setInt(1, author.getId_author());
	  ResultSet rs = stmt.executeQuery();
	  List<Book> books = new ArrayList<Book>();
	  while(rs.next()){
		  Book book = new Book();
		  book.setId_book(rs.getInt("id_book"));
		  book.setTitle(rs.getString("title"));
		  book.setYear(rs.getInt("year"));
		  books.add(book);
	  }
	  getConnection().close();
	  return books;
  }
}
