package motorpou.modelo;

import exceptions.LimitLifeException;
import exceptions.FoodNotFoundException;
import exceptions.NotEnoughMoneyException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pperezp
 */
public class ComandoPrincipal extends Thread {

    private boolean salir = false;
    private final Scanner scan = new Scanner(System.in);
    private String comando;
    private final Jugador jugador;

    public ComandoPrincipal(Jugador jugador) {
        this.jugador = jugador;
        this.jugador.comenzar();
        CatalogoComida.cargarCatalogo();
    }

    @Override
    public void run() {

        while (!salir) {
            try {
                System.out.print(jugador.getAnimal().getNombre() + " (" + (jugador.getAnimal().isDormido() ? "Dormido" : "Despierto") + ")> ");
                comando = scan.nextLine();
                ejecutar(comando);
            } catch (FoodNotFoundException | NotEnoughMoneyException | LimitLifeException ex) {
                Logger.getLogger(ComandoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        jugador.getAnimal().interrupt();
    }

    private static void desplegarAyuda() {
        System.out.println("Comandos disponibles: ");
        System.out.println();
        System.out.println("/salir");
        System.out.println("/dormir");
        System.out.println("/despertar");
        System.out.println("/ver <catalogo <comida> | dinero | comida>");
        System.out.println("/comprar <nombre_comida>");
        System.out.println("/alimentar <nombre_comida>");
        System.out.println("/setVida <nombre_estado> <cantidad <= 100>");
        System.out.println("/max [Aumenta todos los estados a 100%]");
        System.out.println("/ayuda");
        System.out.println();
    }

    public void ejecutar(String comando) throws FoodNotFoundException, NotEnoughMoneyException, LimitLifeException {
        Animal animal = jugador.getAnimal();
        String com = comando.toLowerCase().trim().split(" ")[0];
        switch (com) {
            case "/ayuda": {
                desplegarAyuda();
                break;
            }

            case "/salir": {
                salir = true;
                break;
            }

//                case "ver":{
//                    animal.mostrarInfo();
//                    break;
//                }
            case "/dormir": {
                System.out.println(animal.getNombre() + " durmiendo");
                animal.dormir();
                break;
            }

            case "/despertar": {
                animal.despertar();
                System.out.println(animal.getNombre() + " despierto");
                break;
            }

            case "/velocidad": {
                String velocidadNueva = comando.toLowerCase().trim().split(" ")[1].toLowerCase();
                switch (velocidadNueva) {
                    /*El problema lo tengo cuando paso de normal a rápido
                        ya que si el hilo está en pause por 5 minutos
                        después de esos 5 minutos recién cambia a rápido*/

//                        case "rapida":{
//                            animal.setVelocidad(Velocidad.RAPIDO);
//                            break;
//                        }
//                        case "normal":{
//                            animal.setVelocidad(Velocidad.NORMAL);
//                            break;
//                        }
                    }
            }

            case "": {
                animal.switchMostrarInfo();
                break;
            }

            case "/ver": {
                String cosa = comando.toLowerCase().trim().split(" ")[1].toLowerCase();

                switch (cosa) {
                    case "catalogo": {
                        try {
                            String que = comando.toLowerCase().trim().split(" ")[2].toLowerCase();
                            switch (que) {
                                case "comida": {
                                    CatalogoComida.showCatalogo();
                                    break;
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("El comando es /ver catalogo <comida>");
                        }

                        break;
                    }

                    case "dinero": {
                        System.out.println("Dinero: $" + jugador.getDinero());
                        break;
                    }

                    case "comida": {
                        Animal an = jugador.getAnimal();

                        for (Comida c : an.getComidas()) {
                            System.out.println(c.getNombre() + " x" + c.getCantidad());
                        }

                        break;
                    }
                }

                break;
            }

            case "/comprar": {

                String nombreComida = comando.toLowerCase().trim().split(" ")[1].toLowerCase();

                Comida c = CatalogoComida.getComida(nombreComida);

                jugador.comprar(c);
                break;
            }

            case "/alimentar": {
                try {
                    String nombreComida = comando.toLowerCase().trim().split(" ")[1].toLowerCase();
                    Comida c = jugador.getAnimal().getComida(nombreComida);
                    jugador.getAnimal().alimentar(c);
                } catch (FoodNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            }

            case "/max": {
                animal.setMaximoVida();
                break;
            }

            case "/min": {
                animal.setMinimaVida();
                break;
            }

            case "/setvida": {
                String nombreEstado = comando.toLowerCase().trim().split(" ")[1].toLowerCase();
                int vida = Integer.parseInt(comando.toLowerCase().trim().split(" ")[2]);

                switch (nombreEstado) {
                    case "energia": {
                        animal.getEnergia().setVida(vida);
                        break;
                    }

                    case "salud": {
                        animal.getSalud().setVida(vida);
                        break;
                    }

                    case "comida": {
                        animal.getComida().setVida(vida);
                        break;
                    }

                    case "diversion": {
                        animal.getDiversion().setVida(vida);
                        break;
                    }
                }
                break;
            }
            default: {
                System.out.println("No se reconoce el comando: " + com);
                desplegarAyuda();
            }
        }
    }
}
