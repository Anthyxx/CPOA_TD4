package ClasseDAO_SQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClasseDAO.AbonnementDAO;
import Outils.Connexion;
import objetMetier.Abonnement;


public class MySQLAbonnementDAO extends AbonnementDAO{
	
	private static MySQLAbonnementDAO instance;
	
	public static MySQLAbonnementDAO getInstance() {
		
		if (instance == null) {
			instance = new MySQLAbonnementDAO();
		}
		return instance;
	}

	@Override
	public boolean create(Abonnement objet) {
		// TODO Stub de la méthode généré automatiquement
		
		int nbLignes=0;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("insert into Abonnement(id_client,id_revue,date_debut,date_fin) values(?,?,?,?)");
			requete.setInt(1, objet.getId_client());
			requete.setInt(2, objet.getId_revue());
			requete.setDate(3, objet.getDate_debut());
			requete.setDate(4, objet.getDate_fin());
			
			nbLignes = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}
		catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		if(nbLignes == 1 )return true;
		else
		return false;
	}

	@Override
	public boolean update(Abonnement objet) {
		// TODO Stub de la méthode généré automatiquement
int nbLignes=0;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("Update Abonnement set date_debut=?, date_fin=? where id_client=? and id_revue=?");
			requete.setInt(3, objet.getId_client());
			requete.setInt(4, objet.getId_revue());
			requete.setDate(1, objet.getDate_debut());
			requete.setDate(2, objet.getDate_fin());
			
			nbLignes = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}
		catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		if(nbLignes == 1 )return true;
		else
		return false;
	}

	@Override
	public boolean delete(Abonnement objet) {
		// TODO Stub de la méthode généré automatiquement
		int nbLignes=0;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("Delete from Abonnement where id_client=? and id_revue=?");
			requete.setInt(1, objet.getId_client());
			requete.setInt(2, objet.getId_revue());
			
			nbLignes = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}
		catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		if(nbLignes == 1 )return true;
		else
		return false;
	}

	@Override
	public Abonnement getById(int id) {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

	@Override
	public ArrayList<Abonnement> getByDate_deb(Date db) {
		// TODO Stub de la méthode généré automatiquement
		
		ArrayList<Abonnement> resultat=new ArrayList<Abonnement>();
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("Select * from Abonnement where date_debut=?");
			
			requete.setDate(1, db);
			
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat.add(new Abonnement(res.getInt("id_client"),res.getInt("id_revue"),res.getDate("date_debut"),res.getDate("date_fin")));
			}
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}
		catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		return resultat;
	}

	@Override
	public ArrayList<Abonnement> getByDate_fin(Date df) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Abonnement> resultat=new ArrayList<Abonnement>();
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("Select * from Abonnement where date_fin=?");
			
			requete.setDate(1, df);
			
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat.add(new Abonnement(res.getInt("id_client"),res.getInt("id_revue"),res.getDate("date_debut"),res.getDate("date_fin")));
			}
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}
		catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		return resultat;
	}

	@Override
	public ArrayList<Abonnement> getById_client(int idC) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Abonnement> resultat=new ArrayList<Abonnement>();
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("Select * from Abonnement where id_client=?");
			
			requete.setInt(1, idC);
			
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat.add(new Abonnement(res.getInt("id_client"),res.getInt("id_revue"),res.getDate("date_debut"),res.getDate("date_fin")));
			}
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}
		catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		return resultat;
	}

	@Override
	public ArrayList<Abonnement> getById_revue(int idR) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Abonnement> resultat=new ArrayList<Abonnement>();
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("Select * from Abonnement where id_revue=?");
			
			requete.setInt(1, idR);
			
			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat.add(new Abonnement(res.getInt("id_client"),res.getInt("id_revue"),res.getDate("date_debut"),res.getDate("date_fin")));
			}
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}
		catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		return resultat;
	}

	@Override
	public Abonnement getById(int idC, int idR) {
		// TODO Stub de la méthode généré automatiquement
		Abonnement resultat = null;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("Select * from Abonnement where id_client=? and id_revue=?");
			requete.setInt(1, idC);
			requete.setInt(2, idR);
			
			ResultSet res = requete.executeQuery();
			
			while(res.next()) {
				resultat = new Abonnement(res.getInt("id_client"),res.getInt("id_revue"),res.getDate("date_debut"),res.getDate("date_fin"));
			}
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}
		catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		return resultat;
	}

} 
