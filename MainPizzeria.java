import java.util.ArrayList;
import java.util.List;

public class MainPizzeria {

    public static void main(String[] args) {

        List<Pedido> pedidos = new ArrayList<>();

        pedidos.add(new PedidoPizza(
                "Carlos", 
                "Av. Universitaria",
                8.50,
                true,
                "Grande",
                new String[]{"Queso extra", "Pepperoni"}
        ));

        pedidos.add(new PedidoHamburguesa(
                "María",
                "Calle 10 de Agosto",
                6.00,
                false,
                true,
                3
        ));

        // **Procesamiento polimórfico**
        for (Pedido p : pedidos) {
            p.mostrarDetallesEspeciales();
            System.out.println();
            if (p instanceof OperacionesPedido op) {
                op.mostrarResumenPedido();
                System.out.println("Total a pagar: $" + op.calcularCostoTotal());
                System.out.println("Tiempo estimado: " + op.estimarTiempoEntrega() + " minutos");
                System.out.println("------------------------------------");
            }
        }
    }
}
