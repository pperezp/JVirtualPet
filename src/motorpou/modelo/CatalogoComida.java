package motorpou.modelo;

import exceptions.FoodNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pperezp
 */
public class CatalogoComida {

    public static final Comida FRAMBUESA = new Comida("Frambuesa", 10, 100);
    public static final Comida FRUTILLA = new Comida("Frutilla", 10, 100);
    public static final Comida PAN = new Comida("Pan", 15, 150);
    public static final Comida HELADO = new Comida("Helado", 20, 200);
    public static final Comida HAMBURGUESA = new Comida("Hamburguesa", 30, 300);
    public static final Comida LASANIA = new Comida("LASAÑA", 50, 1500);

    public static List<Comida> comidas = new ArrayList<>();

    public static void cargarCatalogo() {
        comidas.add(FRAMBUESA);
        comidas.add(FRUTILLA);
        comidas.add(PAN);
        comidas.add(HELADO);
        comidas.add(HAMBURGUESA);
        comidas.add(LASANIA);
    }

    public static void showCatalogo() {
        System.out.println("***********************");
        for (Comida c : comidas) {
            System.out.println(c.getNombre() + "\t\t$"
                    + c.getPrecio() + "\t\t" + c.getValor() + "%");
        }
        System.out.println("***********************");
    }

    public static Comida getComida(String nombre)
            throws FoodNotFoundException {
        for (Comida c : comidas) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        throw new FoodNotFoundException("La comida "
                + nombre + " no está en el catalogo");
    }

}
