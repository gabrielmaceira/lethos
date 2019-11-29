/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.sistemas;

import ifts16.pp.juego.sistemas.IOBase;
import ifts16.pp.juego.sistemas.NavegacionBase;
import static ifts16.pp.juego.sistemas.NavegacionBase.comerciar;
import static ifts16.pp.juego.sistemas.NavegacionBase.hablar;
import static ifts16.pp.juego.sistemas.NavegacionBase.hacerMisiones;
import static ifts16.pp.juego.sistemas.NavegacionBase.irPorPortal;
import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import ifts16.pp.juego.utiles.Opcion;
import ifts16.pp.juego.utiles.Opciones;
import java.awt.Color;
import java.util.UUID;
import lethos.entidades.Equipamiento;
import lethos.entidades.Item;
import lethos.entidades.Jugador;
import lethos.componentes.Menu;
import lethos.entidades.Personaje;
import static lethos.sistemas.Combate.*;
import static lethos.sistemas.Equipar.equiparItem;
/**
 *
 * @author Gabriel Maceira
 */
public class Navegacion extends NavegacionBase {
    public static BaseLethos ubicacionLethos;
    public static Jugador playerActual;
    public static Menu menuElegido;
 
    public static void iniciar(BaseLethos inicio, Jugador player) {
        ubicacionLethos = inicio;
        playerActual = player;
                
        while (ubicacionLethos != null) {
            
            IOLethos.mostrarTexto(ubicacionLethos.getNombre(), Color.BLUE, Color.WHITE);
            if (!ubicacionLethos.isAniquilado()) 
            {
                IOLethos.mostrarTexto(ubicacionLethos.getDescripcion());
            } 
            else 
                {
                    IOLethos.mostrarTexto(ubicacionLethos.getDescripcionSecundaria());
                }
            
            Opciones ops = ubicacionLethos.opciones("Elija que hacer en este lugar");
           
            ops.agregar("ninguno", "Salir del juego");
            Opcion eleccion = IOLethos.elegirOpcion(ops);
            IOLethos.mostrarTexto("Eligio: " + eleccion.getTexto() + "\n");
            if (eleccion.esComando() && eleccion.getComando().equalsIgnoreCase("ninguno")) {
                ubicacionLethos = null;
            } else {
                realizarAccion(eleccion);
            }
        }
        IOLethos.mostrarTexto("Fin del recorrido");
    }

    public static void realizarAccion(Opcion op) {
        switch (op.getComando()) {
            case "vecinos":
                irAVecino(ubicacionLethos);
                break;
            case "portal":
                irPorPortal(ubicacionLethos);
                break;
            case "luchadores":
                combatir(ubicacionLethos, playerActual);
                break;
            case "comerciantes":
                comerciar(ubicacionLethos);
                break;
            case "habladores":
                hablar(ubicacionLethos);
                break;
            case "misiones":
                hacerMisiones(ubicacionLethos);
                break;
            case "items":
                recolectarItems(ubicacionLethos);
                break;
            case "equipo":
                recolectarEquipo(ubicacionLethos);
                break;
            case "menu":
                abrirMenu();
                break;
            case "vuelo":
                volarAIpgra(ubicacionLethos);
                break;
            default:
                irAVecino(ubicacionLethos);
                break;
        }
    }

    public static void irAVecino(BaseLethos ubicacion) {
        Opciones ops = ubicacion.getVecinos()
                .opcionesActivas("Elija el lugar limítrofe a ir.");
        Opcion eleccion = IOLethos.elegirOpcion(ops);
        IOLethos.mostrarTexto("Eligio ir a " + eleccion.getTexto() + "\n");
        if (eleccion.esEntidad()) {
            ubicacionLethos = (BaseLethos) RepositorioPrincipal.traer(eleccion.getEntidadId());
        }
    }

    public static void volarAIpgra(BaseLethos ubicacion) {
        System.out.println(RepositorioPrincipal.traer("ipgra").getNombre());
        ubicacionLethos = (BaseLethos) RepositorioPrincipal.traer("ipgra");
    }    
    
