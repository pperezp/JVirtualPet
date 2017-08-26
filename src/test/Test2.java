package test;

import java.util.Scanner;
import motorpou.modelo.Animal;

/**
 *
 * @author pperezp
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean salir = false;
        Scanner scan = new Scanner(System.in);
        String comando;
        
        
        Animal animal = new Animal("Duke");
        
        animal.start();
        
        while(!salir){
            System.out.print(animal.getNombre()+" ("+(animal.isDormido()?"Dormido":"Despierto")+")> ");
            comando = scan.nextLine();
            
            switch(comando.toLowerCase().trim().split(" ")[0]){
                case "/ayuda":{
                    desplegarAyuda();
                    break;
                }
                
                case "/salir":{
                    salir = true;
                    break;
                }
                
//                case "ver":{
//                    animal.mostrarInfo();
//                    break;
//                }
                
                case "/dormir":{
                    System.out.println(animal.getNombre()+" durmiendo");
                    animal.dormir();
                    break;
                }
                
                case "/despertar":{
                    animal.despertar();
                    System.out.println(animal.getNombre()+" despierto");
                    break;
                }
                
                case "/velocidad":{
                    String velocidadNueva = comando.toLowerCase().trim().split(" ")[1].toLowerCase();
                    switch(velocidadNueva){
                        /*El problema lo tengo cuando paso de normal a rapido
                        ya que si el hilo esta en pause por 5 minutos
                        despues de esos 5 minutos recien cambia a rapido*/
                        
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
                
                case "":{
                    animal.switchMostrarInfo();
                }
            }
            
            
        }
        
        animal.interrupt();
    }

    private static void desplegarAyuda() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Comandos disponibles: ");
        System.out.println();
        System.out.println("/salir");
        System.out.println("/dormir");
        System.out.println("/despertar");
        System.out.println("/ayuda");
        System.out.println();
    }
    
}
