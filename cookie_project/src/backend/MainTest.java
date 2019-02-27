package backend;

import java.sql.SQLException;

public class MainTest {
	
	public static void main( String[] args ) throws SQLException {
		GetData bills = new GetData( "cvoss", "22@Weirdo53" );
		System.out.println( bills.getOutflow() );
	}

}
