import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Read {
	private String text;
	private ArrayList<String> alpha = new ArrayList<String>();
	private ArrayList<Integer> freq = new ArrayList<Integer>();


	public Read(String chemin) throws IOException{
		this.text=this.read_text(chemin);
	}


	public ArrayList<String> getAlphabet() {
		return this.alpha;
	}
	public ArrayList<Integer> getFrequence() {
		return this.freq;
	}
	
	public String read_text(String chemin) 
	{
		String texte="";
		String currentLine;

		try (BufferedReader bufferreader = new BufferedReader(new FileReader(chemin))){
			while (( currentLine = bufferreader.readLine()) != null)
				texte+=currentLine+"";
			bufferreader.close();
		}
		catch(IOException ioe){
			System.out.println("Error");
		}
		return texte;
	}
	
	public void freq_char(){
		Boolean exist = false;
		for(int i=0;i<this.text.length();i++){
			for(int j=0;j<this.alpha.size();j++){
				// Si le caractere est dans l'alphabet, on ajoute 1 à sa frequence.
				if(this.text.substring(i, i+1).equals(this.alpha.get(j))){
					exist=true;
					this.freq.set(j, this.freq.get(j)+1);					
					}
			}
			// Si il n'y est pas, on l'implémente dans l'aphabet, on défini sa fréquence de base à 1.
			if(exist==false){
				this.alpha.add(this.text.substring(i, i+1));
				this.freq.add(1);
				}
			exist=false;
		}	
	}
}