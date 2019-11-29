/*
 * The MIT License
 *
 * Copyright 2018 fernando.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ifts16.pp.juego.sistemas;


import ifts16.pp.juego.utiles.Opcion;
import ifts16.pp.juego.utiles.Opciones;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class IOBase extends JFrame implements Runnable {
    protected static JScrollPane panel = new JScrollPane();
    protected static JTextArea salida = new JTextArea();
    protected static JTextField entrada = new JTextField();;
    protected static final Thread control = new Thread();
    public static String modo = "principal";
    
    public IOBase() {
        iniciar();
    }
    
    protected void iniciar() {
        this.setTitle("Juego");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        entrada.setColumns(80);
        entrada.setFont(new Font("Arial", Font.BOLD, 20));
        entrada.setColumns(80);
        salida.setEditable(false);
        salida.setColumns(80);
        salida.setRows(5);
        salida.setLineWrap(true);
        salida.setFont(new Font("Arial", Font.BOLD, 20));
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
                .addComponent(panel, 400, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE))
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
                .addComponent(panel, 400, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addGap(15)
                .addComponent(entrada, 50, 50, 50)
                .addContainerGap()
        ));

        pack();
    }
    
    protected static String ingresarSincronizado() {
        synchronized(control) {
            try {
                control.wait();
            } catch (InterruptedException ex) {
            }
           String respuesta = entrada.getText();
           entrada.setText("");
           return respuesta;
        }
    }
    
    protected static boolean esEntero(String texto) {
        Integer num;
        boolean respuesta = true;
        try {
            num = Integer.parseInt(texto);
        } catch (NumberFormatException | NullPointerException e) {
            respuesta = false;
        } finally {
            return respuesta;
        }
    }
    
    protected static boolean estaEnRango(String texto, int minimo, int maximo) {
        Integer num;
        boolean respuesta = true;
        try {
            num = Integer.parseInt(texto);
            if (num < minimo || num > maximo) {
                respuesta = false;
            }
        } catch (NumberFormatException | NullPointerException e) {
            respuesta = false;
        } finally {
            return respuesta;
        }
    }
    
    protected static boolean esDecimal(String texto) {
        Double num;
        boolean respuesta = true;
        try {
            num = Double.parseDouble(texto);
        } catch (NumberFormatException | NullPointerException e) {
            respuesta = false;
        } finally {
            return respuesta;
        }
    }
    
    protected static boolean estaEnRango(String texto, double minimo, double maximo) {
        Double num;
        boolean respuesta = true;
        try {
            num = Double.parseDouble(texto);
            if (num < minimo || num > maximo) {
                respuesta = false;
            }
        } catch (NumberFormatException | NullPointerException e) {
            respuesta = false;
        } finally {
            return respuesta;
        }
    }

    @Override
    public void run() {
        this.setVisible(true);
    }
    
        
    
    public static Opcion elegirOpcion(Opciones opciones) {
        mostrarTexto(opciones.getMensaje());
        ArrayList<String> mensajes = opciones.darFormato();
        mostrarTextos(mensajes);
        int respuesta = ingresarEnteroEnIntervalo(1, opciones.cantidad());
        return opciones.opcionElegida(respuesta);
    }
    
    public static void mostrarTexto(String mensaje) {
        IOBase.salida.append(mensaje + "\n");
    }
    
    public static void mostrarTexto(String mensaje, Color texto, Color fondo) {
        IOBase.salida.setForeground(texto);
        IOBase.salida.setBackground(fondo);
        IOBase.salida.append(mensaje + "\n");
    }
    
    public static void mostrarTextos(ArrayList<String> mensajes) {
        for (String msj: mensajes) {
            IOBase.salida.append(msj + "\n");
        }
    }
    
    public static void mostrarTextos(ArrayList<String> mensajes, Color texto, Color fondo) {
        IOBase.salida.setForeground(texto);
        IOBase.salida.setBackground(fondo);
        for (String msj: mensajes) {
            IOBase.salida.append(msj + "\n");
        }
    }
     
    
    public static void borrar() {
        IOBase.salida.setText(null);
    }
    public static String ingresarTexto(String mensaje)  {
        mostrarTexto(mensaje);
        String respuesta = ingresarSincronizado(); 
        return respuesta;
    }
    
    public static int ingresarEntero(String mensaje)  {
        mostrarTexto(mensaje);
        String respuesta = ingresarSincronizado();
        while (!esEntero(respuesta)) {
            mostrarTexto("El numero no es entero. Vuelva a intentar.");
            respuesta = ingresarSincronizado();
        }
        Integer numero = Integer.parseInt(respuesta);
        return numero;
    }
    
     public static int ingresarEnteroEnIntervalo(String mensaje, int minimo,
        int maximo)  {
        mostrarTexto(mensaje);
        String respuesta = ingresarSincronizado();
        while (!estaEnRango(respuesta, minimo, maximo)) {
            mostrarTexto("El numero ingresado no esta dentro del rango valido. Vuelva a intentar.");
            respuesta = ingresarSincronizado();
        }
        return Integer.parseInt(respuesta);
    }
    
    public static int ingresarEnteroEnIntervalo(int minimo,
        int maximo)  {
        String respuesta = ingresarSincronizado();
        while (!estaEnRango(respuesta, minimo, maximo)) {
            mostrarTexto("El numero ingresado no esta dentro del rango valido. Vuelva a intentar.");
            respuesta = ingresarSincronizado();
        }
        return Integer.parseInt(respuesta);
    }
    
    public static double ingresarNumero(String mensaje)  {
        mostrarTexto(mensaje);
        String respuesta = ingresarSincronizado();
        while (!esDecimal(respuesta)) {
            mostrarTexto("El numero no es valido. Vuelva a intentar.");
            respuesta = ingresarSincronizado();
        }
        Double numero = Double.parseDouble(respuesta);
        return numero;
    }
    
    public static double ingresarNumeroEnIntervalo(String mensaje, double minimo,
        double maximo)  {
        mostrarTexto(mensaje);
        String respuesta = ingresarSincronizado();
        while (!estaEnRango(respuesta, minimo, maximo)) {
            mostrarTexto("El numero ingresado no es valido. Vuelva a intentar.");
            respuesta = ingresarSincronizado();
        }
        return Double.parseDouble(respuesta);
    }
    
   
}
