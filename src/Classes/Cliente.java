package Classes;

import Huerto.Cesta;

public class Cliente extends Thread {

    private String name;
    private int cantidadAlimentos;
    private int duracion;
    private Cesta cesta;

    public Cliente(String name, int cantidadAlimentos, int duracion, Cesta cesta) {
        this.name = name;
        this.cantidadAlimentos = cantidadAlimentos;
        this.duracion = duracion;
        this.cesta = cesta;
    }

    public void consumir() throws InterruptedException {
        for (int i = 0; i < cantidadAlimentos; i++) {
            int DURACION = (int) (Math.random() * this.duracion + 1);
            String vegetalConsumido = cesta.consumirAlimentosCesta();
            sleep(DURACION);
            System.out.println("El cliente " + this.name + " ha consumido " + vegetalConsumido);
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente " + this.name + " creado...");
            consumir();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
