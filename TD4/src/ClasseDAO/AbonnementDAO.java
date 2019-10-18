package ClasseDAO;

import java.sql.Date;
import java.util.ArrayList;

import objetMetier.Abonnement;

public abstract class AbonnementDAO implements DAO<Abonnement>{
	
	public ArrayList<Abonnement> getByDate_deb(Date db) {
		return null;
	}
	
	public ArrayList<Abonnement> getByDate_fin(Date df) {
		return null;
	}
	
	public ArrayList<Abonnement> getById_client(int idC) {
		return null;
	}
	
	public ArrayList<Abonnement> getById_revue(int idR) {
		return null;
	}
	
	public Abonnement getById(int idC,int idR) {
		return null;
	}
}
