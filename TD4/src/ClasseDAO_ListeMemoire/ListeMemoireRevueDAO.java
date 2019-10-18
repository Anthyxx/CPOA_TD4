package ClasseDAO_ListeMemoire;

import java.util.ArrayList;
import java.util.List;

import ClasseDAO.RevueDAO;
import objetMetier.Client;
import objetMetier.Revue;

public class ListeMemoireRevueDAO extends RevueDAO {
	
private static ListeMemoireRevueDAO instance;
	
	private List<Revue> donnees;
	
	public static ListeMemoireRevueDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireRevueDAO();
		}

		return instance;
	}

	private ListeMemoireRevueDAO() {
		this.donnees = new ArrayList<Revue>();
		
		this.donnees.add(new Revue(1,"Picsou","BD",2.5,"visu.png",1));
		this.donnees.add(new Revue(2,"Chasse et Peche","Mag info",3.5,"visu.png",2));
	}
	
	@Override
	public boolean create(Revue objet) {
		// TODO Stub de la méthode généré automatiquement
		objet.setId_revue(3);
		
		while(this.donnees.contains(objet)) {
					objet.setId_revue(objet.getId_revue()+1);
		}
		boolean ok = this.donnees.add(objet);
		return ok;
	}

	@Override
	public boolean update(Revue objet) {
		// TODO Stub de la méthode généré automatiquement
		int idx = this.donnees.indexOf(objet);
		if (idx==-1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistnat");
		}else {
			this.donnees.set(idx, objet);
		}
		return true;
	}

	@Override
	public boolean delete(Revue objet) {
		// TODO Stub de la méthode généré automatiquement
		Revue supprime;
		
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		return objet.equals(supprime);
	}

	@Override
	public Revue getById(int id) {
		// TODO Stub de la méthode généré automatiquement
		int idx = id;
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Revue> getByTitre(String n) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Revue> res = null;
		for(int i=0;i<this.donnees.size();i++) {
			if(this.donnees.get(i).getTitre()==n) {
				res.add(this.donnees.get(i));
			}
		}
		return res;
	}

	@Override
	public ArrayList<Revue> getByTarif_numero(double n) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Revue> res = null;
		for(int i=0;i<this.donnees.size();i++) {
			if(this.donnees.get(i).getTarif_numero()==n) {
				res.add(this.donnees.get(i));
			}
		}
		return res;
	}

	@Override
	public ArrayList<Revue> getById_periodicite(int n) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Revue> res = null;
		for(int i=0;i<this.donnees.size();i++) {
			if(this.donnees.get(i).getId_periodicite()==n) {
				res.add(this.donnees.get(i));
			}
		}
		return res;
	}

}
