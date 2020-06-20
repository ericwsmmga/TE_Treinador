package trabalho.bimestral;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ProcessadorDeArquivo {
	public void Processar(String caminhoArquivo, String caminhoArquivoFiltrado) {
		BufferedReader buffer;
		File arquivo = new File(caminhoArquivoFiltrado);
		BufferedWriter bufferEscrita;
		String linha = "";
		
		System.out.println("Iniciando Processamento dos arquivos....");
		try {
			buffer = new BufferedReader(new FileReader(caminhoArquivo));
			Collection lista = new ArrayList();
			try {
				while ((linha = buffer.readLine()) != null) {
					lista.add(linha);
				}
				Collection lista2 = new HashSet(lista);
				bufferEscrita = new BufferedWriter(new FileWriter(arquivo));

				for (Object item : lista2) {
					bufferEscrita.write((String) item);
					bufferEscrita.newLine();
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {

		}
		
		System.out.println("--------------------------------------------");
		
		System.out.println("Processo finalizado com Sucesso !!");

	}
}
