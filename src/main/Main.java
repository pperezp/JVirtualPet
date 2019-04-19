package main;

import exceptions.LimitLifeException;
import exceptions.FoodNotFoundException;
import exceptions.NotEnoughMoneyException;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import motorpou.archivo.InputOutputObject;
import motorpou.modelo.Animal;
import motorpou.modelo.ComandoPrincipal;
import motorpou.modelo.Estado;
import motorpou.modelo.Jugador;
import motorpou.modelo.LMComida;
import motorpou.modelo.Rutas;

/**
 *
 * @author pperezp
 */
public class Main extends javax.swing.JFrame {
    private final Jugador j1;
    private final ComandoPrincipal comandos ;
    private Thread hEstados;
    
    /*Este mapa es para cambiar los colores de las barras, y asi
    no crear un contador para cada uno*/
    private Map mapaColores;
    
    public Main() throws IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        
        if(new File(Rutas.jugador).exists()){
            j1 = (Jugador)InputOutputObject.leerObjetoDesde(Rutas.jugador);
            calcularTiempo();
        }else{
            j1 = new Jugador("Perro");
        }
        
        comandos = new ComandoPrincipal(j1);
        
        iniciarHiloAnimal();
        initMapaColores();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpEnergia = new javax.swing.JProgressBar();
        jpSalud = new javax.swing.JProgressBar();
        jpDiversion = new javax.swing.JProgressBar();
        jpComida = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblEnergia = new javax.swing.JLabel();
        lblSalud = new javax.swing.JLabel();
        lblDiversion = new javax.swing.JLabel();
        lblComida = new javax.swing.JLabel();
        txtCmd = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaComida = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblDinero = new javax.swing.JLabel();
        lblUltima = new javax.swing.JLabel();
        btnDormir = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setToolTipText("");

        jpEnergia.setToolTipText("Energía");

        jpSalud.setToolTipText("Salud");

        jpDiversion.setToolTipText("Diversión");

        jpComida.setToolTipText("Comida");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/energy.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/salud.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fun.png"))); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/food.png"))); // NOI18N

        lblEnergia.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblEnergia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnergia.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSalud.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblSalud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalud.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDiversion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblDiversion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiversion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblComida.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblComida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComida.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpDiversion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpComida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpEnergia, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(jpSalud, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEnergia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSalud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiversion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEnergia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpEnergia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSalud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpSalud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDiversion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDiversion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCmd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCmdKeyReleased(evt);
            }
        });

        listaComida.setBorder(javax.swing.BorderFactory.createTitledBorder("Comidas"));
        listaComida.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaComida.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jScrollPane2.setViewportView(listaComida);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblNombre.setText("[NOMBRE]");

        lblEstado.setText("[ESTADO]");

        lblDinero.setText("[DINERO]");

        lblUltima.setText("[FECHA ÚLTIMA VEZ]");

        btnDormir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/dormir.png"))); // NOI18N
        btnDormir.setToolTipText("Dormir / Despertar");
        btnDormir.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnDormirItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(lblDinero, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(lblUltima, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(btnDormir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDinero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUltima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDormir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtLog.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));
        jScrollPane1.setViewportView(txtLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCmd)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCmdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCmdKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                String comando = txtCmd.getText().trim().toLowerCase();
                txtCmd.setText("");
                comandos.ejecutar(comando);
            } catch (LimitLifeException | FoodNotFoundException | NotEnoughMoneyException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            } 
        }
    }//GEN-LAST:event_txtCmdKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            j1.setUltimaVez(Calendar.getInstance().getTime());
            InputOutputObject.escribirObjetoEn(j1, Rutas.jugador);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnDormirItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnDormirItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            j1.getAnimal().dormir();
        }else{
            j1.getAnimal().despertar();
        }
    }//GEN-LAST:event_btnDormirItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
