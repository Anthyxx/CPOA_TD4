package ClasseDAO;

import java.util.ArrayList;

import objetMetier.Revue;


public abstract class RevueDAO implements DAO<Revue>{
	
	public ArrayList<Revue> getByTitre(String n) {
		return null;
	}
	
	public ArrayList<Revue> getByTarif_numero(double n) {
		return null;
	}
	
	public ArrayList<Revue> getById_periodicite(int n) {
		return null;
	}
	

}
