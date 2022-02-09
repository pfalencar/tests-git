package br.com.pfa.split;

import java.util.Arrays;
import java.util.regex.Matcher;

public class SplitArquivo {

	public static void main(String[] args) {
		
		String caminho = "C:\\LogiReport\\Server\\temp\\1293786513004914209376865908.pdf";
		System.out.println(caminho);
		System.out.println(splitArquivo(caminho));
		
		
//		 String homePath = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
//		 System.out.println(homePath);
//		 System.out.println(Arrays.deepToString(homePath.split(Matcher.quoteReplacement(System.getProperty("file.separator")))));        
		 
	}
	
	public static String splitArquivo (String caminho) {
		String[] arrayDoCaminho = caminho.split(Matcher.quoteReplacement(System.getProperty("file.separator")));
		System.out.println(Arrays.deepToString(arrayDoCaminho));
		
		int caminhoLength = arrayDoCaminho.length;
		System.out.println("caminhoLength: " + caminhoLength);
		String nomeArquivo = null;
		int i = 0;
		for (String parteArray : arrayDoCaminho) {
			if (arrayDoCaminho[i] == arrayDoCaminho[caminhoLength - 1]) {
				System.out.println("parteArray NomeArquivo = " + parteArray);
				if (parteArray != null) {
					nomeArquivo = parteArray;
				}				
			}
			i++;
		}
		return nomeArquivo;		
	}

}
