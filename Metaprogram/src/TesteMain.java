import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteMain {

    public static void main(String[] args) throws Exception {
    	obterClasseObjeto();
        instanciar();
        _Method();
    }

    static void obterClasseObjeto() {
        Class<Cliente> nomeClasse = Cliente.class;
        System.out.println("Nome da Classe " + nomeClasse.getName());

        Class<? extends Cliente> viaObject = new Cliente().getClass();
        System.out.println("Via object " + viaObject.getName());

    }

    static void instanciar() throws Exception {
        Constructor<Cliente> ClienteConstructor = Cliente.class.getConstructor();

        Cliente cli = ClienteConstructor.newInstance();
        System.out.println("Instancia sem parâmetros " + cli);

        Constructor<Cliente> instanciaParametros = Cliente.class
                .getDeclaredConstructor(String.class, int.class);
        System.out.println("Quantidade de parâmetros : " + instanciaParametros.getParameterCount());

        Cliente novoCliente = instanciaParametros.newInstance("José", 1);
        System.out.println("Cliente : " + novoCliente);
    }

    static void _Method() throws Exception {
        Cliente Cliente = new Cliente();
        Method setIdMethod = Cliente.getClass().getMethod("setId");
        setIdMethod.invoke(Cliente, 2);
        System.out.println("Visibilidade do setId " + setIdMethod.isAccessible());
        System.out.println(setIdMethod.getParameterCount());

        Method getIdMethod = Cliente.getClass().getMethod("getId");
        int id = (int) getIdMethod.invoke(Cliente);
        System.out.println("Visibilidade do getId " + getIdMethod.isAccessible());
        System.out.println("id do cliente: " + id);

    }
}

class Cliente {
    private String name;
    private int id;

    public Cliente(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Cliente() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}