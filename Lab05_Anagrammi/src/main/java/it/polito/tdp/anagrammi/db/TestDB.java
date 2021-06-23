package it.polito.tdp.anagrammi.db;

public class TestDB {

	public static void main(String[] args) {
		/*
		 * This is a main to check the DB connection
		 */

		try {
			String a = "ciao";
			String b = "ziao";
			
			AnagrammiDAO parola = new AnagrammiDAO();
			
			if(parola.esiste(a))
				System.out.println("Trovata la parola "+a);
			
			if(parola.esiste(b)){
				System.out.println("Trovata la parola "+b);
			}else {
				System.out.println("ERRORE! Non ho trovato la parola "+b+" nel dizionario");
			}

		} catch (RuntimeException e) {
			System.err.println("TestDB failed");
		}
	}

}
