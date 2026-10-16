package shopmaster.decorator;

import shopmaster.composite.ComponenteProducto;

import java.util.ArrayList;
import java.util.List;

/**
 * COMPUESTO (patrón Composite).
 * Un combo tiene una LISTA de componentes: pueden ser productos u otros combos.
 */
public class Combo implements shopmaster.composite.ComponenteProducto {

    private String nombre;
    private List<shopmaster.composite.ComponenteProducto> hijos = new ArrayList<>();

    public Combo(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(shopmaster.composite.ComponenteProducto componente) {
        hijos.add(componente);
    }

    public void eliminar(shopmaster.composite.ComponenteProducto componente) {
        hijos.remove(componente);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    /** RECURSIVIDAD: suma el precio de cada hijo; si un hijo es otro combo, él suma los suyos. */
    @Override
    public double getPrecio() {
        double total = 0;
        for (shopmaster.composite.ComponenteProducto hijo : hijos) {
            total += hijo.getPrecio();
        }
        return total;
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println("   ".repeat(nivel) + "+ " + nombre + " (combo): $" + String.format("%,.0f", getPrecio()));
        for (ComponenteProducto hijo : hijos) {
            hijo.mostrar(nivel + 1);
        }
    }
}
