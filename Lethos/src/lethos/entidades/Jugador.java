/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.entidades;

import Utiles.OpcionesLethos;
import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import ifts16.pp.juego.utiles.Opcion;
import ifts16.pp.juego.utiles.Opciones;
import java.util.UUID;

/**
 *
 * @author Gabriel Maceira
 */
public class Jugador {
    protected int nivel;
    protected OpcionesLethos opcionesEquipo;
    protected int nivelFuego;
    protected int nivelHielo;
    protected int nivelVida;    
    
    public Jugador() {
        this.setNivel(1);
        opcionesEquipo = new OpcionesLethos("Elija que equipar: ");
        this.nivelFuego = 0;
        this.nivelHielo = 0;
        this.nivelVida = 0;
    }
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Opciones getOpcionesEquipo() {
        return opcionesEquipo;
    }

    public Opciones getOpcionesActivasEquipo() {
        Opciones lista = new OpcionesLethos();
        for (int i = 0; i < this.opcionesEquipo.getSize(); i++)
        {           
            UUID id = this.opcionesEquipo.getOpcionLethos(i).getEntidadId();
            Equipamiento equipo = (Equipamiento) RepositorioPrincipal.traer(id);
            
            if (equipo.isActivo()) 
            {
                lista.agregar(this.opcionesEquipo.getOpcionLethos(i));
            }
        }
        lista.agregar("menu_principal", "Volver al Menu Principal");
        return lista;
    }

    public void setOpcionesLethosEquipo(OpcionesLethos opcionesEquipo) {
        this.opcionesEquipo = opcionesEquipo;
    }
    
    

    public int getNivelFuego() {
        return nivelFuego;
    }

    public void setNivelFuego(int nivelFuego) {
        this.nivelFuego = nivelFuego;
    }

    public int getNivelHielo() {
        return nivelHielo;
    }

    public void setNivelHielo(int nivelHielo) {
        this.nivelHielo = nivelHielo;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }
}
