package shopmaster.decorator;

/** DECORADOR CONCRETO: Póliza de Garantía Extendida, +10% del valor actual. */
public class GarantiaExtendida extends ExtraDecorator {

    public GarantiaExtendida(Pedido pedidoEnvuelto) {
        super(pedidoEnvuelto);
    }

    @Override
    public String getDescripcion() {
        return pedidoEnvuelto.getDescripcion() + " + Garantía Extendida (10%)";
    }

    @Override
    public double getCosto() {
        return pedidoEnvuelto.getCosto() * 1.10;
    }
}
