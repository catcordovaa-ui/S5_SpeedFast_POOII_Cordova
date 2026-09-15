package speedfast;

public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        while (true) {

            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            pedido.setEstado("EN_REPARTO");

            System.out.println(nombre +
                    " retiró el " + pedido);

            System.out.println(nombre +
                    " está entregando el Pedido #" + pedido.getId());

            try {

                int tiempo = (int)(Math.random() * 3 + 1);

                Thread.sleep(tiempo * 1000);

            } catch (InterruptedException e) {

                System.out.println("El repartidor " + nombre +
                        " fue interrumpido.");
            }

            pedido.setEstado("ENTREGADO");

            System.out.println(nombre +
                    " entregó correctamente el Pedido #" +
                    pedido.getId());

            System.out.println("Estado final: " +
                    pedido.getEstado());

            System.out.println();
        }
    }
}
