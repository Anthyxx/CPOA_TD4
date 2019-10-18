package Factory;

import ClasseDAO.AbonnementDAO;
import ClasseDAO.ClientDAO;
import ClasseDAO.PeriodiciteDAO;
import ClasseDAO.RevueDAO;
import ClasseDAO_SQL.MySQLAbonnementDAO;
import ClasseDAO_SQL.MySQLClientDAO;
import ClasseDAO_SQL.MySQLPeriodiciteDAO;
import ClasseDAO_SQL.MySQLRevueDAO;

public class MySQLDAOFactory extends DAOFactory{

	@Override
	public PeriodiciteDAO getPeriodiciteDAO() {
		// TODO Stub de la méthode généré automatiquement
		return MySQLPeriodiciteDAO.getInstance();
	}

	@Override
	public ClientDAO getClientDAO() {
		// TODO Stub de la méthode généré automatiquement
		return MySQLClientDAO.getInstance();
	}

	@Override
	public RevueDAO getRevueDAO() {
		// TODO Stub de la méthode généré automatiquement
		return MySQLRevueDAO.getInstance();
	}

	@Override
	public AbonnementDAO getAbonnementDAO() {
		// TODO Stub de la méthode généré automatiquement
		return MySQLAbonnementDAO.getInstance();
	}

	
}
