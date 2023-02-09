package Classes;

import java.util.ArrayList;
import java.util.Calendar;
import Huerto.Cesta;

public class Granjero extends Thread {

    String huerto[] = {
            "lettuce",
            "cabbage",
            "onion",
            "spinach",
            "potato",
            "celery",
            "asparagus",
            "radish",
            "broccoli",
            "artichoke",
            "tomato",
            "cucumber",
            "eggplant",
            "carrot",
            "green bean"
    };

    private String name;
    private int cantidadAlimentos;
    private int duracion;
    private Cesta cesta;

    public Granjero(String name, int cantidadAlimentos, int duracion, Cesta cesta) {
        this.cantidadAlimentos = cantidadAlimentos;
        this.name = name;
        this.duracion = duracion;
        this.cesta = cesta;
    }

    public void crecerAlimentos() throws InterruptedException {
        for (int i = 0; i < cantidadAlimentos; i++) {
            int DURACION = (int)(Math.random()*this.duracion+1);
            int indiceAlimentos = (int) (Math.random() * huerto.length);
            sleep(DURACION);
            this.cesta.anadirAlimentosCesta(huerto[indiceAlimentos]);
            System.out.println(this.name + " ha plantado " + huerto[indiceAlimentos] + " --> " + DURACION);
        }
    }

public void run() {
    try {
        System.out.println("Granjero " + this.name + " creado...");
        crecerAlimentos();

    } catch (InterruptedException excep) {
        {
            System.err.println("No produzco...");
        }
    }
}
}
