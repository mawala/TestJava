import java.nio.charset.StandardCharsets;

import org.h2.tools.RunScript;

public class SetupDatabase {
	
	public static final String JDBC_DRIVER = org.h2.Driver.class.getName();
	public static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
	public static final String USER = "sa";
	public static final String PASSWORD = "";
	
	public static void Setup() throws Exception {
		RunScript.execute(JDBC_URL, USER, PASSWORD, "SQLScripts/scheme.sql",StandardCharsets.UTF_8, false);
	}

}
