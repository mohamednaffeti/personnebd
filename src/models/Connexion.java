package models;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
public class Connexion {
	public static Connection connect() {
		Connection cnx=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/personnebd";
			String username="root";
			String password="";
			
			cnx = (Connection) DriverManager.getConnection(url,username,password);
		
		} catch (Exception e) {
			
			System.out.println("erreur : "+e.getMessage());
		}
		
		return cnx;
		
		
		
		
		
		
	}

}
