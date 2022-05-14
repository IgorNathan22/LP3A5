import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exemplo2ExemploStream {
	
	public static void main(String args[]) {
		testeSkip();
		testeSorted();
	}
	
	private static void testeSkip() {
		List<String> list = Arrays.asList("linguagem programação 1", "linguagem programação 2", "linguagem programação 3");
		long size = list.stream().skip(1).map(element -> element.substring(0, 3)).sorted().count();
		System.out.println(size);
	}
	
	private static void testeSorted() {
		List<String> carasLegais = Arrays.asList("Amita", "Sherek", "Amanto", "Raul", "Shakira", "Salmão", "Yan", "Loki");
		carasLegais.stream().sorted()
        .map(String::toUpperCase)
        .forEach(System.out::println);
	}
}
