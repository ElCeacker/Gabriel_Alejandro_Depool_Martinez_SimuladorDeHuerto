package Huerto;

import java.util.ArrayList;
public class Cesta extends Thread{
    ArrayList vegetales = new ArrayList();

    int capacidadHuerto = 0;

    public Cesta(int capacidadHuerto) {
        this.capacidadHuerto = capacidadHuerto;
    }

    public synchronized void anadirAlimentosCesta(String alimento) throws InterruptedException {
        while (vegetales.size() >= capacidadHuerto ) {
            wait();
        }
        vegetales.add(alimento);
        notifyAll();
    }

    public synchronized String consumirAlimentosCesta() throws InterruptedException {
        if (vegetales.size() == 0) {
            wait();
        }
        String vegetalConsumido = (String) this.vegetales.remove(0);
        notifyAll();

        return vegetalConsumido;
    }
}