    public static void recolectarItems(BaseLethos ubicacion) {
    Opciones ops = ubicacion.getItems()
                .opcionesActivas("Elija que recoger: ");
        Opcion eleccion = IOLethos.elegirOpcion(ops);
            Item itemElegido = (Item) RepositorioPrincipal.traer(eleccion.getEntidadId());
            itemElegido.setCantidad(itemElegido.getCantidad() + 1);
            itemElegido.setActivo(true);
            ubicacion.getItems().eliminar(eleccion.getEntidadId());
        IOBase.mostrarTexto("Eligio recoger " + eleccion.getTexto());
        IOBase.mostrarTexto(itemElegido.getDescripcion() + "\n");
        if (eleccion.getTexto() == "Bendición de Fuego") {
            playerActual.setNivelFuego(1);
        }
        if (eleccion.getTexto() == "Bendición de Hielo") {
            playerActual.setNivelHielo(1);
        }
        if (eleccion.getTexto() == "Bendición de Vida") {
            playerActual.setNivelVida(1);
        }
    }
    
    public static void recolectarEquipo(BaseLethos ubicacion) {
    Opciones ops = ubicacion.getEquipoLugar().opcionesActivas("\nElija que recoger: ");
        Opcion eleccion = IOLethos.elegirOpcion(ops);
            Equipamiento equipo = (Equipamiento) RepositorioPrincipal.traer(eleccion.getEntidadId());
            equipo.setActivo();
            ubicacion.getEquipoLugar().eliminar(eleccion.getEntidadId());
        IOBase.mostrarTexto("Eligio recoger " + eleccion.getTexto());
        IOBase.mostrarTexto(equipo.getDescripcion()+"\n");
    }
    
    public static void abrirMenu() {
       String menuPrincipal = "menu_principal";
       menuElegido = (Menu) RepositorioPrincipal.traer(menuPrincipal);
       while (menuElegido != null) {
            IOBase.borrar();
            IOBase.mostrarTexto(menuElegido.getNombre() + "\n", Color.BLUE, Color.WHITE);
            if ("Menu de Items".equals(menuElegido.getNombre())) {
                abrirMenuItems();
                IOBase.mostrarTexto("\n" + menuElegido.getNombre() + "\n", Color.BLUE, Color.WHITE);
            }
            if ("Menu de Equipo".equals(menuElegido.getNombre())) {
                abrirMenuEquipo();
                IOBase.mostrarTexto("\n" + menuElegido.getNombre() + "\n", Color.BLUE, Color.WHITE);
            }
            if ("Menu de Status".equals(menuElegido.getNombre())) {
                mostrarStatus();
                IOBase.mostrarTexto("\n" + menuElegido.getNombre() + "\n", Color.BLUE, Color.WHITE);
            }
        Opciones ops = menuElegido.getPartesMenu().opcionesActivas("Elija la opcion del menu: ");
            ops.agregar("ninguno", "Salir del Menu");
            Opcion eleccion = IOLethos.elegirOpcion(ops);
            if (eleccion.esComando() && eleccion.getComando().equalsIgnoreCase("ninguno")) {
                menuElegido = null;
            } else {
                
                menuElegido = (Menu) RepositorioPrincipal.traer(eleccion.getEntidadId());
            }
        }
    }

    public static void abrirMenuItems() {
        for (UUID id: FabricaPrincipalLethos.traerIdsItems()) {
            Item it = (Item) RepositorioPrincipal.traer(id);
            IOLethos.mostrarTexto(it.mostarItem());
        }
    }
    
    public static void abrirMenuEquipo() {
       String menuPrincipal = "menu_principal";
       menuElegido = (Menu) RepositorioPrincipal.traer(menuPrincipal);
        Opciones ops = playerActual.getOpcionesActivasEquipo();
        Opcion eleccion = IOLethos.elegirOpcion(ops);
        if (eleccion.getTexto().equalsIgnoreCase("Volver al Menu Principal"))
        {
            menuElegido = (Menu) RepositorioPrincipal.traer(menuPrincipal);
        } else {
            IOLethos.mostrarTexto("Equipaste " + eleccion.getTexto());
            Equipamiento itemAEquipar = (Equipamiento) RepositorioPrincipal.traer(eleccion.getEntidadId());
            Personaje personaje = (Personaje) RepositorioPrincipal.traer(itemAEquipar.getClase());
            IOLethos.mostrarTexto("Antes de Equipar");
            personaje.mostrarEstado();
            equiparItem(itemAEquipar, personaje);
            IOLethos.mostrarTexto("Después de Equipar");
            personaje.mostrarEstado();
            menuPrincipal = "menu_principal";
            menuElegido = (Menu) RepositorioPrincipal.traer(menuPrincipal);
        }
    }
    
    public static void mostrarStatus() {
        for (UUID id: FabricaPrincipalLethos.traerIdsPersonajes()) {
            Personaje personaje = (Personaje) RepositorioPrincipal.traer(id);
            
            personaje.mostrarEstado();
            
        }
    }
    
}