package speedfast;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCarga {

    private List<Pedido> pedidos;

    public ZonaDeCarga() {
        pedidos = new ArrayList<>();
    }

    public synchronized void agregarPedido(Pedido p) {
    pedidos.add(p);
    System.out.println("Pedido agregado a la zona de carga: " + p.getId());
    }

    public synchronized Pedido retirarPedido() {

        for (Pedido pedido : pedidos) {

            if (pedido.getEstado() == EstadoPedido.PENDIENTE) {
                pedidos.remove(pedido);
                return pedido;
            }
        }

        return null;
    }
}
