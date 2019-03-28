package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	Model model;
	private int matricola;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> comboCorsi;

    @FXML
    private Button btnCerca;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnComplete;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorso;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClear;
    @FXML
    private Button btnVerificaIscrizione;

    @FXML
    void chooseCourse(ActionEvent event) {

    }

    @FXML
    void doCerca(ActionEvent event) {

    	Corso corso = comboCorsi.getValue();
    	List<Studente> studenti = model.getStudentiIscrittiAlCorso(corso);
    	String txt = "";
    	for(Studente s:studenti) {
    		txt+= s.toString()+"\n";
    		txtResult.appendText(txt);
    		
	    	
    

    	}
    }
    @FXML
    void doVerifica(ActionEvent event) {
  
    	matricola = Integer.parseInt(txtMatricola.getText());
		boolean isIscritto = this.model.studenteIscrittoAlCorso(comboCorsi.getValue(), matricola);
    	if(isIscritto==true) {
    		txtResult.appendText("Lo studente "+matricola+" è iscritto al corso "+comboCorsi.getValue().getNome()+"\n");
    	} else {
    		txtResult.appendText("Lo studente "+matricola+" NON è iscritto al corso "+comboCorsi.getValue().getNome()+"\n");
    	}
    	}
    
    

@FXML
    void doRicerca(ActionEvent event) {
	matricola = Integer.parseInt(txtMatricola.getText());

    	List<Corso> corsi = model.getCorsiDiUnoStudente(matricola);
    	String txt = "";
    	for(Corso c:corsi) {
    		txt+=c.toString()+"\n";
    		txtResult.appendText(txt);}

    }
    @FXML
    void doComplete(ActionEvent event) {
    	matricola = Integer.parseInt(txtMatricola.getText());
    	txtNome.setText(model.getStudente(matricola).getNome());
    	txtCognome.setText(model.getStudente(matricola).getCognome());

    }
  

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtResult.clear();
    }

  
    @FXML
    void initialize() {
        assert comboCorsi != null : "fx:id=\"comboCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnComplete != null : "fx:id=\"btnComplete\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorso != null : "fx:id=\"btnCercaCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
      
        assert btnVerificaIscrizione != null : "fx:id=\"btnVerificaIscrizione\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }
    public void setModel(Model model) {
		this.model = model;
		comboCorsi.getItems().addAll(model.getCorsi());
		
		
	}

}
