import Classes.Cliente;
import Classes.Granjero;
import Huerto.Cesta;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cesta cesta = new Cesta(10);
        Granjero paco = new Granjero("Paco", 5, 2, cesta);
        paco.start();

        Cliente gabri = new Cliente("Gabriel", 5, 5, cesta);
        gabri.start();
    }
}