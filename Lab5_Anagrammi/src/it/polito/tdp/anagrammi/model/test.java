package it.polito.tdp.anagrammi.model;

public class test {

	public static void main(String[] args) {
		Anagrammi a= new Anagrammi();
		String s = "parola";
        a.calcolaAnagrammi(s, "", 0);
        System.out.println(a.getCorrette().toString());
	}

}
