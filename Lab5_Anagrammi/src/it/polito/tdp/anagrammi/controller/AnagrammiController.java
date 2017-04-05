package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagrammi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
    private Anagrammi model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;
    @FXML
    private Button btnReset;

    @FXML
    private TextArea txtCorrette;

    @FXML
    private TextArea txtErrate;

    @FXML
    void doReset(ActionEvent event) {
    	     txtParola.clear();
    	     txtCorrette.clear();
         txtErrate.clear();
         model.pulisci();
    }
    
    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	 txtCorrette.clear();
	     txtErrate.clear();
	     model.pulisci();
	     model.calcolaAnagrammi(txtParola.getText(),"",0);
	     for(String c : model.getCorrette())
	     txtCorrette.appendText(c.toString()+"\n");
	     for(String e : model.getErrate())
	    	 txtErrate.appendText(e.toString()+"\n");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorrette != null : "fx:id=\"txtCorrette\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrate != null : "fx:id=\"txtErrate\" was not injected: check your FXML file 'Anagrammi.fxml'.";
  
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";
    }

	public void setModel(Anagrammi modello) {
		this.model = modello;
	      
		
	}
}


