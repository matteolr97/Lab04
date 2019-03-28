package it.polito.tdp.lab04.model;

import java.util.ArrayList;
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

	public List<Studente> getStudentiIscrittiAlCorso(Corso corso){
		CorsoDAO dao = new CorsoDAO();
		
		return dao.getStudentiIscrittiAlCorso(corso);
	}
	public List<Corso> getCorsiDiUnoStudente(int matricola){
		StudenteDAO daos = new StudenteDAO();
				return daos.getCorsiDaStudente(matricola);
			

	}
	public boolean studenteIscrittoAlCorso(Corso corso, int matricola) {
		StudenteDAO stemp = new StudenteDAO();
		if(stemp.getCorsiDaStudente(matricola).contains(corso))
			return true;
		else
			return false;
		/*
		StudenteDAO daos = new StudenteDAO();

		List<Corso> corsiSeguiti = new ArrayList<Corso>();
		corsiSeguiti=daos.getCorsiDaStudente(matricola);
		return corsiSeguiti.contains(corso);
		*/
	}
}
