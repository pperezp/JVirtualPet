package motorpou.modelo;

import exceptions.LimitLifeException;
import exceptions.FoodNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import reglas.Reglas;

/**
 *
 * @author pperezp
 */
public class Animal extends Thread implements Serializable {

    private final int MAXIMO_VIDA = 100;
    private final int MINIMO_VIDA = 1;
    private int VELOCIDAD = Reglas.Velocidad.NORMAL;
    private String nombre;

    private Estado comida;
    private Estado diversion;
    private Estado salud;
    private Estado energia;

    private boolean despierto;
    private boolean interrumpido;
    private boolean mostrarInfo;

    private List<Comida> comidas;

    public Animal(String nombre) {
        this.nombre = nombre;

        comida = new Estado(Estado.COMIDA, 2000 * VELOCIDAD);
        salud = new Estado(Estado.SALUD, 12000 * VELOCIDAD);
        diversion = new Estado(Estado.DIVERSION, 3000 * VELOCIDAD);
        energia = new Estado(Estado.ENERGIA, 2500 * VELOCIDAD);

//        /*ultra rapido*/
//        int num = 10;
//        comida = new Estado(Estado.COMIDA, 2000/num); 
//        salud = new Estado(Estado.SALUD, 12000/num);
//        diversion = new Estado(Estado.DIVERSION, 3000/num);
//        energia = new Estado(Estado.ENERGIA, 2500/num);
//        /*ultra rapido*/
        despierto = true;
        interrumpido = false;
        mostrarInfo = false;
        comidas = new ArrayList<>();
    }

    public Estado getComida() {
        return comida;
    }

    public Estado getDiversion() {
        return diversion;
    }

    public Estado getSalud() {
        return salud;
    }

    public Estado getEnergia() {
        return energia;
    }

    public void addComida(Comida comida) {
        try {
            Comida c = getComida(comida);
            c.aumentarCantidad();
        } catch (FoodNotFoundException ex) {
            comidas.add(comida);//Agrego a la lista
            comida.aumentarCantidad();//aumento
        }

    }

    public void dormir() {
        despierto = false;
    }

    public void despertar() {
        despierto = true;
        energia.detenerAumentoDeVida();
    }

    public void alimentar(Comida comida) throws FoodNotFoundException {
        Comida c = this.getComida(comida);
        if (c.getCantidad() > 0) {
            this.comida.aumentarVida(comida.getValor());
            c.disminuirCantidad();
        } else {
            System.out.println("La comida " + c.getNombre() + " no está en tu inventario");
        }
    }

    @Override
    public void run() {
        /*Contador para que la energia suba
        cuando el animal este duermiendo. 
        La energia va a subir cada 5 segudos */
        int cont = 0;

        /*Inicio los hilos de los estados*/
        comida.start();
        salud.start();
        energia.start();
        diversion.start();
        /*Inicio los hilos de los estados*/

        while (!interrumpido) {
            try {
                if (!despierto) {//si esta dormido
                    cont++;
                    if (cont == 5) {// si y pasaron 5 segundos                          
                        cont = 0;
                        energia.aumentarVida();
                    }
                }
                if (mostrarInfo)                    
                    mostrarInfo();
                
                Thread.sleep(1000);
                
            } catch (InterruptedException ex) {
                detenerHilosEstados();
                interrumpido = true;
            }

        }
    }

    public void switchMostrarInfo() {
        mostrarInfo = !mostrarInfo;
    }

    public boolean isMostrandoInfo() {
        return mostrarInfo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarInfo() {
//        /*Solo para cuestiones de estetica y ver
//        la fecha y hora*/
//        Calendar cal = Calendar.getInstance();
//        Date inicio = cal.getTime();
//        Date actual;
//        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
//        /*Solo para cuestiones de estetica y ver
//        la fecha y hora*/
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
//
//        cal = Calendar.getInstance();
//        actual = cal.getTime();
//        System.out.println("Hora Inicio: "+formato.format(inicio));
        System.out.println();

        System.out.println("Nombre: " + nombre);
        System.out.println((despierto ? "DESPIERTO" : "DORMIDO"));
        System.out.println("***********************");
        System.out.println(comida);
        System.out.println(salud);
        System.out.println(diversion);
        System.out.println(energia);
        System.out.println("***********************");
        System.out.println("Velocidad: " + (VELOCIDAD == 1 ? "Rápida" : "Normal"));
        System.out.println();
//        System.out.println("Hora actual: "+formato.format(actual));
    }

    private void detenerHilosEstados() {
        comida.interrupt();
        energia.interrupt();
        diversion.interrupt();
        salud.interrupt();
    }

    public boolean isDormido() {
        return !despierto;
    }

    /*prueba*/
    public void setVelocidad(int velocidad) {
        VELOCIDAD = velocidad;
        comida.setPause(2000 * velocidad);
        salud.setPause(12000 * velocidad);
        diversion.setPause(3000 * velocidad);
        energia.setPause(2500 * velocidad);
    }

    private Comida getComida(Comida comida) throws FoodNotFoundException {
        for (Comida c : comidas) {
            if (c.getNombre().equalsIgnoreCase(comida.getNombre())) {
                return c;
            }
        }

        throw new FoodNotFoundException("La comida " + comida.getNombre() + " no está en tu inventario");
    }

    public Comida getComida(String nombre) throws FoodNotFoundException {
        return getComida(new Comida(nombre, 0, 0));
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public List<Estado> getEstados() {
        List<Estado> lista = new ArrayList<>();
        lista.add(this.comida);
        lista.add(this.diversion);
        lista.add(this.energia);
        lista.add(this.salud);
        return lista;
    }

    public void setMaximoVida() throws LimitLifeException {
        comida.setVida(MAXIMO_VIDA);
        energia.setVida(MAXIMO_VIDA);
        diversion.setVida(MAXIMO_VIDA);
        salud.setVida(MAXIMO_VIDA);
    }

    public void setMinimaVida() throws LimitLifeException {
        comida.setVida(MINIMO_VIDA);
        energia.setVida(MINIMO_VIDA);
        diversion.setVida(MINIMO_VIDA);
        salud.setVida(MINIMO_VIDA);
    }
}
