package shopmaster;

import shopmaster.composite.ComponenteProducto;
import shopmaster.facade.TiendaFacade;

/**
 * Cliente: solo habla con la fachada.
 * Ejecuta los 3 escenarios de prueba obligatorios (sin Scanner).
 */
public class Main {

    public static void main(String[] args) {
        TiendaFacade tienda = new TiendaFacade();

        // ---------- Caso 1: Compra exitosa completa ----------
        ComponenteProducto kitLimpieza = tienda.crearCombo("Kit de Limpieza",
                tienda.crearProducto("Paño microfibra", 25000),
                tienda.crearProducto("Spray limpiador", 15000));

        ComponenteProducto comboGamer = tienda.crearCombo("Combo Setup Gamer",
                tienda.crearProducto("Monitor", 800000),
                tienda.crearProducto("Teclado", 200000),
                kitLimpieza);

        tienda.ejecutarCompraRapida("cliente_vip", comboGamer,
                TiendaFacade.GARANTIA, TiendaFacade.REGALO);

        // ---------- Caso 2: Rechazo por tope de dinero ----------
        ComponenteProducto servidor = tienda.crearProducto("Servidor Empresarial", 6000000);
        tienda.ejecutarCompraRapida("cliente_normal", servidor, TiendaFacade.FRAGIL);

        // ---------- Caso 3: Rechazo por usuario reportado ----------
        ComponenteProducto mouse = tienda.crearProducto("Mouse", 150000);
        tienda.ejecutarCompraRapida("BLOQUEADO", mouse);
    }
}
