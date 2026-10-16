package shopmaster.decorator;

/** DECORADOR CONCRETO: Manejo Prioritario Frágil, +$25.000 fijos. */
public class ManejoFragil extends ExtraDecorator {

    public ManejoFragil(Pedido pedidoEnvuelto) {
        super(pedidoEnvuelto);
    }

    @Override
    public String getDescripcion() {
        return pedidoEnvuelto.getDescripcion() + " + Manejo Frágil ($25.000)";
    }

    @Override
    public double getCosto() {
        return pedidoEnvuelto.getCosto() + 25000;
    }
}
