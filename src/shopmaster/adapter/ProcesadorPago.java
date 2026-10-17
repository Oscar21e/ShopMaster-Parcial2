package shopmaster.adapter;

/**
 * OBJETIVO / TARGET (patrón Adapter).
 * Contrato interno de ShopMaster para cobrar. Todo el sistema solo conoce esta interfaz.
 */
public interface ProcesadorPago {

    void cobrarEnPesos(String usuario, double montoCOP);
}
