/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import motorpou.modelo.CatalogoComida;
import motorpou.modelo.ComandoPrincipal;
import motorpou.modelo.Jugador;
import exceptions.NotEnoughMoneyException;

/**
 *
 * @author pperezp
 */
public class Test3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jugador j1 = new Jugador("Duke");
        ComandoPrincipal principal = new ComandoPrincipal(j1);
        principal.start();
    }
    
}
