package motorpou.modelo;

import exceptions.NotEnoughMoneyException;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author pperezp
 */
public class Jugador implements Serializable{
    private Animal animal;
    private int dinero;
    private Date ultimaVez;
    
    public Jugador(String nombreAnimal){
        animal = new Animal(nombreAnimal);
        dinero = 1000;
        ultimaVez = null;
    }

    public Date getUltimaVez() {
        return ultimaVez;
    }

    public void setUltimaVez(Date ultimaVez) {
        this.ultimaVez = ultimaVez;
    }
    
    public Animal getAnimal() {
        return animal;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    
    public void comprar(Comida comida) throws NotEnoughMoneyException{
        int precio = comida.getPrecio();
        
        if(dinero - precio < 0)
            throw new NotEnoughMoneyException("Le falta $ "+((dinero - precio) * - 1));
        else{
            dinero = dinero - precio;
            animal.addComida(comida);
            System.out.println("Comprado! 1 "+comida.getNombre());
        }
    }
    
    public void comenzar(){
        animal.start();
    }

    
}
