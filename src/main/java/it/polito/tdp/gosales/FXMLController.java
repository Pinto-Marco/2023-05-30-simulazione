package it.polito.tdp.gosales;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.gosales.model.Arco;
import it.polito.tdp.gosales.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAnalizzaComponente;

    @FXML
    private Button btnCreaGrafo;

    @FXML
    private Button btnSimula;

    @FXML
    private ComboBox<Integer> cmbAnno;

    @FXML
    private ComboBox<String> cmbNazione;

    @FXML
    private ComboBox<String> cmbProdotto;

    @FXML
    private ComboBox<String> cmbRivenditore;

    @FXML
    private TextArea txtArchi;

    @FXML
    private TextField txtN;

    @FXML
    private TextField txtNProdotti;

    @FXML
    private TextField txtQ;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextArea txtVertici;

    @FXML
    void doAnalizzaComponente(ActionEvent event) {
    	String rivenditore=this.cmbRivenditore.getValue();
    	if (rivenditore == "") {
    		this.txtResult.setText("Selezionare un rivenditore");
    		return;
    	}else {
    		Integer dimensione = this.model.getComponenteConnessa(rivenditore).size();
    		this.txtResult.appendText("Componenete analizzata!\n Dimensione:" + dimensione);
    		Integer somma = this.model.getSommaComponenteConnessa(rivenditore);
    		this.txtResult.appendText("\n Somma:" + somma);
    	}

    	
    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	this.txtResult.clear();
    	Integer anno=this.cmbAnno.getValue();
    	String nazione=this.cmbNazione.getValue();
    	String input = this.txtNProdotti.getText();
    	Integer inputNum = 0;
    	Boolean control=false;
    	
    	if (input == "") {
    		this.txtResult.setText("Id inserito non valido.");
    		return;
    	}
    	try {
    		inputNum = Integer.parseInt(input);
    	
    	} catch (NumberFormatException e) {
    		e.printStackTrace();
    		return;
		}
    	if (nazione == "") {
    		this.txtResult.setText("Selezionare una nazione");
    		return;
    	}
    	if (anno == null) {
    		this.txtResult.setText("Selezionare un anno");
    		return;
    	}
    	control=this.model.creaGrafo(anno, nazione, inputNum);
    	List<String> rivenditori= this.model.getVertici();
    	List<Arco> archi= this.model.getArchi();
    	if(control) {
    		this.txtResult.appendText("Grafo creato!\n");
        	this.txtResult.appendText("# Vertici : " + rivenditori.size() + "\n");
        	this.txtResult.appendText("# Archi : " + archi.size() + "\n");
        	this.txtVertici.appendText("I nomi dei rivenditori in ordine alfabetico crescente \n");
        	for(String r:rivenditori) {
        		this.txtVertici.appendText(r+"\n");
        	}
        	this.txtArchi.appendText("I nomi degli archi in ordine crescente di peso \n");
        	for(Arco a:archi) {
        		this.txtArchi.appendText(a.toString()+"\n");
        	}
        	this.cmbRivenditore.getItems().addAll(rivenditori);
        	
        	

    	}else {
    		this.txtResult.appendText("Grafo non creato correttamente!\n");
    	}
    	
    	
    	
    	

    }

    @FXML
    void doSimulazione(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAnalizzaComponente != null : "fx:id=\"btnAnalizzaComponente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbAnno != null : "fx:id=\"cmbAnno\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbNazione != null : "fx:id=\"cmbNazione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbProdotto != null : "fx:id=\"cmbProdotto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbRivenditore != null : "fx:id=\"cmbRivenditore\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArchi != null : "fx:id=\"txtArchi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtN != null : "fx:id=\"txtN\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNProdotti != null : "fx:id=\"txtNProdotti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtQ != null : "fx:id=\"txtQ\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVertici != null : "fx:id=\"txtVertici\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	List<Integer> anno=new ArrayList<Integer>();
    	List<String> nazioni=new ArrayList<String>();
    	anno=this.model.getAnni();
    	nazioni=this.model.getNazioni(); 
    	this.cmbAnno.getItems().clear();
    	this.cmbAnno.getItems().addAll(anno);
    	this.cmbNazione.getItems().clear();
    	if(nazioni.isEmpty()) {
    		this.txtResult.appendText("Problema a caricare le nazioni dei rivenditori presenti nel database");
    	}else {
    		this.cmbNazione.getItems().addAll(nazioni);
    	}
    	
    	
    	
    }

}
