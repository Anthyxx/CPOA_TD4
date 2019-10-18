package Factory;

import ClasseDAO.AbonnementDAO;
import ClasseDAO.ClientDAO;
import ClasseDAO.PeriodiciteDAO;
import ClasseDAO.RevueDAO;
import Outils.Persistance;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(Persistance cible) {
		
		DAOFactory daoF = null;
		
		switch (cible) {
		case MySQL : 
			daoF = new MySQLDAOFactory();
			break;
		case ListeMemoire :
			daoF = new ListeMemoireDAOFactory();
			break;
		}
		
		return daoF;
		
	}
	
	public abstract PeriodiciteDAO getPeriodiciteDAO();
	public abstract ClientDAO getClientDAO();
	public abstract RevueDAO getRevueDAO();
	public abstract AbonnementDAO getAbonnementDAO();

}
