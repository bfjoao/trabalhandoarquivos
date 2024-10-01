package aplicacao;

import java.io.File;
import java.util.Scanner;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o caminho da pasta: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		//LER SOMENTE PASTAS
		File[] pastas = path.listFiles(File::isDirectory);
		System.out.println("PASTAS:");
		for (File pasta : pastas) {
			System.out.println(pasta);
		}
		
		//LER SOMENTE ARQUIVOS
		File[] arquivos = path.listFiles(File::isFile);
		System.out.println("ARQUIVOS:");
		for(File arquivo : arquivos) {
			System.out.println(arquivo);
		}
		
		//CRIAR PASTA
		boolean sucesso = new File(strPath + "\\subdir").mkdir();
		System.out.println("Diretório criado com sucesso: " + sucesso);
		
		
		sc.close();
		
	}

}
