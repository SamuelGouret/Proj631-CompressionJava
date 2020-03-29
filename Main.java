import java.io.IOException;


public class Main {
	
	public static void main(String[] args) throws IOException{

		Read document = new Read("D:\\informatique\\JavaScript\\d\\extraitalice.txt");
		document.freq_char();
		System.out.println(document.getAlphabet());
		System.out.println(document.getFrequence());
	}
}