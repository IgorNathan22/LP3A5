package exceptions;

public class TesteMain {

	public static void main(String[] args) throws Exception {
		//Estoura o erro de NullPointer
		/*Usuario usuario = new Usuario();
		System.out.println(usuario.getEndereco().getRua());*/
		
		//Tratamento do erro de nullpointer, informa uma mensagem de erro ao receber um nullpointer
		try {
			Usuario usuario2 = new Usuario();
			usuario2.getEndereco().getRua();
		} catch (NullPointerException e) {
			throw new Exception("Endereço do usuário informado invalido");
		}
	}
}
