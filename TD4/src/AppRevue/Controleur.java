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
	private ComboBox<Periodicite> cb_per;
	
	
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
    void creerModele() {
        try {
            float tarif = Float.parseFloat(txt_trf.getText());
            Revue R = new Revue(txt_titre.getText(), txt_desc.getText(), Integer.parseInt(txt_trf.getText()),
            txt_titre.getText().concat(".jpg"), cb_per.getValue().getId_periodicite());
            try {
                R.setTitre(txt_titre.getText());
            } catch (IllegalArgumentException e) {
                this.lbl_nom.setText(e.getMessage());
                this.lbl_nom.setTextFill(Color.web("red"));
                return;
            }
            try {
                R.setDescription(txt_desc.getText());
            }catch (IllegalArgumentException e) {
                this.lbl_nom.setText(e.getMessage());
                this.lbl_nom.setTextFill(Color.web("red"));
                return;
            }
            R.setTarif_numero(tarif);
            int id_periodicite = (cb_per.getValue()).getId_periodicite();
            R.setId_periodicite(id_periodicite);
            try {
                R.setVisuel(txt_titre.getText() + ".jpg");
            } catch (IllegalArgumentException e) {
                this.lbl_nom.setText(e.getMessage());
                this.lbl_nom.setTextFill(Color.web("red"));
                return;
            }
            this.lbl_nom.setText(R.toString());
            this.lbl_nom.setTextFill(Color.web("black"));

            DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MySQL);
            dao.getRevueDAO().create(R);
        }catch (NumberFormatException nfe) {
            this.lbl_nom.setText("La valeur n'est pas numérique");
            this.lbl_nom.setTextFill(Color.web("red"));
            return;
        }
    }
}
