package sistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProcessaorDeArquivos {

	public void processar(String caminho_do_arquivo_base, String caminho_arquivo_final) {
		// TODO Auto-generated method stub
		
		BufferedReader br = null;
		BufferedReader brLeitura = null;
		String linha = "";
		String divisor = ";";
		boolean primeiroLinha = true;
		
		List<String> linhasDoNovoArquivo = new ArrayList<>();
		List<Treinador> historicoViagens = new ArrayList<>();
		
		TratamentoDeString tds = new TratamentoDeString();
		
		
		try {
			br = new BufferedReader(new FileReader(caminho_do_arquivo_base));
			
		
			try {

				while((linha = br.readLine()) != null) {
					boolean linhaDuplicada = tds.tratarString(linha, linhasDoNovoArquivo);
					
					if(!linhaDuplicada && primeiroLinha == false) {
						linha = linha.replace("\"", "");
						String[] registro = linha.split(divisor);
						linhasDoNovoArquivo.add(linha);
						Treinador treinador = new Treinador(registro[7], registro[9], registro[15]); //origem destino data
						historicoViagens.add(treinador);
					}
					
					primeiroLinha = false;
				}
	
				
				String cidadeDesejada = Util.perguntaAoUsuario("Qual cidade você deseja ir?").toUpperCase();
				String dataDesejada = Util.perguntaAoUsuario("Qual a data desejada?");
				
				//na linha 51 vou printar algo do tipo: 09/06/2020 -> terca
				// 08/06/2020 -> segunda
				String diaExtenso = Util.retornaDiaExtenso(Util.retornaNumeroDiaSemana(dataDesejada, false));

				System.out.println(cidadeDesejada);
				int contadorViagemAoDestino = 0;
				
				
				for (Treinador treinador : historicoViagens) {
					System.out.println("Destino: " + treinador.getCidadeDestino() + " Data: "+ treinador.getDataExtenso()  );
					if (treinador.getCidadeDestino().equals(cidadeDesejada) && diaExtenso.equals(treinador.getDataExtenso())) {
						contadorViagemAoDestino++;
					}
				}

				//
				
				
				//System.out.println(contadorViagemAoDestino);
				
				// TODO FAÇO OS IFs QUE VÃO DETERMINAR MINHA RESPOSTA
				
				int QuantidadeDeViagensNescessarias = 1;
				
				if (contadorViagemAoDestino > QuantidadeDeViagensNescessarias) {
					System.out.println("Alta possibilidade de ter um onibus para "+cidadeDesejada );
				}	else {
					System.out.println("Baixa possibilidade de ter um onibus para "+ cidadeDesejada);
				}
				
				/*
				 * TABELA DE CONFUSÃO
				 * Verdadeiro positivo -> o ALGORITMO FALOU QUE IA ACONTECER E ACONTECEU
				 * Verdadeiro negativo -> O ALGORITMO FALOU QUE IA ACONTECER E NÃO ACONTECEU
				 * Falso positivo -> O ALGORITMO FALOU QUE NAO IA ACONTECER E ACONTECEU
				 * Falso Falso -> O ALGORITMO FALOU QUE NAO IA ACONTECER E NAO ACONTECEU
				 * */
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
