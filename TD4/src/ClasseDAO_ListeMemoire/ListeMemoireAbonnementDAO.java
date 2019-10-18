package ClasseDAO_ListeMemoire;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ClasseDAO.AbonnementDAO;
import objetMetier.Abonnement;
import objetMetier.Client;

public class ListeMemoireAbonnementDAO extends AbonnementDAO {
	
	private static ListeMemoireAbonnementDAO instance;
	
	private List<Abonnement> donnees;
	
	public static ListeMemoireAbonnementDAO getInstance() {
		if (instance == null) {
			instance = new ListeMemoireAbonnementDAO();
		}
		return instance;
	}
	
	private ListeMemoireAbonnementDAO() {
		this.donnees = new ArrayList<Abonnement>();
		this.donnees.add(new Abonnement(1,2,Date.valueOf("2019-01-01"),Date.valueOf("2019-12-31")));
		this.donnees.add(new Abonnement(1,1,Date.valueOf("2019-05-01"),Date.valueOf("2019-10-31")));
	}
	

	public boolean create(Abonnement objet) {
		// TODO Stub de la méthode généré automatiquement
		
		boolean ok = this.donnees.add(objet);
		return ok;
	}

	@Override
	public boolean update(Abonnement objet) {
		// TODO Stub de la méthode généré automatiquement
		for(int i=0;i<this.donnees.size();i++) {
			if((this.donnees.get(i).getId_client()==objet.getId_client())&&(this.donnees.get(i).getId_revue()==objet.getId_revue())) {
				this.donnees.set(i, objet);
			}
		}
		return true;
	}

	@Override
	public boolean delete(Abonnement objet) {
		// TODO Stub de la méthode généré automatiquement
		Abonnement supprime=null;
		for(int i=0;i<this.donnees.size();i++) {
			if((this.donnees.get(i).getId_client()==objet.getId_client())&&(this.donnees.get(i).getId_revue()==objet.getId_revue())) {
				supprime = this.donnees.remove(i);
			}
		}
		return objet.equals(supprime);
	}

	@Override
	public Abonnement getById(int id) {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

	@Override
	public ArrayList<Abonnement> getByDate_deb(Date db) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Abonnement> res = null;
		for(int i=0;i<this.donnees.size();i++) {
			if(this.donnees.get(i).getDate_debut()==db) {
				res.add(this.donnees.get(i));
			}
		}
		return res;
	}

	@Override
	public ArrayList<Abonnement> getByDate_fin(Date df) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Abonnement> res = null;
		for(int i=0;i<this.donnees.size();i++) {
			if(this.donnees.get(i).getDate_fin()==df) {
				res.add(this.donnees.get(i));
			}
		}
		return res;
	}

	@Override
	public ArrayList<Abonnement> getById_client(int idC) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Abonnement> res = null;
		for(int i=0;i<this.donnees.size();i++) {
			if(this.donnees.get(i).getId_client()==idC) {
				res.add(this.donnees.get(i));
			}
		}
		return res;
	}

	@Override
	public ArrayList<Abonnement> getById_revue(int idR) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Abonnement> res = null;
		for(int i=0;i<this.donnees.size();i++) {
			if(this.donnees.get(i).getId_revue()==idR) {
				res.add(this.donnees.get(i));
			}
		}
		return res;
	}

	@Override
	public Abonnement getById(int idC, int idR) {
		// TODO Stub de la méthode généré automatiquement
		for(int i=0;i<this.donnees.size();i++) {
			if((this.donnees.get(i).getId_client()==idC)&&(this.donnees.get(i).getId_revue()==idR)) {
				return this.donnees.get(i);
			}
		}
		return null;
		
	}

}
