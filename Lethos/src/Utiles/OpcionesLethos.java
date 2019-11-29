/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import ifts16.pp.juego.utiles.Opcion;
import ifts16.pp.juego.utiles.Opciones;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Gabriel Maceira
 */
public class OpcionesLethos extends Opciones{

    public OpcionesLethos() {
        this.lista = new ArrayList<>();
        this.mensaje = "Seleccionar una de las siguientes opciones";
    }
    
    public OpcionesLethos(String mensaje) {
        this.lista = new ArrayList<>();
        this.mensaje = mensaje;
    }
    
    public void borrar(UUID id) {
        for (Opcion op: lista) 
        {
            if (op.getEntidadId() == id) 
            {
                this.lista.remove(op);                
            }
        }
    }
    
    public int getSize() {
        return this.lista.size();
    }
    
    public Opcion getOpcionLethos(int i) {
        return this.lista.get(i);
    }
}
