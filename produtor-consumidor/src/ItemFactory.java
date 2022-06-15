import java.text.DecimalFormat;

public class ItemFactory {

	private int numero;

	public ItemFactory() {
	}

	public Item produzirItem() {
		Item i = new Item();

		numero = (1 + (int) (Math.random() * 100)) / 10;

		switch (numero) {
		case 0:
			i.setNome("Gol");
			break;
		case 1:
			i.setNome("Golf");
			break;
		case 2:
			i.setNome("Astra");
			break;
		case 3:
			i.setNome("Ferrari");
			break;
		case 4:
			i.setNome("Polo");
			break;
		case 5:
			i.setNome("BMW");
			break;
		case 6:
			i.setNome("Celta");
			break;
		case 7:
			i.setNome("Corsa");
			break;
		case 8:
			i.setNome("Vectra");
			break;
		case 9:
			i.setNome("Jeep");
			break;
		default:
			i.setNome("Carro Secreto");

		}

		numero = (1 + (int) (Math.random() * 100)) / 10;

		switch (numero) {
		case 0:
			i.setCor("preto");
			break;
		case 1:
			i.setCor("Branco");
			break;
		case 2:
			i.setCor("Azul");
			break;
		case 3:
			i.setCor("Verde");
			break;
		case 4:
			i.setCor("Laranja");
			break;
		case 5:
			i.setCor("Marron");
			break;
		case 6:
			i.setCor("Invisível");
			break;
		case 7:
			i.setCor("Turquesa");
			break;
		case 8:
			i.setCor("Prata");
			break;
		case 9:
			i.setCor("Colorido");
			break;
		default:
			i.setCor("Cor secreta");

		}
		DecimalFormat df = new DecimalFormat("#,###.00");

		i.setValor(df.format(Math.random() * 100000));

		i.setTempo((long) (Math.random() * 1000));

		return i;
	}
}