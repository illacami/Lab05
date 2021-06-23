package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model = new Model();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnAnagrammi;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	
    	String parola = txtParola.getText();
    	
    	if(parola.isEmpty()) {
    		txtParola.setText("INSERIRE PAROLA!");
    		return;
    	}
    	
    	if(!model.parolaEsiste(parola)) {
    		txtAnagrammiCorretti.setText("La parola inserita non è presente nel dizionario, inserire una parola valida");
    		return;
    	}
    	
    	for(String corretta : model.anagrammiCorretti(parola)) 
    		txtAnagrammiCorretti.appendText(corretta+"\n");
    		
    	for(String errata : model.anagrammiErrati(parola))
    		txtAnagrammiErrati.appendText(errata+"\n");
    	
    	return;
    }

    @FXML
    void doReset(ActionEvent event) {
 
    	txtParola.clear();
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
