package sistema;

public class Treinador {
	
	private String cidadeOrigem;
	private String cidadeDestino;
	private String data;
	
	
	public Treinador(String cidadeOrigem, String cidadeDestino, String data) {
		this.cidadeDestino = cidadeDestino;
		this.cidadeOrigem = cidadeOrigem;
		this.data = data;
	}
	
	public String getCidadeOrigem() {
		return cidadeOrigem;
	}
	
	public String getCidadeDestino() {
		return cidadeDestino;
	}
	
	public String getData() {
		return data;
	}
	
	public String getDataExtenso() {
		return Util.retornaDiaExtenso(Util.retornaNumeroDiaSemana(this.getData(), true));
	}
	
}
