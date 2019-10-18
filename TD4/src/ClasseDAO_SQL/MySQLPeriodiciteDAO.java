package ClasseDAO_SQL;
import objetMetier.Periodicite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClasseDAO.PeriodiciteDAO;
import Outils.Connexion;
import javafx.util.Callback;



public class MySQLPeriodiciteDAO extends PeriodiciteDAO{
	
	private static MySQLPeriodiciteDAO instance;
	
	
	public static MySQLPeriodiciteDAO getInstance() {

		if (instance == null) {
			instance = new MySQLPeriodiciteDAO();
		}
		return instance;
	}
	
	public boolean create(Periodicite P) {
		
		int nbLignes=0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("insert into Periodicite (id_periodicite,libelle) values(?,?)");

			requete.setInt(1, P.getId_periodicite());
			requete.setString(2, P.getLibelle());

			nbLignes = requete.executeUpdate();

			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
		}
		catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		if(nbLignes == 1 )return true;
		else
		return false;
		
	}

	@Override
	public boolean update(Periodicite P) {
		int nbLignes=0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("Update Periodicite set libelle=? where id_periodicite=?");

			requete.setInt(2, P.getId_periodicite());
			requete.setString(1, P.getLibelle());
			
			nbLignes = requete.executeUpdate();

			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		if(nbLignes == 1 )return true;
		else
		return false;
	}


	@Override
	public boolean delete(Periodicite P) {
		int nbLignes=0;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Periodicite where id_periodicite=?");

			requete.setInt(1, P.getId_periodicite());

			nbLignes = requete.executeUpdate();

			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		if(nbLignes == 1 )return true;
		else return false;
	}
	

	@Override
	public Periodicite getById(int id) {
		// TODO Stub de la méthode généré automatiquement
		Periodicite resultat = null;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select libelle from Periodicite where id_periodicite = ? ");

			requete.setInt(1, id);

			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat = new Periodicite(id,res.getString("libelle"));
			}

			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}

		return resultat;
	}
	

	@SuppressWarnings("null")
	@Override
	public ArrayList<Periodicite> getByLibelle(String l) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Periodicite> resultat = new ArrayList<Periodicite>();
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Periodicite where libelle = ? ");

			requete.setString(1, l);

			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat.add(new Periodicite(res.getInt(1),res.getString("libelle")));
			}

			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		return resultat;
}

	@Override
	public ArrayList<Periodicite> getAll() {
		// TODO Stub de la méthode généré automatiquement
				ArrayList<Periodicite> resultat = new ArrayList<Periodicite>();
				
				try {
					Connection laConnexion = Connexion.creeConnexion();
					PreparedStatement requete = laConnexion.prepareStatement("select * from Periodicite ");


					ResultSet res = requete.executeQuery();
					
					while (res.next()) {
						resultat.add(new Periodicite(res.getInt(1),res.getString("libelle")));
					}

					if (requete != null)
						requete.close();
					if (laConnexion != null)
						laConnexion.close();
				} catch (SQLException sqle) {
					System.out.println(sqle.getMessage());
				}
				return resultat;
	}
}
