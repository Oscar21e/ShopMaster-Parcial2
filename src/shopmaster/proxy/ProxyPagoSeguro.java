package shopmaster.proxy;

import shopmaster.adapter.ProcesadorPago;
import shopmaster.adapter.StripeUSAAdapter;
import shopmaster.externo.StripeUSA;

/**
 * PROXY de protección (patrón Proxy).
 * Implementa la MISMA interfaz que el procesador real (ProcesadorPago),
 * así el sistema cree que habla directo con el banco.
 * Antes de dejar pasar el cobro revisa el monto y el usuario, y deja la auditoría.
 */
public class ProxyPagoSeguro implements ProcesadorPago {

    private static final double MONTO_MAXIMO = 5_000_000;
    private static final String USUARIO_BLOQUEADO = "BLOQUEADO";

    // SUJETO REAL: no se crea hasta que una transacción sea aprobada (lazy loading)
    private ProcesadorPago procesadorReal;

    @Override
    public void cobrarEnPesos(String usuario, double montoCOP) {
        System.out.println("   [Proxy] Verificando transacción de " + usuario + "...");

        if (USUARIO_BLOQUEADO.equals(usuario)) {
            System.out.println("   [Proxy] RECHAZADA: el usuario está reportado como BLOQUEADO.");
            return;
        }

        if (montoCOP > MONTO_MAXIMO) {
            System.out.println("   [Proxy] RECHAZADA: $" + String.format("%,.0f", montoCOP)
                    + " COP supera el límite de $" + String.format("%,.0f", MONTO_MAXIMO) + " COP.");
            return;
        }

        // Datos válidos: recién aquí se crea el procesador real
        if (procesadorReal == null) {
            procesadorReal = new StripeUSAAdapter(new StripeUSA());
        }
        procesadorReal.cobrarEnPesos(usuario, montoCOP);

        System.out.println("   [AUDITORÍA: Transacción aprobada para " + usuario
                + " por $" + String.format("%,.0f", montoCOP) + " COP]");
    }
}
