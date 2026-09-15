package speedfast;

public class Main {

    public static void main(String[] args) {

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        Pedido pedido1 = new Pedido(
                1,
                "Av. Providencia 123",
                EstadoPedido.PENDIENTE
        );

        Pedido pedido2 = new Pedido(
                2,
                "Av. Matta 456",
                EstadoPedido.PENDIENTE
        );

        Pedido pedido3 = new Pedido(
                3,
                "Av. Santa Rosa 789",
                EstadoPedido.PENDIENTE
        );

        Pedido pedido4 = new Pedido(
                4,
                "Av. Grecia 321",
                EstadoPedido.PENDIENTE
        );

        Pedido pedido5 = new Pedido(
                5,
                "Av. Las Condes 654",
                EstadoPedido.PENDIENTE
        );

        zonaDeCarga.agregarPedido(pedido1);
        zonaDeCarga.agregarPedido(pedido2);
        zonaDeCarga.agregarPedido(pedido3);
        zonaDeCarga.agregarPedido(pedido4);
        zonaDeCarga.agregarPedido(pedido5);

        Repartidor repartidor1 =
                new Repartidor("Luis", zonaDeCarga);

        Repartidor repartidor2 =
                new Repartidor("Daniela", zonaDeCarga);

        Repartidor repartidor3 =
                new Repartidor("Pedro", zonaDeCarga);

        Thread hilo1 = new Thread(repartidor1);
        Thread hilo2 = new Thread(repartidor2);
        Thread hilo3 = new Thread(repartidor3);
System.out.println("Iniciando entregas...");
        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {

            hilo1.join();
            hilo2.join();
            hilo3.join();

        } catch (InterruptedException e) {

            System.out.println("Se interrumpió la ejecución de los hilos.");
        }

        System.out.println();
        System.out.println("Todos los pedidos han sido entregados correctamente");
    }
}
