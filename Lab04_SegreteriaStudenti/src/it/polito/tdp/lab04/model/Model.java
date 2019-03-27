package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	public List<Corso> getCorsi() {
	CorsoDAO dao = new CorsoDAO();
	return dao.getTuttiICorsi();
	}
	
	
	
	
	public Studente getStudente(int matricola) {
		StudenteDAO daos = new StudenteDAO();
		for(int i = 0 ; i <daos.getAllStudente().size();i++) {
			if(daos.getAllStudente().get(i).getMatricola()==matricola)
				return daos.getAllStudente().get(i);		}
	return null;
	}
}
