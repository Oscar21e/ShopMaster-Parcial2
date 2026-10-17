package shopmaster.facade;

import shopmaster.adapter.ProcesadorPago;
import shopmaster.composite.Combo;
import shopmaster.composite.ComponenteProducto;
import shopmaster.composite.ProductoIndividual;
import shopmaster.decorator.EmpaqueRegalo;
import shopmaster.decorator.GarantiaExtendida;
import shopmaster.decorator.ManejoFragil;
import shopmaster.decorator.Pedido;
import shopmaster.decorator.PedidoBase;
import shopmaster.proxy.ProxyPagoSeguro;

/**
 * FACHADA (patrón Facade).
 * Único punto de entrada para el Main. Coordina y oculta los subsistemas:
 * Composite (productos), Decorator (extras), Proxy (seguridad) y Adapter (StripeUSA).
 * Los subsistemas no saben que la fachada existe.
 */
public class TiendaFacade {

    public static final String GARANTIA = "GARANTIA";
    public static final String REGALO = "REGALO";
    public static final String FRAGIL = "FRAGIL";

    private ProcesadorPago procesador = new ProxyPagoSeguro();

    /** Atajo para crear un producto sin que el Main conozca ProductoIndividual. */
    public ComponenteProducto crearProducto(String nombre, double precio) {
        return new ProductoIndividual(nombre, precio);
    }

    /** Atajo para armar un combo con los componentes que se le pasen (productos u otros combos). */
    public ComponenteProducto crearCombo(String nombre, ComponenteProducto... componentes) {
        Combo combo = new Combo(nombre);
        for (ComponenteProducto c : componentes) {
            combo.agregar(c);
        }
        return combo;
    }

    /** Compra en un solo paso ("One-Click Checkout"). */
    public void ejecutarCompraRapida(String usuario, ComponenteProducto producto, String... extras) {
        System.out.println("==================================================");
        System.out.println("COMPRA RÁPIDA - Cliente: " + usuario);
        System.out.println("==================================================");

        // 1. Composite: mostrar el árbol de productos
        System.out.println("1) Productos:");
        producto.mostrar(1);

        // 2. Decorator: envolver el pedido con cada extra elegido
        Pedido pedido = new PedidoBase(producto);
        for (String extra : extras) {
            switch (extra) {
                case GARANTIA -> pedido = new GarantiaExtendida(pedido);
                case REGALO -> pedido = new EmpaqueRegalo(pedido);
                case FRAGIL -> pedido = new ManejoFragil(pedido);
                default -> System.out.println("   Extra desconocido: " + extra);
            }
        }
        System.out.println("2) Detalle: " + pedido.getDescripcion());
        System.out.println("   Subtotal productos: $" + String.format("%,.0f", producto.getPrecio()));
        System.out.println("   TOTAL A PAGAR:      $" + String.format("%,.0f", pedido.getCosto()) + " COP");

        // 3. Proxy (+ Adapter por dentro): cobrar
        System.out.println("3) Procesando pago:");
        procesador.cobrarEnPesos(usuario, pedido.getCosto());
        System.out.println();
    }
}
