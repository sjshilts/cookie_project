package backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


//twitch.tv/blues_522
//please watch my streams
public class dbConnect {

	//basic setup, not sure about max pooled statements
	private String DATABASE_URL;
	private String MaxPooledStatements = "250";
	
	//initialization, not really needed but oh well, better than putting it in every class
	public dbConnect() {
		DATABASE_URL = "jdbc:mysql://classdb.it.mtu.edu:3307/cookie_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	}
	
	//connects to the database
	public Connection connect( String user, String password ) throws SQLException {
		Connection connect = null;
		if ( connect == null ) {
			try {
                connect = DriverManager.getConnection( DATABASE_URL, getProperties( user, password ) );
            } catch ( SQLException e ) {
                e.printStackTrace( );
            }
		}
		return connect;
	}
	
	/**
	 * 
	 * sets up the username, password, and MPS for the connection
	 * @param username
	 * @param password
	 * @return properties for making a connection
	 */
	private Properties getProperties( String username, String password ) {
		Properties properties = null;
		if ( properties == null ) {
			properties = new Properties();
			properties.setProperty( "user", username );
			properties.setProperty( "password", password );
			properties.setProperty( "MaxPooledStatements", MaxPooledStatements );
		}
		return properties;
	}
}
