package shopmaster.adapter;

import shopmaster.externo.StripeUSA;

/**
 * ADAPTADOR (patrón Adapter).
 * Implementa el contrato local ProcesadorPago y por dentro usa StripeUSA.
 * Traduce: pesos -> dólares, usuario -> email, y agrega la clave de comercio.
 */
public class StripeUSAAdapter implements ProcesadorPago {

    private static final double TASA_CAMBIO = 4000;          // 1 USD = 4.000 COP
    private static final String MERCHANT_KEY = "SHOPMASTER-KEY-2026";

    private StripeUSA stripe;

    public StripeUSAAdapter(StripeUSA stripe) {
        this.stripe = stripe;
    }

    @Override
    public void cobrarEnPesos(String usuario, double montoCOP) {
        double montoUSD = montoCOP / TASA_CAMBIO;
        String email = usuario + "@shopmaster.com";

        System.out.println("   [Adaptador] Convirtiendo $" + String.format("%,.0f", montoCOP)
                + " COP a USD $" + String.format("%,.2f", montoUSD));

        stripe.chargeInDollars(montoUSD, email, MERCHANT_KEY);
    }
}
