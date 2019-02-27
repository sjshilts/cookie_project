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
		DATABASE_URL = "jdbc:mysql://classdb.it.mtu.edu:3307/cookie_project";
	}
	
	//connects to the database
	public Connection connect( String user, String password ) throws SQLException {
		System.out.println( "Before connection statement" );
		Connection connect = null;
		System.out.println( "After connection statement" );
		if ( connect == null ) {
			try {
				System.out.println( "Before getConnection statement" );
                connect = DriverManager.getConnection( DATABASE_URL, getProperties( user, password ) );
                System.out.println( "After getConnection statement" );
            } catch ( SQLException e ) {
                e.printStackTrace( );
            }
		}
		return connect;
	}
	
	//sets up the username, password, and MPS for the connection
	private Properties getProperties( String username, String password ) {
		System.out.println( "Before properties statement" );
		Properties properties = null;
		System.out.println( "After properties statement" );
		if ( properties == null ) {
			System.out.println( "Before propInit statement" );
			properties = new Properties();
			System.out.println( "After propInit statement" );
			System.out.println( "Before setPropUser statement" );
			properties.setProperty( "user", username );
			System.out.println( "After setPropUser statement" );
			System.out.println( "Before setPropPass statement" );
			properties.setProperty( "password", password );
			System.out.println( "After setPropUser statement" );
			System.out.println( "Before maxPooledStatments statement" );
			properties.setProperty( "MaxPooledStatements", MaxPooledStatements );
			System.out.println( "After maxPooledStatements statement" );
		}
		return properties;
	}
}
