/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.sistemas;

import ifts16.pp.juego.sistemas.IOBase;
import static ifts16.pp.juego.sistemas.IOBase.ingresarEnteroEnIntervalo;
import static ifts16.pp.juego.sistemas.IOBase.mostrarTexto;
import static ifts16.pp.juego.sistemas.IOBase.mostrarTextos;
import ifts16.pp.juego.utiles.Opcion;
import ifts16.pp.juego.utiles.Opciones;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.text.Caret;

/**
 *
 * @author Gabriel Maceira
 */
public class IOLethos extends IOBase {
    
        @Override
        protected void iniciar() {
        this.setTitle("LETHOS");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        entrada.setColumns(80);
        entrada.setFont(new Font("Courier New", Font.BOLD, 13));
        entrada.setColumns(80);
        salida.setEditable(false);
        salida.setColumns(80);
        salida.setRows(5);
        salida.setLineWrap(true);
        salida.setFont(new Font("Courier New", Font.BOLD, 13));
        panel.setViewportView(salida);
        control.start();
        
            entrada.addKeyListener(new KeyListener(){

                @Override
                public void keyPressed(KeyEvent e){

                    if(e.getKeyChar() == KeyEvent.VK_ENTER && 
                        !entrada.getText().equalsIgnoreCase("")){
                        synchronized(control) {
                            control.notify();
                        }
                    }       
                }
                @Override
                public void keyReleased(KeyEvent e){
     
                }
                @Override
                public void keyTyped(KeyEvent e){
     
                }
            }
        );
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createSequentialGroup()
                .addComponent(panel, 800, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                 .addContainerGap()
                .addComponent(entrada, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap()
        ));
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, 500, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addGap(15)
                .addComponent(entrada, 50, 50, 50)
                .addContainerGap()
        ));

        pack();
    }

            
    public static void mostrarTexto(String mensaje) {
        IOBase.salida.append(mensaje + "\n");
        salida.setCaretPosition(salida.getText().length());
    }
    
    public static Opcion elegirOpcion(Opciones opciones) {
        IOLethos.mostrarTexto(opciones.getMensaje());
        ArrayList<String> mensajes = opciones.darFormato();
        IOLethos.mostrarTextos(mensajes);
        salida.setCaretPosition(salida.getText().length());
        int respuesta = ingresarEnteroEnIntervalo(1, opciones.cantidad());
        return opciones.opcionElegida(respuesta);
    }
    
    
    public static void mostrarTexto(String mensaje, Color texto, Color fondo) {
        IOLethos.salida.setForeground(texto);
        IOLethos.salida.setBackground(fondo);
        IOLethos.salida.append(mensaje + "\n");
        salida.setCaretPosition(salida.getText().length());
    }
    
    public static void mostrarTextos(ArrayList<String> mensajes) {
        for (String msj: mensajes) {
            IOLethos.salida.append(msj + "\n");
            salida.setCaretPosition(salida.getText().length());
        }
    }
    
    public static void mostrarTextos(ArrayList<String> mensajes, Color texto, Color fondo) {
        IOLethos.salida.setForeground(texto);
        IOLethos.salida.setBackground(fondo);
        for (String msj: mensajes) {
            IOLethos.salida.append(msj + "\n");
            salida.setCaretPosition(salida.getText().length());
        }
    }
     
    public static String ingresarTexto(String mensaje)  {
        IOLethos.mostrarTexto(mensaje);
        String respuesta = ingresarSincronizado(); 
        return respuesta;
    }
    
    public static int ingresarEntero(String mensaje)  {
        IOLethos.mostrarTexto(mensaje);
        String respuesta = ingresarSincronizado();
        while (!esEntero(respuesta)) {
            IOLethos.mostrarTexto("El numero no es entero. Vuelva a intentar.");
            respuesta = ingresarSincronizado();
        }
        Integer numero = Integer.parseInt(respuesta);
        return numero;
    }
    
     public static int ingresarEnteroEnIntervalo(String mensaje, int minimo,
        int maximo)  {
        IOLethos.mostrarTexto(mensaje);
        String respuesta = ingresarSincronizado();
        while (!estaEnRango(respuesta, minimo, maximo)) {
            IOLethos.mostrarTexto("El numero ingresado no esta dentro del rango valido. Vuelva a intentar.");
            respuesta = ingresarSincronizado();
        }
        return Integer.parseInt(respuesta);
    }
    
    public static int ingresarEnteroEnIntervalo(int minimo,
        int maximo)  {
        String respuesta = ingresarSincronizado();
        while (!estaEnRango(respuesta, minimo, maximo)) {
            IOLethos.mostrarTexto("El numero ingresado no esta dentro del rango valido. Vuelva a intentar.");
            respuesta = ingresarSincronizado();
        }
        return Integer.parseInt(respuesta);
    }
    
    public static double ingresarNumero(String mensaje)  {
        IOLethos.mostrarTexto(mensaje);
        String respuesta = ingresarSincronizado();
        while (!esDecimal(respuesta)) {
            IOLethos.mostrarTexto("El numero no es valido. Vuelva a intentar.");
            respuesta = ingresarSincronizado();
        }
        Double numero = Double.parseDouble(respuesta);
        return numero;
    }
    
    public static double ingresarNumeroEnIntervalo(String mensaje, double minimo,
        double maximo)  {
        IOLethos.mostrarTexto(mensaje);
        String respuesta = ingresarSincronizado();
        while (!estaEnRango(respuesta, minimo, maximo)) {
            IOLethos.mostrarTexto("El numero ingresado no es valido. Vuelva a intentar.");
            respuesta = ingresarSincronizado();
        }
        return Double.parseDouble(respuesta);
    }
}
