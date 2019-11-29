/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.sistemas;

import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import lethos.entidades.Personaje;

/**
 *
 * @author Gabriel Maceira
 */
public class SubirNivel {
    
    public static void subirNivel(int nivel) {
        elegirNivel(nivel);
    }
    
    public static void subirNivelPersonaje(Personaje personaje, int maxHP, int currentHP, int ataque, 
            int defensa, int velocidad, int cantidadAtaques, int magia, int defensaMagica, int accuracy) {
        personaje.setMaxHP(personaje.getMaxHP() + maxHP);
        personaje.setCurrentHP(personaje.getCurrentHP() + currentHP);
        personaje.setAtaque(personaje.getAtaque() + ataque);
        personaje.setDefensa(personaje.getDefensa() + defensa);
        personaje.setVelocidad(personaje.getVelocidad() + velocidad);
        personaje.setCantidadAtaques(personaje.getCantidadAtaques() + cantidadAtaques);
        personaje.setMagia(personaje.getMagia() + magia);
        personaje.setDefensaMagica(personaje.getDefensaMagica() + defensaMagica);
        personaje.setAccuracy(personaje.getAccuracy() + accuracy);
    }
    
        public static void elegirNivel(int i) {
        Personaje caballero = (Personaje) RepositorioPrincipal.traer("Caballero");
        Personaje mago = (Personaje) RepositorioPrincipal.traer("Mago");
        Personaje arquero = (Personaje) RepositorioPrincipal.traer("Arquero");

        switch (i) {
            case 2:
                subirNivelPersonaje(caballero, 110, 110, 30, 40, 10,  0,  0, 10, 40);
                subirNivelPersonaje(mago,       60,  60,  0, 35, 10,  0, 25, 40,  0);
                subirNivelPersonaje(arquero,    80,  80, 20, 25, 30,  0, 25, 15, 20);
                break;
            case 3:
                subirNivelPersonaje(caballero, 110, 110, 30, 30, 30,  0,  0,  0, 10);
                subirNivelPersonaje(mago,       60,  60,  0, 15, 15,  0, 35, 45,  0);
                subirNivelPersonaje(arquero,    85,  85, 20, 15, 10,  1, 25, 35, 20);
                break;
            case 4:
                subirNivelPersonaje(caballero, 180, 180, 30, 30, 10,  1,  0, 15, 20);
                subirNivelPersonaje(mago,       30,  30,  0, 15, 35,  0, 20, 20,  0);
                subirNivelPersonaje(arquero,   180, 180, 10, 15, 20,  0,  5, 15, 20);
                break;
            case 5:
                subirNivelPersonaje(caballero, 130, 130, 30, 30, 30,  0,  0, 15, 10);
                subirNivelPersonaje(mago,      130, 130,  0, 25, 10,  0, 60, 40,  0);
                subirNivelPersonaje(arquero,   125, 125, 10, 15, 10,  0, 45, 20, 20);
                break;
            case 6:
                subirNivelPersonaje(caballero, 130, 130, 35, 25,  5,  0,  0, 20, 30);
                subirNivelPersonaje(mago,       70,  70,  0, 30, 40,  0, 25, 10,  0);
                subirNivelPersonaje(arquero,   130, 130, 45, 10, 20,  0, 30, 30,  0);
                break;
            case 7:
                subirNivelPersonaje(caballero, 139, 139, 40, 15,  0,  1,  0, 30, 10);
                subirNivelPersonaje(mago,      120, 120,  0,  0,  0,  0, 40, 30,  0);
                subirNivelPersonaje(arquero,   105, 105, 35, 15, 40,  1, 20,  0, 50);
                break;
        }
    }
    
}
