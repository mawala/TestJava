package EasyMock;

import java.sql.SQLException;

public class PersonException extends Exception {

	public PersonException(SQLException e){
		super(e);
	}
}
