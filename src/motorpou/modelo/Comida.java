package motorpou.modelo;

import java.io.Serializable;

/**
 *
 * @author pperezp
 */
public class Comida implements Serializable{
    private final String nombre;
    private final int porcentaje;
    private final int precio;
    private int cantidad;

    public Comida(String nombre) {
        this(nombre, -1, -1);
    }  
    
    public Comida(String nombre, int porcentaje, int precio) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.precio = precio;
        cantidad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return porcentaje;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void aumentarCantidad(){
        cantidad = cantidad + 1;
    }
    
    public void disminuirCantidad(){
        cantidad = cantidad - 1;
    }
    
    @Override
    public String toString(){
        return this.nombre +"  ("+this.porcentaje+"%) x"+this.cantidad;
    }
    
}
