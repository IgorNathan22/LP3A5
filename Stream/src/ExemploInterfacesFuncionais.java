import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class ExemploInterfacesFuncionais {
	
	public static void main(String args[]) {
		exemploFunction();
	}
	
	/**
	 * Supplier : fornecedor - n�o recebe nada e retorna um valor
	 * Consumer : consumidor - recebe um valor e n�o retorna nada
	 */
	private void exemploSupplierConsumer() {
		Stream
		.generate( () -> new Random().nextInt() ) // a fun��o generate recebe um supplier
		//Supplier : interface funcional que cont�m um m�todo get sem argumentos
		// Ou seja, n�o recebe input, mas devolve um output
		.limit(10) //limita a 10 valores
		.forEach( (e) -> System.out.println(e) ); // a fun��o forEach recebe um consumer
		//Consumer : interface funcional que cont�m um m�todo accept com um par�metro de entrada e void na sa�da
		//Consumer : oposto do supplier, n�o retorna nada, mas recebe um valor com o qual faz alguma a��o.
	}
	
	/**
	 * BiConsumer, interface funcional que cont�m um m�todo accept com dois valores de etrada e nenhum de sa�da.
	 * ou seja, recebe dois valores, realiza uma opera��o com eles, mas n�o retorna nada.
	 * O BiConsumer pode ser testado mais facilmente com um Map
	 */
	private static void exemploBiConsumer() {
		
		final HashMap< String, String> nomeSobrenome = new HashMap<>();
		nomeSobrenome.put("Diego", "Chaves");
		nomeSobrenome.put("Jo�o", "Ningu�m");
		
        final BiConsumer<String, String> merge = (nome, sobrenome) ->
        {
        	System.out.print("\n" + nome + " " + sobrenome);
        };
        
        //forEach do Map aceita um BiConsumer que vai receber a chave e o valor como par�metros
        nomeSobrenome.forEach(merge);
        
        System.out.println("\n\nExemplo com andThen");
        //Exemplo
        nomeSobrenome.forEach(merge.andThen(( a, b) -> System.out.print( " - " + (a + " " + b).length() ) ) );
	}
	
	/**
	 * Predicate � uma interface funcional que possui um m�todo test que recebe 
	 * um valor e retorna um boolean
	 * 
	 * Pode ser visto em a��o na fun��o filter de uma List
	 */
	private static void exemploPredicate() {
		final List<String> frutas = Arrays.asList("ameixa", "jaca", "abacate", "caqui", "banana", "abacaxi");
		
		frutas.stream().filter(( fruta ) -> fruta.startsWith("a") ).forEach(System.out::println);
		
	}
	
	/**
	 * Function � uma interface funcional que cont�m um m�todo apply
	 * que recebe um valor, aplica a fun��o e devolve um resultado 
	 */
	private static void exemploFunction() {
		final List<String> frutas = Arrays.asList("ameixa", "jaca", "abacate", "caqui", "banana", "abacaxi");
		
		frutas.stream().map((fruta) -> fruta + "s" ).forEach(System.out::println);
		
		//BiFunction � uma function com dois valores de entrada
		//UnaryOperator � uma uma function que obrigatoriamente recebe e devolve um valor do mesmo tipo
	}


}