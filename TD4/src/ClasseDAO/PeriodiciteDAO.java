package ClasseDAO;
import java.util.ArrayList;

import javafx.util.Callback;
import objetMetier.*;

public abstract class PeriodiciteDAO implements DAO<Periodicite>{
	
	public ArrayList<Periodicite> getByLibelle(String l) {
		return null;
	}

	public abstract ArrayList<Periodicite> getAll();


}