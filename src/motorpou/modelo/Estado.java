package motorpou.modelo;

import exceptions.LimitLifeException;
import java.io.Serializable;

/**
 *
 * @author pperezp
 */
public class Estado extends Thread implements Serializable {

    public final static String COMIDA = "comida";
    public final static String SALUD = "salud";
    public final static String DIVERSION = "diversión";
    public final static String ENERGIA = "energía";
    private final static int MUERTE = 0;

    private final String nombre;
    private int vida;
    private int pause;
    private boolean interrumpido;
    private boolean aumentandoVida;

    public Estado(String nombre, int pause) {
        this.nombre = nombre;
        this.pause = pause;
        System.out.println("pause constructor: " + pause);
        interrumpido = false;
        aumentandoVida = false;
        vida = 100;
    }

    public Estado(String nombre, int pause, int vida) {
        this(nombre, pause);
        this.vida = vida;
    }

    public int getPause() {
        return pause;
    }

    public void setPause(int pause) {
        this.pause = pause;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void disminuirVida(int vida) {
        System.out.println("disminuir en : " + vida);
        System.out.print("[" + this.nombre.substring(0, 3) + "] - La vida bajo de " + this.vida);
        if ((this.vida - vida) < 0) {
            this.vida = 0;
        } else {
            this.vida = this.vida - vida;
        }

        System.out.println("% a " + this.vida + "%");
    }

    private void disminuirVida() {
        if (vida != Estado.MUERTE && !aumentandoVida) {
            /*El !aumentandoVida es para que no disminuya
            la vida cuando la esten aumentando. Por ejemplo
            cuando duerme*/
            System.out.println("Disminuyendo en 1-->" + this.nombre);
            vida = vida - 1;
        }
    }

    public void aumentarVida() {
        aumentandoVida = true;
        if (vida != 100) {
            vida = vida + 1;
        }
    }

    public void aumentarVida(int valor) {
        System.out.print("Aumento de " + vida + "% ");
        if (vida + valor > 100) {
            vida = 100;
        } else {
            vida = vida + valor;
        }

        System.out.println("a " + vida + "%");
    }

    public void detenerAumentoDeVida() {
        aumentandoVida = false;
    }

    @Override
    public void run() {
        System.out.println("Hilo estado: " + this.nombre + " iniciado");
        System.out.println("Pause: " + pause);
        while (!interrumpido) {
            try {
                pause();
                disminuirVida();
            } catch (InterruptedException ex) {
                System.out.println("Hilo " + nombre.trim() + " Interrumpido");
                interrumpido = true;
            }
        }
        System.out.println("Hilo estado: " + this.nombre + " detenido");
    }

    private void pause() throws InterruptedException {
        Thread.sleep(this.pause);
    }

    @Override
    public String toString() {
        return nombre + ": \t" + vida + "%";
    }

    public void setVida(int vida) throws LimitLifeException {
        if (vida <= 100) {
            this.vida = vida;
        } else {
            throw new LimitLifeException("El límite de vida es 100: " + vida);
        }
    }
}
