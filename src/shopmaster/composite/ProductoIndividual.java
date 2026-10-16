package shopmaster.composite;

/**
 * HOJA (patrón Composite).
 * Un artículo simple, no tiene nada adentro.
 */
public class ProductoIndividual implements ComponenteProducto {

    private String nombre;
    private double precio;

    public ProductoIndividual(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println("   ".repeat(nivel) + "- " + nombre + ": $" + String.format("%,.0f", precio));
    }
}
