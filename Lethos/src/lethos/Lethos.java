/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos;

import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import java.awt.EventQueue;
import lethos.entidades.Jugador;
import lethos.sistemas.BaseLethos;
import lethos.sistemas.Fabrica;
import lethos.sistemas.IOLethos;
import lethos.sistemas.Navegacion;

/**
 *
 * @author Gabriel Maceira
 */
public class Lethos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IOLethos ventana = new IOLethos();
        EventQueue.invokeLater(ventana);
        Jugador player = new Jugador();
        Fabrica.crearLugares();
        Fabrica.crearPersonajes();
        Fabrica.crearEnemigos();
        Fabrica.asignarEnemigoLugar();
        Fabrica.crearMenu();
        Fabrica.crearItems();
        Fabrica.asignarItemLugar();
        Fabrica.crearEquipamiento(player);
        Fabrica.equipoIncialPersonajes();
        BaseLethos lugarDeInicio = (BaseLethos) RepositorioPrincipal.traer("inicio");
        Navegacion.iniciar(lugarDeInicio, player);
    }
    
}
