package ClasseDAO_ListeMemoire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClasseDAO.PeriodiciteDAO;
import Outils.Connexion;
import javafx.util.Callback;
import objetMetier.Periodicite;

public class ListeMemoirePeriodiciteDAO extends PeriodiciteDAO {

	private static ListeMemoirePeriodiciteDAO instance;

	private List<Periodicite> donnees;


	public static ListeMemoirePeriodiciteDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoirePeriodiciteDAO();
		}

		return instance;
	}

	private ListeMemoirePeriodiciteDAO() {

		this.donnees = new ArrayList<Periodicite>();

		this.donnees.add(new Periodicite(1, "Mensuel"));
		this.donnees.add(new Periodicite(2, "Quotidien"));
	}


	@Override
	public boolean create(Periodicite objet) {
		
		/*objet.setId_periodicite(3);
		// Ne fonctionne que si l'objet métier est bien fait...*/
		while (this.donnees.contains(objet)) {

			objet.setId_periodicite(objet.getId_periodicite() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Periodicite objet) {
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {	
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	@Override
	public boolean delete(Periodicite objet) {

		Periodicite supprime;
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	@Override
	public Periodicite getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Periodicite(id, "test"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possede cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	public ArrayList<Periodicite> findAll() {
		return (ArrayList<Periodicite>) this.donnees;
	}

	@Override
	public ArrayList<Periodicite> getByLibelle(String l) {
		// TODO Stub de la méthode généré automatiquement
		return null;
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
