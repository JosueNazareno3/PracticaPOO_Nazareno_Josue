import java.util.Arrays;

public class PedidoPizza extends Pedido implements OperacionesPedido {

    private String tamanio;
    private String[] ingredientesExtras;
    private final double costoDelivery = 3.50;

    public PedidoPizza(String cliente, String direccion, double precioBase,
                       boolean delivery, String tamanio, String[] ingredientesExtras) {

        super(cliente, direccion, precioBase, TipoComida.PIZZA, delivery);
        this.tamanio = tamanio;
        this.ingredientesExtras = ingredientesExtras;
    }

    @Override
    public double calcularCostoTotal() {
        double total = getPrecioBase();

        // Cada ingrediente extra cuesta $1.25
        total += ingredientesExtras.length * 1.25;

        if (isDelivery()) {
            total += costoDelivery;
        }

        return total;
    }

    @Override
    public void mostrarResumenPedido() {
        System.out.println("=== RESUMEN PEDIDO PIZZA ===");
        System.out.println("Cliente: " + getCliente());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Tamaño: " + tamanio);
        System.out.println("Extras: " + Arrays.toString(ingredientesExtras));
        System.out.println("Precio base: $" + getPrecioBase());
    }

    @Override
    public int estimarTiempoEntrega() {
        int tiempo = 25; // base
        if (isDelivery()) tiempo += 10;
        return tiempo;
    }

    @Override
    public void mostrarDetallesEspeciales() {
        System.out.println("[PIZZA] Tamaño: " + tamanio + 
                           " | Extras: " + Arrays.toString(ingredientesExtras));
    }
}
