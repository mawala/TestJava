
public class Author {
  private int id_author;
  private String LastName;
  private String FirstName;
  
  public Author() {}
  
  public Author(String first, String last) {
	  FirstName = first;
	  LastName = last;
  }
  
  public int getId_author() {
	return id_author;
  }
  
  public void setId_author(int id_author) {
	this.id_author = id_author;
  }
  
  public String getLastName() {
	return LastName;
  }
  
  public void setLastName(String lastName) {
	LastName = lastName;
  }
  
  public String getFirstName() {
	return FirstName;
  }
  
  public void setFirstName(String firstName) {
	FirstName = firstName;
  }
}
