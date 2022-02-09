package br.com.pfa.arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LerEscreverArquivo {

	public static void main(String[] args) throws IOException {
//		criarEscreverLerArquivo();
		criarPastaEArquivoDentroDaPasta();
	}
	
	public static void criarPastaEArquivoDentroDaPasta() {
		//Criando diretório
		File diretorio = new File("C:\\\\workspace-eclipse2022\\\\EscreverLerArquivos\\\\pastaIO");
		try {
			if (!diretorio.exists()) {			
				diretorio.mkdir();	//cria uma pasta (vazia)
			}
			System.out.println("diretorio.getName() = " + diretorio.getName());
			
			String caminhoInteiroDiretorio = diretorio.getPath();
			System.out.println("diretorio.getPath() = " + caminhoInteiroDiretorio);
			
			//caso seja um diretório, é possível listar seus arquivos e diretórios
			File[] diretorios = diretorio.listFiles();
			
			//Criando arquivo dentro do diretório
			File arquivo = new File("C:\\\\workspace-eclipse2022\\\\EscreverLerArquivos\\\\pastaIO\\\\relatorio.txt");
			if (!arquivo.exists()) {			
				arquivo.createNewFile();	//cria um arquivo (vazio)
			}
			String caminhoInteiroArquivo = arquivo.getPath();
			File arquivoNovo = renomearArquivo (arquivo);
			String caminhoInteiroArquivoNovo = arquivoNovo.getPath();
			escreverNoArquivo(caminhoInteiroArquivoNovo);
			lerArquivo(caminhoInteiroArquivoNovo);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
//	public static void copyFile() {
//		File source = new File("C:\\\\workspace-eclipse2022\\\\EscreverLerArquivos\\\\pastaIO\\\\");
//		File dest = new File("H:\\work-temp\\file2");
//		try {
//		    FileUtils.copyDirectory(source, dest);
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
//	}
	
	public static File renomearArquivo (File arquivo) {
		//Renomeando arquivo
		String name = "C:\\\\workspace-eclipse2022\\\\EscreverLerArquivos\\\\pastaIO\\\\relatorio1";
		String extensao = ".txt";
		File arquivoNovo = new File(name + extensao);
		arquivo.renameTo(arquivoNovo);
		return arquivoNovo;
	}
	
	public static void escreverNoArquivo(String arquivo) throws IOException {
		//escreve no arquivo
		FileWriter fw = new FileWriter(arquivo, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Texto a ser escrito no txt6");
		bw.newLine();
		bw.close();
		fw.close();
	}
	
	public static void lerArquivo(String arquivo) throws IOException {
		//faz a leitura do arquivo
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		//enquanto houver mais linhas
		while (br.ready()) {
		//lê a proxima linha
		String linha = br.readLine();
		//faz algo com a linha
		System.out.println(linha);
		}
		br.close();
		fr.close();
	}
	
	public static void criarEscreverLerArquivo() {
		File arquivo = new File("C:\\\\workspace-eclipse2022\\\\EscreverLerArquivos\\\\nome_do_arquivo.txt");
		try {
			if (!arquivo.exists()) {			
				arquivo.createNewFile();	//cria um arquivo (vazio)
			}
			//caso seja um diretório, é possível listar seus arquivos e diretórios
//			File[] arquivos = arquivo.listFiles();
			
			//escreve no arquivo
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Texto a ser escrito no txt2");
			bw.newLine();
			bw.close();
			fw.close();
			
			//faz a leitura do arquivo
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			//enquanto houver mais linhas
			while (br.ready()) {
			//lê a proxima linha
			String linha = br.readLine();
			//faz algo com a linha
			System.out.println(linha);
			}
			br.close();
			fr.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	
	public static void testandoLeituraEscrita() throws IOException {
		File arquivo = new File( "C:\\workspace-eclipse2022\\EscreverLerArquivos\\arquivos\\" );		
		
		boolean existe = arquivo.exists();		//verifica se o arquivo ou diretório existe		
		if (!existe) {
//			arquivo.createNewFile();    	//cria um arquivo (vazio)			
			arquivo.mkdir();				//cria um diretório
		}
		//caso seja um diretório, é possível listar seus arquivos e diretórios
		File [] arquivos = arquivo.listFiles();

		//ESCREVER ARQUIVOS
		
		//construtor que recebe o objeto do tipo arquivo
		FileWriter fw = new FileWriter( arquivo );		
		//construtor que recebe também como argumento se o conteúdo será acrescentado ao invés de ser substituído (append)
//		FileWriter fw2 = new FileWriter( arquivo, true );

		//construtor recebe como argumento o objeto do tipo FileWriter
		BufferedWriter bw = new BufferedWriter( fw );			
		bw.write( "Texto a ser escrito no txt" );	//escreve o conteúdo no arquivo
		bw.newLine();		//quebra de linha
		
		//fecha os recursos
		bw.close();
		fw.close();
		
		
		//LER ARQUIVOS
		
		//construtor que recebe o objeto do tipo arquivo
		FileReader fr = new FileReader( arquivo );

		//construtor que recebe o objeto do tipo FileReader
		BufferedReader br = new BufferedReader( fr );
		
		//enquanto houver mais linhas
		while( br.ready() ){		
			String linha = br.readLine();	//lê a proxima linha
		 //faz algo com a linha
		}

		br.close();
		fr.close();

	}
}
