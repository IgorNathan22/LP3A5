import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Produtor extends Thread {

    private long tempo;
    private ItemFactory f = new ItemFactory();
    private Item i = new Item();
    ArrayList<Item> bf = new ArrayList<Item>();
    private boolean pausado;
    private double variacao;
    private int tamanho;

    public Produtor(String str, ArrayList<Item> arl, int tam) {
        super(str);
        bf = arl;
        tamanho = tam;
        pausado = false;
        variacao = 2.5;
    }

    @Override
    public void run() {
        while (true) {
            try {
                dormir();
                if (bf.size() < tamanho) {
                    i = f.produzirItem();
                    bf.add(i);
                    tempo = (long) (i.getTempo() + 1000 * variacao);
                } else {
                    tempo = (long) (500 * (Math.random() + 1));
                }
                sleep(tempo + 500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setestado(boolean estd) throws InterruptedException {
        pausado = estd;
        if (!pausado) {
            acordar();
        }
    }

    public synchronized void dormir() throws InterruptedException {
        while (pausado) {
            wait();
        }
    }

    public synchronized void acordar() throws InterruptedException {
        notify();
    }

    public void setVariacao(double variacao) {
        this.variacao = variacao;
    }

}