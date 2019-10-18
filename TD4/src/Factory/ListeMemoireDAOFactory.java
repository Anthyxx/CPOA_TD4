package Factory;

import ClasseDAO.AbonnementDAO;
import ClasseDAO.ClientDAO;
import ClasseDAO.PeriodiciteDAO;
import ClasseDAO.RevueDAO;
import ClasseDAO_ListeMemoire.*;

public class ListeMemoireDAOFactory extends DAOFactory {

	@Override
	public PeriodiciteDAO getPeriodiciteDAO() {
		// TODO Stub de la méthode généré automatiquement
		return ListeMemoirePeriodiciteDAO.getInstance();
	}

	@Override
	public ClientDAO getClientDAO() {
		// TODO Stub de la méthode généré automatiquement
		return ListeMemoireClientDAO.getInstance();
	}

	@Override
	public RevueDAO getRevueDAO() {
		// TODO Stub de la méthode généré automatiquement
		return ListeMemoireRevueDAO.getInstance();
	}

	@Override
	public AbonnementDAO getAbonnementDAO() {
		// TODO Stub de la méthode généré automatiquement
		return ListeMemoireAbonnementDAO.getInstance();
	}
	
	

}
