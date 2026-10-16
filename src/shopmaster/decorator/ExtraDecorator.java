package shopmaster.decorator;

/**
 * DECORADOR BASE (patrón Decorator).
 * Implementa Pedido y TIENE ADENTRO otro Pedido (composición).
 * Por defecto delega todo al pedido envuelto; cada extra le agrega lo suyo.
 */
public abstract class ExtraDecorator implements Pedido {

    protected Pedido pedidoEnvuelto;

    public ExtraDecorator(Pedido pedidoEnvuelto) {
        this.pedidoEnvuelto = pedidoEnvuelto;
    }

    @Override
    public String getDescripcion() {
        return pedidoEnvuelto.getDescripcion();
    }

    @Override
    public double getCosto() {
        return pedidoEnvuelto.getCosto();
    }
}
