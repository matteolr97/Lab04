package it.polito.tdp.lab04.DAO;

import java.sql.*;

import java.util.*;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	public List<Studente> getAllStudente(){
		final String sql = "SELECT * FROM studente ";
		List<Studente>ltemp = new LinkedList<Studente>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int matricola = rs.getInt("matricola");

				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("CDS");

				Studente c = new Studente(matricola, cognome, nome, cds);
				ltemp.add(c);

			}

			return ltemp;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}

	}
		
	
	public Studente getStudenteDataMatricola(int matricola){
		final String sql = "SELECT nome,cognome,cds FROM studente WHERE matricola = ? ";
		Studente stud = null;
		
		try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, matricola);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			stud = new Studente(matricola, rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS"));
		}
		conn.close();
		
		}catch(SQLException e) {
			throw new RuntimeException("Errore Db");
		}
		return stud;
		
	}
	
	public List<Corso> getCorsiDaStudente(int matricola){
		
		final String sql= "SELECT * FROM corso c, iscrizione i WHERE c.codins = i.codins && i.matricola = ?";
				
		List<Corso>corsi = new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				Corso c = new Corso(codins, numeroCrediti, nome, periodoDidattico);
				corsi.add(c);
				
				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
			}
			rs.close();
			conn.close();
			return corsi;
			
		} catch (SQLException e) {
			 e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}

		
		
		
		
		
	}

}
