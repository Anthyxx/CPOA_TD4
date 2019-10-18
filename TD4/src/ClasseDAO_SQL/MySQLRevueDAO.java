package ClasseDAO_SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClasseDAO.RevueDAO;
import Outils.Connexion;
import objetMetier.Client;
import objetMetier.Periodicite;
import objetMetier.Revue;


public class MySQLRevueDAO extends RevueDAO {

	private static MySQLRevueDAO instance;
	
	
	public static MySQLRevueDAO getInstance() {

		if (instance == null) {
			instance = new MySQLRevueDAO();
		}
		return instance;
	}

	@Override
	public boolean create(Revue objet) {
		
		int nbLignes=0;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("insert into Revue(id_revue,titre,description,tarif_numero,visuel,id_periodicite) values(?,?,?,?,?,?)");

			requete.setInt(1, objet.getId_revue());
			requete.setString(2, objet.getTitre());
			requete.setString(3, objet.getDescription());
			requete.setDouble(4, objet.getTarif_numero());
			requete.setString(5, objet.getVisuel());
			requete.setInt(6, objet.getId_periodicite());

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
	public boolean update(Revue objet) {
		int nbLignes =0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("Update Revue set titre=?, description=?, tarif_numero=?,visuel=?,id_periodicite=? where id_revue=?");

			requete.setInt(6, objet.getId_revue());
			requete.setString(1, objet.getTitre());
			requete.setString(2, objet.getDescription());
			requete.setDouble(3, objet.getTarif_numero());
			requete.setString(4, objet.getVisuel());
			requete.setInt(5, objet.getId_periodicite());

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
	public boolean delete(Revue objet) {
		int nbLignes =0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Revue where id_revue=?");

			requete.setInt(1, objet.getId_revue());

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
	public Revue getById(int id) {
		Revue resultat = null;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Revue where id_revue = ? ");

			requete.setInt(1, id);

			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat = new Revue(res.getInt("id_revue"),res.getString("titre"),res.getString("description"),res.getDouble("tarif_numero"),res.getString("visuel"),res.getInt("id_revue"));
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
	public ArrayList<Revue> getByTitre(String n) {
		ArrayList<Revue> resultat = new ArrayList<Revue>();
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Revue where titre = ? ");

			requete.setString(1, n);

			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat.add(new Revue(res.getInt("id_revue"),res.getString("titre"),res.getString("description"),res.getDouble("tarif_numero"),res.getString("visuel"),res.getInt("id_revue")));
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
	public ArrayList<Revue> getByTarif_numero(double n) {
		ArrayList<Revue> resultat = new ArrayList<Revue>();
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Revue where tarif_numero = ? ");

			requete.setDouble(1, n);

			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat.add(new Revue(res.getInt("id_revue"),res.getString("titre"),res.getString("description"),res.getDouble("tarif_numero"),res.getString("visuel"),res.getInt("id_revue")));
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
	public ArrayList<Revue> getById_periodicite(int n) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Revue> resultat = new ArrayList<Revue>();
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Revue where id_periodicite = ? ");

			requete.setInt(1, n);

			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat.add(new Revue(res.getInt("id_revue"),res.getString("titre"),res.getString("description"),res.getDouble("tarif_numero"),res.getString("visuel"),res.getInt("id_revue")));
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
