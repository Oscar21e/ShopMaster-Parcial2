package shopmaster.decorator;

import shopmaster.composite.ComponenteProducto;

/**
 * COMPONENTE CONCRETO (patrón Decorator).
 * El pedido sin extras: su costo es el precio del producto o combo (Composite).
 */
public class PedidoBase implements Pedido {

    private ComponenteProducto producto;

    public PedidoBase(ComponenteProducto producto) {
        this.producto = producto;
    }

    @Override
    public String getDescripcion() {
        return "Pedido: " + producto.getNombre();
    }

    @Override
    public double getCosto() {
        return producto.getPrecio();
    }
}
