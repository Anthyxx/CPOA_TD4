package AppRevue;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Factory.DAOFactory;
import Outils.Persistance;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import objetMetier.Periodicite;
import objetMetier.Revue;

public class Controleur {
	
	@FXML
	private TextField txt_titre;
	
	@FXML
	private TextField txt_desc;
	
	@FXML
	private TextField txt_trf;
	
	@FXML
	private ComboBox<?> cb_per;
	
	
	@FXML
	private Button btn_creer;
	
	@FXML
	private Label lbl_nom;
	
	public void initialize (URL location, ResourceBundle resources)
	{
		try {
			DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MySQL);
			this.cb_per.setItems(FXCollections.observableArrayList(dao.getPeriodiciteDAO().getAll()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void creerModele(MouseEvent event) {
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MySQL);
		ArrayList<Periodicite> ListeP = dao.getPeriodiciteDAO().getAll();
		Periodicite perio = null;
        if(verification()) {
        ListeP.forEach((p)-> {if(p.getLibelle()==cb_per.getValue()) perio = p; });
        Revue res = new Revue((int)Math.random(), txt_titre.getText(),txt_desc.getText(),Double.valueOf(txt_trf.getText())," ", perio );
        lbl_nom.setTextFill(Color.BLACK);
        lbl_nom.setText(txt_titre.getText() + " ( "+txt_trf.getText()+" euros)");
        dao.getRevueDAO().create(res);
        }
    }
	
	@FXML 
    private boolean verification() {

        if (txt_titre.getText().trim().isEmpty()) {
            lbl_nom.setTextFill(Color.RED);
            lbl_nom.setText("Le titre doit être renseigné");
            return false;
        }
        if (txt_desc.getText().trim().isEmpty()) {
            lbl_nom.setTextFill(Color.RED);
            lbl_nom.setText("Une description doit être renseignée");
            return false;
        }
        try {
            Double test = Double.valueOf(txt_trf.getText());
        }
        catch (Exception e) {
            lbl_nom.setTextFill(Color.RED);
            lbl_nom.setText("Le tarif n'est pas valide");
            return false;
        }
        if (cb_per.getValue()==null) {
            lbl_nom.setTextFill(Color.RED);
            lbl_nom.setText("Une périodicité doit être renseignée");
            return false;
        }
        return true;

    }
}
