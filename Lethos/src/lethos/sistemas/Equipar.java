/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.sistemas;

import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import lethos.entidades.Equipamiento;
import lethos.entidades.Personaje;

/**
 *
 * @author Gabriel Maceira
 */
public class Equipar {
    
    public static void equiparItem(Equipamiento equipo, Personaje personaje) {
        if (equipo.getTipo().equals("espada") || 
            equipo.getTipo().equals("arco")||
            equipo.getTipo().equals("cetro")) 
        {
        
            if (personaje.getManoDerecha() != null) 
            {
                Equipamiento viejoEquipo = (Equipamiento) RepositorioPrincipal.traer(personaje.getManoDerecha());
                desequiparItem(viejoEquipo, personaje);
                equiparItem(equipo, personaje);
            } 
            else 
            {
                personaje.setManoDerecha(equipo.getId());
                aumentarStatus(equipo, personaje);
                equipo.setInactivo();
            }
        }
        else if (equipo.getTipo().equals("escudo") || 
                 equipo.getTipo().equals("flechas")) 
        {
                
            if (personaje.getManoIzquierda() != null) 
            {
                Equipamiento viejoEquipo = (Equipamiento) RepositorioPrincipal.traer(personaje.getManoIzquierda());
                desequiparItem(viejoEquipo, personaje);
                equiparItem(equipo, personaje);
            } 
            else 
            {
                personaje.setManoIzquierda(equipo.getId());
                aumentarStatus(equipo, personaje);
                equipo.setInactivo();
            }
        }
        else if (equipo.getTipo().equals("armadura") || 
                 equipo.getTipo().equals("pechera") || 
                 equipo.getTipo().equals("tunica")) 
        {
                
            if (personaje.getArmadura() != null) 
            {
                Equipamiento viejoEquipo = (Equipamiento) RepositorioPrincipal.traer(personaje.getArmadura());
                desequiparItem(viejoEquipo, personaje);
                equiparItem(equipo, personaje);
            } 
            else 
            {
                personaje.setArmadura(equipo.getId());
                aumentarStatus(equipo, personaje);
                equipo.setInactivo();
            }
        }
        else if (equipo.getTipo().equals("accesorio")) 
        {
             if (personaje.getAccesorio() != null) {
                    Equipamiento viejoEquipo = (Equipamiento) RepositorioPrincipal.traer(personaje.getAccesorio());
                    desequiparItem(viejoEquipo, personaje);
                    equiparItem(equipo, personaje);
            } 
             else {
                 personaje.setAccesorio(equipo.getId());
                 aumentarStatus(equipo, personaje);
                 equipo.setInactivo();
             }
        }
            
    }
    
    public static void desequiparItem(Equipamiento equipo, Personaje personaje) {
        if (equipo.getTipo().equals("espada") || 
            equipo.getTipo().equals("arco")||
            equipo.getTipo().equals("cetro")) 
            {
                personaje.setManoDerecha(null);
                reducirStatus(equipo, personaje);
                equipo.setActivo();
            }
        if (equipo.getTipo().equals("escudo") || 
            equipo.getTipo().equals("flechas")) 
            {
                personaje.setManoIzquierda(null);
                reducirStatus(equipo, personaje);
                equipo.setActivo();
            } 
        if (equipo.getTipo().equals("armadura") || 
            equipo.getTipo().equals("pechera") || 
            equipo.getTipo().equals("tunica")) 
            {
                personaje.setArmadura(null);
                reducirStatus(equipo, personaje);
                equipo.setActivo();
            } 
        if (equipo.getTipo().equals("accesorio")) 
            {
                personaje.setAccesorio(null);
                reducirStatus(equipo, personaje);
                equipo.setActivo();
            }        
    }


    public static void aumentarStatus(Equipamiento equipo, Personaje personaje) {
        personaje.setAtaque(personaje.getAtaque() + equipo.getAtaque());
        personaje.setDefensa(personaje.getDefensa() + equipo.getDefensa());
        personaje.setCantidadAtaques(personaje.getCantidadAtaques() + equipo.getCantidadAtaques());
        personaje.setMagia(personaje.getMagia() + equipo.getMagia());
        personaje.setDefensaMagica(personaje.getDefensaMagica() + equipo.getDefensaMagica());
        personaje.setVelocidad(personaje.getVelocidad() + equipo.getVelocidad());
        personaje.setAccuracy(personaje.getAccuracy() + equipo.getAccuracy()); 
    }
    
    public static void reducirStatus(Equipamiento equipo, Personaje personaje) {
        personaje.setAtaque(personaje.getAtaque() - equipo.getAtaque());
        personaje.setDefensa(personaje.getDefensa() - equipo.getDefensa());
        personaje.setCantidadAtaques(personaje.getCantidadAtaques() - equipo.getCantidadAtaques());
        personaje.setMagia(personaje.getMagia() - equipo.getMagia());
        personaje.setDefensaMagica(personaje.getDefensaMagica() - equipo.getDefensaMagica());
        personaje.setVelocidad(personaje.getVelocidad() - equipo.getVelocidad());
        personaje.setAccuracy(personaje.getAccuracy() - equipo.getAccuracy());  
    }    
    
}
