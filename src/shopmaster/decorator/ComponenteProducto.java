package shopmaster.decorator;

/**
 * COMPONENTE (patrón Composite).
 * Interfaz común: el sistema trata igual a un producto suelto y a un combo.
 */
public interface ComponenteProducto {

    String getNombre();

    double getPrecio();

    /** Muestra el producto (o el combo con todo su contenido) con sangría según el nivel. */
    void mostrar(int nivel);
}
