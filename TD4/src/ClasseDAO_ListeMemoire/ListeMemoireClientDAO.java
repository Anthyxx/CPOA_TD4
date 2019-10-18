package ClasseDAO_ListeMemoire;

import java.util.ArrayList;
import java.util.List;

import ClasseDAO.ClientDAO;
import objetMetier.Client;

public class ListeMemoireClientDAO extends ClientDAO{
	
	private static ListeMemoireClientDAO instance;
	
	private List<Client> donnees;
	
	public static ListeMemoireClientDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireClientDAO();
		}

		return instance;
	}
	
	private ListeMemoireClientDAO() {

		this.donnees = new ArrayList<Client>();

		this.donnees.add(new Client(1, "Otmani","Mamar","57","Boucle du Val-Marie","57100","Thionville","France"));
		this.donnees.add(new Client(2, "Vivier","Nicolas","7","Rue du Rhin","57100","Thionville","France"));
	}
	
	@Override
	public boolean create(Client objet) {
		// TODO Stub de la méthode généré automatiquement
		objet.setId_client(3);
		
		while(this.donnees.contains(objet)) {
					objet.setId_client(objet.getId_client()+1);
		}
		boolean ok = this.donnees.add(objet);
		return ok;
	}

	@Override
	public boolean update(Client objet) {
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
	public boolean delete(Client objet) {
		// TODO Stub de la méthode généré automatiquement
		Client supprime;
		
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		return objet.equals(supprime);
	}

	@Override
	public Client getById(int id) {
		// TODO Stub de la méthode généré automatiquement
		//int idx = this.donnees.indexOf(new Client(id,))
		int idx = id;
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Client> getByNom(String n) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Client> res = null;
		for(int i=0;i<this.donnees.size();i++) {
			if(this.donnees.get(i).getNom()==n) {
				res.add(this.donnees.get(i));
			}
		}
		return res;
	}

	@Override
	public ArrayList<Client> getByVille(String n) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Client> res = null;
		for(int i=0;i<this.donnees.size();i++) {
			if(this.donnees.get(i).getVille()==n) {
				res.add(this.donnees.get(i));
			}
		}
		return res;
	}

	@Override
	public ArrayList<Client> getByCode_postal(String n) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Client> res = null;
		for(int i=0;i<this.donnees.size();i++) {
			if(this.donnees.get(i).getCode_postal()==n) {
				res.add(this.donnees.get(i));
			}
		}
		return res;
	}

	@Override
	public ArrayList<Client> getByPays(String n) {
		// TODO Stub de la méthode généré automatiquement
		ArrayList<Client> res = null;
		for(int i=0;i<this.donnees.size();i++) {
			if(this.donnees.get(i).getPays()==n) {
				res.add(this.donnees.get(i));
			}
		}
		return res;
	}
}
