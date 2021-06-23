package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammiDAO;

public class Model {

	private AnagrammiDAO dao;
	private Anagrammi angr;
	
	public Model() {
		dao = new AnagrammiDAO();
		angr = new Anagrammi();
	}
	
	public List<String> anagrammiCorretti (String p) {
		
		List<String> anagrammi = new LinkedList<String>(angr.anagrammi(p));
		List<String> corretti = new LinkedList<>();
		
		for(String a : anagrammi)
			if(dao.esiste(a))
				corretti.add(a);
		
		return corretti;
	}
 
 	public List<String> anagrammiErrati (String p) {
		
		List<String> anagrammi = new LinkedList<String>(angr.anagrammi(p));
		List<String> errati = new LinkedList<>();
		
		for(String a : anagrammi)
			if(!dao.esiste(a))
				errati.add(a);
		
		return errati;
	}
 
 	public boolean parolaEsiste(String parola) {
		
		if(dao.esiste(parola))
			return true;
		
		return false;
	}
}
