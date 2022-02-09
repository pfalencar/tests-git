package br.com.pfa.pontovirgula;

public class PontoPorVirgulaViceVersa {

	public static void main(String[] args) {

		String numberString1 = "9,5";
		String numberString2 = "10, 11.";
//		String result = numberString1.replace(",", ".");
		String result = numberString2.replace(",", ".");
		
		System.out.println(result);
		
//		System.out.println(teste.replace('(\d)', '(?=\d)/g', '$1.');
			
	}

}
