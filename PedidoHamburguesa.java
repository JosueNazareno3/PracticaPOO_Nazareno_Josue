public class PedidoHamburguesa extends Pedido implements OperacionesPedido {

    private boolean comboCompleto;
    private int nivelPicante;
    private final double costoDelivery = 2.80;

    public PedidoHamburguesa(String cliente, String direccion, double precioBase,
                             boolean delivery, boolean comboCompleto, int nivelPicante) {

        super(cliente, direccion, precioBase, TipoComida.HAMBURGUESA, delivery);
        this.comboCompleto = comboCompleto;
        this.nivelPicante = nivelPicante;
    }

    @Override
    public double calcularCostoTotal() {
        double total = getPrecioBase();

        if (comboCompleto) {
            total += 2.50; // papas + bebida
        }

        if (isDelivery()) {
            total += costoDelivery;
        }

        return total;
    }

    @Override
    public void mostrarResumenPedido() {
        System.out.println("=== RESUMEN PEDIDO HAMBURGUESA ===");
        System.out.println("Cliente: " + getCliente());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Combo completo: " + comboCompleto);
        System.out.println("Nivel de picante: " + nivelPicante);
        System.out.println("Precio base: $" + getPrecioBase());
    }

    @Override
    public int estimarTiempoEntrega() {
        int tiempo = 15;
        if (isDelivery()) tiempo += 10;
        return tiempo;
    }

    @Override
    public void mostrarDetallesEspeciales() {
        System.out.println("[HAMBURGUESA] Combo: " + comboCompleto +
                           " | Picante: Nivel " + nivelPicante);
    }
}
