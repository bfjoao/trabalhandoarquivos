package aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Produto;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		List<Produto> list = new ArrayList<>();
		
		
		System.out.println("Digite o caminho do arquivo: ");
		String sourceFileStr = sc.nextLine();
		
		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		
		boolean sucesso = new File(sourceFolderStr + "\\out").mkdir();
		
		
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			String itemCsv = br.readLine();
			while (itemCsv != null) {
				String[] fields = itemCsv.split(",");
				String nome = fields[0];
				double preco = Double.parseDouble(fields[1]);
				int quantidade = Integer.parseInt(fields[2]);
				
				list.add(new Produto(nome, preco, quantidade));
				
				itemCsv = br.readLine();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
				for (Produto item : list) {
					bw.write(item.getNome() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}
				
				System.out.println(targetFileStr + " CRIADO!");
			}
			catch (IOException e) {
				System.out.println("Erro na escrita do arquivo: " + e.getMessage());
			}
		}
		catch (IOException e) {
			System.out.println("Erro na leitura do arquivo" + e.getMessage());
		}
		
		
		sc.close();
	}

}
