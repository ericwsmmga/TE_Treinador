package trabalho.bimestral;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		ProcessadorDeArquivo processadorArquivos = new ProcessadorDeArquivo();
		
		processadorArquivos.Processar("D:\\Workspace\\Faculdade\\Topicos Especiais\\Arquivos\\treinador.csv",
										"D:\\Workspace\\Faculdade\\Topicos Especiais\\Arquivos\\treinador_filtrado.csv");
		
	}

}
