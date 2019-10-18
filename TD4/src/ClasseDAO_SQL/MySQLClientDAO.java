package ClasseDAO_SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClasseDAO.ClientDAO;
import Outils.Connexion;
import objetMetier.Client;


public class MySQLClientDAO extends ClientDAO{

	private static MySQLClientDAO instance;
	
	
	public static MySQLClientDAO getInstance() {

		if (instance == null) {
			instance = new MySQLClientDAO();
		}
		return instance;
	}
	
	
	@Override
	public boolean create(Client objet) {
		int nbLignes=0;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("insert into Client(id_client,nom,prenom,no_rue,voie,code_postal, ville,pays) values(?,?,?,?,?,?,?,?)");

			requete.setInt(1, objet.getId_client());
			requete.setString(2, objet.getNom());
			requete.setString(3, objet.getPrenom());
			requete.setString(4, objet.getNo_rue());
			requete.setString(5, objet.getVoie());
			requete.setString(6, objet.getCode_postal());
			requete.setString(7, objet.getVille());
			requete.setString(8, objet.getPays());

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
	public boolean update(Client objet) {
		
		int nbLignes = 0;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("Update Client set nom=?, prenom=?, no_rue=?,voie=?,code_postal=?, ville=?, pays=? where id_client=?");

			requete.setInt(8, objet.getId_client());
			requete.setString(1, objet.getNom());
			requete.setString(2, objet.getPrenom());
			requete.setString(3, objet.getNo_rue());
			requete.setString(4, objet.getVoie());
			requete.setString(5, objet.getCode_postal());
			requete.setString(6, objet.getVille());
			requete.setString(7, objet.getPays());

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
	public boolean delete(Client objet) {
		
		int nbLignes =0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Client where id_client=?");

			requete.setInt(1, objet.getId_client());

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
	public Client getById(int id) {
		
		Client resultat = null;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where id_client = ? ");

			requete.setInt(1, id);

			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat = new Client(res.getInt(1),res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays"));
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
	public ArrayList<Client> getByNom(String n) {
		
		ArrayList<Client> resultat = new ArrayList<Client>();
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from client where nom = ? ");

			requete.setString(1, n);

			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat.add(new Client(res.getInt(1),res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays")));
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
	public ArrayList<Client> getByVille(String n) {
		ArrayList<Client> resultat = new ArrayList<Client>();
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from client where ville = ? ");

			requete.setString(1, n);

			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat.add(new Client(res.getInt(1),res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays")));
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
	public ArrayList<Client> getByCode_postal(String n) {
		ArrayList<Client> resultat = new ArrayList<Client>();
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from client where code_postal= ? ");

			requete.setString(1, n);

			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat.add(new Client(res.getInt(1),res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays")));
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
	public ArrayList<Client> getByPays(String n) {
		ArrayList<Client> resultat = new ArrayList<Client>();
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from client where pays = ? ");

			requete.setString(1, n);

			ResultSet res = requete.executeQuery();
			
			while (res.next()) {
				resultat.add(new Client(res.getInt(1),res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays")));
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
