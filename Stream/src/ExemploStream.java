import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExemploStream {

	public static void main(String[] args) {
		//criandoStream();
		exemploReduce();
	}

	private static void criandoStream() {
		final List<String> lista = Arrays.asList("amor", "bola", "casa", "dado");

		System.out.println("Stream padrão de um array:");
		lista.stream().forEach(System.out::println);

		System.out.println("\nStream gerada por meio de paralelismo:");
		lista.parallelStream().forEach(System.out::println);

		String[] nomes = new String[] { "Ana", "Beatriz", "Clara", "Diana", "Eliane" };
		System.out.println("\n\nStream a partir de array usando a classe java.util.Arrays");
		Arrays.stream(nomes).forEach(System.out::println);

		System.out.println("\nStream gerada por meio do método of da classe Stream diretamente:");
		Stream.of("teste", "teste2", "teste4").forEach(System.out::println);

		System.out.println("\nGera uma stream com o método IntStream.range");
		IntStream.range(5, 15).forEach(System.out::println);

		System.out.println("\nCriando um stream com o método Stream.iterate");
		Stream.iterate(true, valor -> !valor).limit(4).forEach(System.out::println);

		System.out.println("\nCriando um map e coletando com a função terminal .collect(), retornando uma lista");
		Map<Integer, List<String>> mapColetado = Arrays.stream(nomes)
				.collect(Collectors.groupingBy(nome -> nome.length()));
		System.out.println(mapColetado);
	}

	private static void exemploReduce() {

		// EXEMPLOS COM BinaryOperator
		final OptionalInt resultadoSoma = IntStream.rangeClosed(1, 10).reduce((v1, v2) -> v1 + v2);
		System.out.println(resultadoSoma.getAsInt());

		final Optional<String> resultadoConcatenacao = Stream.of("Ana", "Beatriz", "Clara", "Diana", "Eliane")
				.reduce((v1, v2) -> v1.concat(v2));
		System.out.println(resultadoConcatenacao.get());

		// Exemplos com valor de identidade e BinaryOperator
		final String resultadoConcatenacao2 = Stream.of("Ana", "Beatriz", "Clara", "Diana", "Eliane", "").reduce("",
				(v1, v2) -> v1.concat(v2));
		System.out.println(resultadoConcatenacao2);

		try {
			final Optional<String> resultadoConcatenacao3 = Arrays.stream(new String[] {})
					.reduce((v1, v2) -> v1.concat(v2));
			//System.out.println(resultadoConcatenacao3.get());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
		final String resultadoConcatenacao4 = Arrays.stream(new String[] {}).reduce("", (v1, v2) -> v1.concat(v2));
		System.out.println("RESULTADO COM IDENTIDADE =[" + resultadoConcatenacao4 + "]");

	}

}
