package shopmaster.decorator;

/** DECORADOR CONCRETO: Empaque de Regalo Premium, +$15.000 fijos. */
public class EmpaqueRegalo extends ExtraDecorator {

    public EmpaqueRegalo(Pedido pedidoEnvuelto) {
        super(pedidoEnvuelto);
    }

    @Override
    public String getDescripcion() {
        return pedidoEnvuelto.getDescripcion() + " + Empaque de Regalo ($15.000)";
    }

    @Override
    public double getCosto() {
        return pedidoEnvuelto.getCosto() + 15000;
    }
}
