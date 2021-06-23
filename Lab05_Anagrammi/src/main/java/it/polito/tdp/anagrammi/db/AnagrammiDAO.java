package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AnagrammiDAO {
	
	public boolean esiste(String parola) {
		
		String sql = "SELECT nome "
				+ "FROM parola "
				+ "WHERE nome = ? ";
		
		String trovata = null;
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				trovata = rs.getString("nome");
			}
			
			
			conn.close();
			st.close();
			rs.close();
			
			if(trovata == null)
				return false;
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
}
