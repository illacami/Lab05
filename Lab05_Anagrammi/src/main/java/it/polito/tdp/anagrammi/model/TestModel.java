package it.polito.tdp.anagrammi.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		String a = "eta";
		
		System.out.println(model.anagrammiCorretti(a));
		System.out.println(model.anagrammiErrati(a));
	}
}
