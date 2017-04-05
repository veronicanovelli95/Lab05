package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.dao.AnagrammaDAO;

public class Anagrammi {
   
	List<String> corrette;
	List<String> errate;
	AnagrammaDAO aD = new AnagrammaDAO();
	List<String> parole;
	
	
	
	public Anagrammi() {
		super();
		corrette = new LinkedList<String>();
		errate = new LinkedList<String>();
		parole=new LinkedList(aD.parole());
	}




	public void calcolaAnagrammi(String text, String parziale,int livello ) {
	   
		
	
		if(parziale.length()==text.length()&&(!corrette.contains(parziale))){
			if(isCorrect(parziale)==true)
			corrette.add(parziale);
			if(isCorrect(parziale)==false)
			errate.add(parziale);
		}
		
		else if(parziale.length()<text.length()){
		    for(int i=0; i<text.length();i++){
		    	
		    	if(quanteVolte(text,text.charAt(i))>quanteVolte(parziale,text.charAt(i))){
		        	parziale+=text.charAt(i);
			        livello++;
			        calcolaAnagrammi(text,parziale,livello);
			        parziale = parziale.substring(0,parziale.length()-1);
			    }
			    
		    }
		}	
		
}




	public List<String> getCorrette() {
		return corrette;
	}

	public List<String> getErrate() {
		return errate;
	}

	public boolean isCorrect(String anagramma){
		boolean corretto=false;
		if(parole.contains(anagramma))
			corretto = true;
		return corretto;
	}

	private int quanteVolte(String s,char c) {
	int count=0;
	char cara[] = s.toCharArray();
	  for(int i=0;i<cara.length;i++){
		  if(cara[i] == c){
			 count++; 
		  }
	
		   
		  }
		return count;
	}




	public void pulisci() {
		corrette.clear();
		errate.clear();
		
	}
	
	

}
