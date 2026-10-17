package shopmaster.externo;

/**
 * ADAPTADO / ADAPTEE (patrón Adapter).
 * Simula la librería del proveedor externo de EE. UU.
 * NO se puede modificar: método en inglés, en dólares y con otros parámetros.
 */
public class StripeUSA {

    public void chargeInDollars(double amountUSD, String customerEmail, String merchantKey) {
        System.out.println("   [StripeUSA] Charging USD $" + String.format("%,.2f", amountUSD)
                + " to " + customerEmail + " (merchant: " + merchantKey + ")");
        System.out.println("   [StripeUSA] Payment successful.");
    }
}