////                    break;
////                }
////            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Test4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Test4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Test4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Test4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        
//        UIManager.put("ProgressBar.background", Color.red);
//        UIManager.put("ProgressBar.foreground", Color.red);
//        UIManager.put("ProgressBar.selectionBackground", Color.red);
//        UIManager.put("ProgressBar.selectionForeground", Color.red);
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (        IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDormir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JProgressBar jpComida;
    private javax.swing.JProgressBar jpDiversion;
    private javax.swing.JProgressBar jpEnergia;
    private javax.swing.JProgressBar jpSalud;
    private javax.swing.JLabel lblComida;
    private javax.swing.JLabel lblDinero;
    private javax.swing.JLabel lblDiversion;
    private javax.swing.JLabel lblEnergia;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSalud;
    private javax.swing.JLabel lblUltima;
    private javax.swing.JList listaComida;
    private javax.swing.JTextField txtCmd;
    private javax.swing.JEditorPane txtLog;
    // End of variables declaration//GEN-END:variables

    private void iniciarHiloAnimal() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        this.jpComida.setOpaque(true);
        this.jpDiversion.setOpaque(true);
        this.jpEnergia.setOpaque(true);
        this.jpSalud.setOpaque(true);
        
        lblNombre.setText(j1.getAnimal().getNombre());
        
       
        hEstados = new Thread(new Runnable() {
            boolean primeraVuelta = true;
            int vidaComida;
            int vidaEnergia;
            int vidaDiversion;
            int vidaSalud;
            
            private Animal animal;
            @Override
            public void run() {
                SimpleDateFormat formato = new SimpleDateFormat("d-MMM-y HH:mm:ss");
                
                Date ultimaVez = j1.getUltimaVez();
                if(ultimaVez == null){
                    lblUltima.setText("");
                }else{
                    lblUltima.setText(formato.format(ultimaVez));
                }
                while(true){
                    try {
                        animal = j1.getAnimal();
                        listaComida.setModel(new LMComida(animal.getComidas()));
                        lblEstado.setText((!animal.isDormido() ?"DESPIERTO":"DORMIDO"));
                        lblDinero.setText("$ "+Integer.toString(j1.getDinero()));
                        
                        for(Estado e : animal.getEstados()){
                            switch(e.getNombre()){
                                case Estado.COMIDA:{
//                                    jpComida.setValue(e.getVida());
                                    /*Mejore el algoritmo de abajo, ya que lo hice funcion*/
                                    jpComida.setToolTipText("Comida ("+e.getVida()+"%)");
                                    cambiarColorBarra(e, vidaComida, jpComida, lblComida);
                                    
//                                    /*algoritmo para que vaya cambiando de color
//                                    segun su vida*/
//                                    if(primeraVuelta){
//                                        vidaComida = e.getVida();
//                                        jpComida.setForeground(new Color(contRojo, 255, 0));
//                                        contRojo = contRojo + 5;
//                                    }else if(vidaComida != e.getVida()){
//                                        vidaComida = e.getVida();
//                                        if(e.getVida() >= 50){
//                                            contRojo = contRojo + 5;
//                                            jpComida.setForeground(new Color(contRojo, 255, 0));
//                                        }else{
//                                            contVerde = contVerde - 5;
//                                            jpComida.setForeground(new Color(255, contVerde, 0));
//                                        }
//                                    }
//                                    /*algoritmo para que vaya cambiando de color
//                                    segun su vida*/
                                    
                                    break;
                                }
                                case Estado.DIVERSION:{
                                    jpDiversion.setToolTipText("Diversión ("+e.getVida()+"%)");
                                    cambiarColorBarra(e, vidaDiversion, jpDiversion, lblDiversion);
                                    break;
                                }
                                case Estado.ENERGIA:{
                                    jpEnergia.setToolTipText("Energía ("+e.getVida()+"%)");
                                    cambiarColorBarra(e, vidaEnergia, jpEnergia, lblEnergia);
                                    break;
                                }
                                case Estado.SALUD:{
                                    jpSalud.setToolTipText("Salud ("+e.getVida()+"%)");
                                    cambiarColorBarra(e, vidaSalud, jpSalud, lblSalud);
                                    break;
                                }
                            }
                        }
                        if(primeraVuelta)
                            primeraVuelta = false;
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            private void cambiarColorBarra(Estado estado, int contadorVida, JProgressBar barra, JLabel lbl) {
                barra.setValue(estado.getVida());
                lbl.setText((Integer.toString(estado.getVida()))+"%");
                if(primeraVuelta){
                    contadorVida = estado.getVida();
                    barra.setForeground(new Color((int)mapaColores.get(contadorVida), 255, 0));
                }else if(contadorVida != estado.getVida()){
                    contadorVida = estado.getVida();
                    if(estado.getVida() >= 50){
                        barra.setForeground(new Color((int)mapaColores.get(contadorVida), 255, 0));
                    }else{
                        barra.setForeground(new Color(255, (int)mapaColores.get(contadorVida), 0));
                    }
                }
            }
        });
        hEstados.start();
    }

    /**
     * Método para inicializar el mapa para los colores de las barras
     */
    private void initMapaColores() {
        mapaColores = new HashMap();
        
        int cont = 100;
        for(int i=0; i<255; i = i + 5){
            mapaColores.put(cont, i);
            cont--;
        }
        for(int i=255; i>=0; i = i - 5){
            mapaColores.put(cont, i);
            cont--;
        }
        
//        for(int i = 100 ; i>=0 ; i--){
//            System.out.println(i+" - "+mapa.get(i));
//        }
    }

    private void calcularTiempo() {
        Date ahora = Calendar.getInstance().getTime();
        Date ultima = j1.getUltimaVez();
        
        long ms = ahora.getTime()  - ultima.getTime();
        
        Estado comida = j1.getAnimal().getComida();
        Estado energia = j1.getAnimal().getEnergia();
        Estado diversion = j1.getAnimal().getDiversion();
        Estado salud = j1.getAnimal().getSalud();
        
        int puntosComida = (int) (ms / comida.getPause());
        int puntosEnergia = (int) (ms / energia.getPause());
        int puntosDiversion = (int) (ms / diversion.getPause());
        int puntosSalud = (int) (ms / salud.getPause());
        
        comida.disminuirVida(puntosComida);
        energia.disminuirVida(puntosEnergia);
        diversion.disminuirVida(puntosDiversion);
        salud.disminuirVida(puntosSalud);
        
        System.out.println("Total sin uso [mil]: "+ms);
        System.out.println("Total sin uso [seg]: "+ms / 1000);
        System.out.println("Total sin uso [min]: "+(ms / 1000)/60);
    }
    
}
