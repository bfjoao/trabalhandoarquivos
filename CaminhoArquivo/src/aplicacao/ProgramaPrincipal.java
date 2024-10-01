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
		
		//PEGAR SÓ O NOME DO ARQUIVO, SÓ O CAMINHO DO ARQUIVO E TODO CAMINHO
		System.out.println("getName: " + path.getName());
		System.out.println("getParent: " + path.getParent());
		System.out.println("getPath: " + path.getPath());
	}

}
