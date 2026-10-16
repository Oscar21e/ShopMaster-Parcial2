package shopmaster.decorator;

/**
 * COMPONENTE (patrón Decorator).
 * Interfaz común para el pedido base y para todos los extras que lo envuelven.
 */
public interface Pedido {

    String getDescripcion();

    double getCosto();
}
