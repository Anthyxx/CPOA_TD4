package ClasseDAO;
import java.util.ArrayList;

import objetMetier.Client;

public abstract class ClientDAO implements DAO<Client>{
	
	public ArrayList<Client> getByNom(String n) {
		return null;
	}
	
	public ArrayList<Client> getByVille(String n) {
		return null;
	}
	
	public ArrayList<Client> getByCode_postal(String n) {
		return null;
	}
	
	public ArrayList<Client> getByPays(String n) {
		return null;
	}

}