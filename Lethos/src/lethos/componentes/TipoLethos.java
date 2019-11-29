/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.componentes;

/**
 *
 * @author Gabriel Maceira
 */
public enum TipoLethos {
    Item,
    Lugar,
    Personaje,
    Jugador,
    MenuItem,
    Equipo;
    
    @Override
    public String toString() {
       switch (this){
           case Item:
               return "Item";
           case Lugar:
               return "Lugar";
           case Personaje:
               return "Personaje";
           case Jugador:
               return "Jugador";
           case MenuItem:
               return "Menu";
           case Equipo:
               return "Equipo";
           default:
               return "";
       }      
    }
}
            
