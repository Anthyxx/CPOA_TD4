package Outils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {
	
	public static Connection creeConnexion() {
	
		String url="jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/otmani13u_cpoa";
		String login = "otmani13u_appli";
		String pwd = "31801431";
		Connection maConnexion = null;
		
		url += "?serverTimezone=Europe/Paris";
		
		
		
		try {
			maConnexion = DriverManager.getConnection(url,login,pwd);
		}
		catch (SQLException sqle) {
			System.out.println("Erreur connexion"+sqle.getMessage());
		}
		
		return maConnexion;
		
		
	}
	
}
