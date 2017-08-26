/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import motorpou.modelo.Estado;

/**
 *
 * @author pperezp
 */
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        
        final Date inicio = cal.getTime();
        final Estado comida, salud, diversion, energia;
        
        /*Segun lo estudiado:
        Comida: baja cada 5 minutos
        Salud: baja cada 30 minutos
        Diversion: baja cada 7.5 minutos
        Energia: baja cada 6.2 minutos
        
        Logre distinguir que 2000*150 eran 5 minutos. Ya que 
        primero hice una prueba sin el *150, para ver de forma
        rapida. Con esas multiplicaciones, llegan a los minutos
        mencionados anteriormente (5, 30 y 6.2)*/
        
        
        comida = new Estado("comida", 2000*150); 
        salud = new Estado("salud\t", 12000*150);
        diversion = new Estado("diversion", 3000*150);
        energia = new Estado("energia", 2500*150);
        
        comida.start();
        salud.start();
        energia.start();
        diversion.start();
        
        new Thread(new Runnable() {

            @Override
            public void run() {
                Calendar cal;
                Date actual;
                SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                while(true){
                    try {
                        for(int i = 0; i<10; i++)
                            System.out.println();
                        cal = Calendar.getInstance();
                        actual = cal.getTime();
                        System.out.println("Hora Inicio: "+formato.format(inicio));
                        System.out.println("***********************");
                        System.out.println(comida);
                        System.out.println(salud);
                        System.out.println(diversion);
                        System.out.println(energia);
                        System.out.println("***********************");
                        System.out.println("Hora actual: "+formato.format(actual));
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    
}
