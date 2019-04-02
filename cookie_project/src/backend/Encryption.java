package backend;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Encryption {
	public static void main ( String[] args ) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println( "Enter a user name: " );
		String username = sc.nextLine();
		System.out.println( "\nEnter a password: ");
		String password = sc.nextLine();
		String test = salt( username, password );
		dbConnect dbC = new dbConnect();
		Connection conn = dbC.connect( "cvoss", "P@ssw0rd" );
		String stmt = "UPDATE Users SET password = ? WHERE Accnum = 2";
		PreparedStatement ps = conn.prepareStatement( stmt );
		try {
			MessageDigest md = MessageDigest.getInstance( "SHA-256" );
			byte[] digestedMessage = md.digest( test.getBytes() );
			BigInteger bi = new BigInteger( 1, digestedMessage );
			String hash = bi.toString( 16 );
			while ( hash.length() < 32 ) {
				hash = "0" + hash;
			}
			ps.setString( 1, hash );
			ps.executeUpdate();
			System.out.println( "\n" + hash + "\n" );
		} catch ( NoSuchAlgorithmException e ){
			e.printStackTrace();
		}
		System.exit( 0 );
	}
	
	private static String salt( String s1, String s2 ) {
		String newString = null;
		if ( s2.length() == s1.length() ) {
			for ( int i = 0; i < s1.length(); i++ ) {
				newString = newString + s2.substring( i, i+1 ) + s1.substring( i, i+1 );
			}
		} else {
			int diff = 0;
			if ( s2.length() > s1.length() ) {
				diff = s2.length() - s1.length();
				for ( int i = 0; i < diff; i++ ) {
					s1 = s1 + "z";
				}
			} else {
				diff = s1.length() - s2.length();
				for ( int i = 0; i < diff; i++ ) {
					s2 = s2 + "a";
				}
			}
			for ( int i = 0; i < s1.length(); i++ ) {
				newString = newString + s2.substring( i, i+1 ) + s1.substring( i, i+1 );
			}
		}
		return newString;
	}
}
