public class Item {

	private String nome;
	private String cor;
	private String valor;
	private long tempo;

	public Item() {
		this.nome = "null";
		this.cor = "null";
		this.valor = "0";
		this.tempo = 0;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getTempo() {
		return tempo;
	}

	public void setTempo(long tempo) {
		this.tempo = tempo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}