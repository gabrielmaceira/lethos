/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.sistemas;

import ifts16.pp.juego.componentes.Referencia;
import ifts16.pp.juego.componentes.Referencias;
import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import ifts16.pp.juego.utiles.Opcion;
import ifts16.pp.juego.utiles.Opciones;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import static lethos.sistemas.OrdenarLuchadores.*;
import static lethos.componentes.PartesCombate.ataqueEnemigo;
import lethos.entidades.Item;
import lethos.entidades.Jugador;
import lethos.entidades.Personaje;
import static lethos.sistemas.ListaAtaques.*;
import static lethos.componentes.ResultadoAtaques.*;
import static lethos.sistemas.Navegacion.mostrarStatus;
import static lethos.sistemas.SubirNivel.subirNivel;

/**
 *
 * @author Gabriel Maceira
 */
public class Combate {
    protected static Jugador playerActual;
    protected static ArrayList<Personaje> combatientes;
    protected static int posicion;
    protected static Personaje target;
    protected static boolean enCombate;
    protected static boolean defendiendo;

    public static void combatir(BaseLethos ubicacion, Jugador player) {
        playerActual = player;
        Referencias ref = ubicacion.getLuchadores();
        Referencia r = ref.traer(0);
        ArrayList<Personaje> quienesLuchan = new ArrayList<>();
        combatientes = quienesLuchan;
        Personaje enemigo = (Personaje) RepositorioPrincipal.traer(r.refiereA());
        target = enemigo;
        Personaje caballero = (Personaje) RepositorioPrincipal.traer("Caballero");
        Personaje mago = (Personaje) RepositorioPrincipal.traer("Mago");
        Personaje arquero = (Personaje) RepositorioPrincipal.traer("Arquero");
        
        enCombate = true;
        defendiendo = false;
        
        combatientes.add(caballero);
        combatientes.add(mago);
        combatientes.add(arquero);
        combatientes.add(enemigo);
        
        Collections.sort(combatientes, ordenVelocidad);
        
        while ((caballero.getCurrentHP() > 0 || mago.getCurrentHP() > 0 || arquero.getCurrentHP() > 0)
                && (enemigo.getCurrentHP() > 0) && (enCombate == true)) {
            for (int i = 0; i < combatientes.size(); i++) {
            if (combatientes.get(i).getCurrentHP() > 0 && (enCombate == true) &&
                (caballero.getCurrentHP() > 0 || mago.getCurrentHP() > 0 || arquero.getCurrentHP() > 0)
                && (enemigo.getCurrentHP() > 0) && (enCombate == true)) 
            {
                posicion = i;
                IOLethos.mostrarTexto(caballero.getNombre() + " - " +caballero.getCurrentHP() + "/" +
                        caballero.getMaxHP() + " HP");
                IOLethos.mostrarTexto(mago.getNombre() + " - " +mago.getCurrentHP() + "/" +
                        mago.getMaxHP() + " HP");
                IOLethos.mostrarTexto(arquero.getNombre() + " - " +arquero.getCurrentHP() + "/" +
                        arquero.getMaxHP() + " HP");
                IOLethos.mostrarTexto(enemigo.getNombre() + " - " +enemigo.getCurrentHP() + "/" +
                        enemigo.getMaxHP() + " HP\n");
                IOLethos.mostrarTexto("\n");
                IOLethos.mostrarTexto("Turno de " + combatientes.get(posicion).getNombre() + "\n");

                if (combatientes.get(posicion) != enemigo)
                {
                    if (combatientes.get(posicion).getNombre().equalsIgnoreCase("caballero")) {
                        defendiendo = false;
                    }
                    Opciones ops = opciones("Elija qué hacer este turno: ", combatientes.get(posicion));
                    Opcion eleccion = IOLethos.elegirOpcion(ops);
                    IOLethos.mostrarTexto("\n");
                    realizarAccionCombate(eleccion);
                }
                else {
                    if (defendiendo) 
                    {
                        ataqueEnemigo(combatientes, posicion, true);                        
                    } else 
                        {
                        ataqueEnemigo(combatientes, posicion, false);
                        }
                    }
                }
            IOLethos.mostrarTexto("\n");
            }
        }
        
        if (enemigo.getCurrentHP() == 0) {
            IOLethos.mostrarTexto("El party derrotó a " + enemigo.getNombre() + ".\n");
            if (playerActual.getNivel() < 7 && !ubicacion.isAniquilado())
            {
                playerActual.setNivel(playerActual.getNivel()+1);
                subirNivel(playerActual.getNivel());
                IOLethos.mostrarTexto("\nEl Party subió de nivel!\n");
                mostrarStatus();
                IOLethos.mostrarTexto("\n");    
            }
            ubicacion.setAniquilado(true);
        }
        caballero.setCurrentHP(caballero.getMaxHP());
        mago.setCurrentHP(mago.getMaxHP());
        arquero.setCurrentHP(arquero.getMaxHP());
        target.setCurrentHP(target.getMaxHP());
    } 
    
    public static void realizarAccionCombate(Opcion op) {
        switch (op.getComando()) {
            case "atacar":
                String resultado = ataqueFisico(combatientes.get(posicion), target, 100);
                IOLethos.mostrarTexto(resultadoAtaque(combatientes, posicion, combatientes.indexOf(target), resultado));
                break;
            case "defender":
                defendiendo = true;
                IOLethos.mostrarTexto("Caballero defiende este turno, protegiendo a sus aliados.");
                break;
            case "magia_blanca":
                hacerMagiaBlanca(combatientes, posicion);
                break;
            case "magia_negra":
                hacerMagiaNegra(combatientes, posicion);
                break;
            case "items":
                usarItem(combatientes, target);
                break;
            case "escapar":
                enCombate = false;
                IOLethos.mostrarTexto("Los héroes escapan del combate, para recuperar fuerzas y reagruparse.\n");
                break;
        }
    }

    public static void realizarMagiaNegra(Opcion op) {
        switch (op.getComando()) {
            case "fuego1":
                IOLethos.mostrarTexto(fuego1(combatientes.get(posicion), target));
                break;
            case "fuego2":
                IOLethos.mostrarTexto(fuego2(combatientes.get(posicion), target));
                break;
            case "fuego3":
                IOLethos.mostrarTexto(fuego3(combatientes.get(posicion), target));
                break;
            case "hielo1":
                IOLethos.mostrarTexto(hielo1(combatientes.get(posicion), target));
                break;
            case "hielo2":
                IOLethos.mostrarTexto(hielo2(combatientes.get(posicion), target));
                break;
            case "hielo3":
                IOLethos.mostrarTexto(hielo3(combatientes.get(posicion), target));
                break;
            case "trueno1":
                IOLethos.mostrarTexto(trueno1(combatientes.get(posicion), target));
                break;
            case "trueno2":
                IOLethos.mostrarTexto(trueno2(combatientes.get(posicion), target));
                break;
            case "caos":
                IOLethos.mostrarTexto(caos(combatientes.get(posicion), target));
                break;
            case "atras":
                Opciones ops = opciones("Elija qué hacer este turno: ", combatientes.get(posicion));
                Opcion eleccion = IOLethos.elegirOpcion(ops);
                IOLethos.mostrarTexto("\n");
                realizarAccionCombate(eleccion);
                break;
        }    
    }

    public static void realizarMagiaBlanca(Opcion op) {
        switch (op.getComando()) {
            case "cura1":
                IOLethos.mostrarTexto(curarParty(combatientes,combatientes.indexOf(target), 15));
                break;
            case "cura2":
                IOLethos.mostrarTexto(curarParty(combatientes,combatientes.indexOf(target), 25));
                break;
            case "cura3":
                IOLethos.mostrarTexto(curarParty(combatientes,combatientes.indexOf(target), 35));
                break;
            case "vida1":
                IOLethos.mostrarTexto(revivirParty(combatientes,combatientes.indexOf(target), 15));
                break;
            case "vida2":
                IOLethos.mostrarTexto(revivirParty(combatientes,combatientes.indexOf(target), 50));
                break;
            case "atras":
                Opciones ops = opciones("Elija qué hacer este turno: ", combatientes.get(posicion));
                Opcion eleccion = IOLethos.elegirOpcion(ops);
                IOLethos.mostrarTexto("\n");
                realizarAccionCombate(eleccion);
                break;
        }
    }
    
    public static Opciones opciones(String texto, Personaje personaje) {
       Opciones ops = new Opciones(texto);
       if ("Caballero".equals(personaje.getNombre()) || "Arquero".equals(personaje.getNombre())) {
        ops.agregar("atacar", "ATACAR");
       }
       if ("Caballero".equals(personaje.getNombre())) {
        ops.agregar("defender", "DEFENDER");
       }
       if ("Mago".equals(personaje.getNombre()) || "Arquero".equals(personaje.getNombre())) {       
        ops.agregar("magia_blanca", "MAGIA BLANCA");
       }
       if ("Mago".equals(personaje.getNombre())) {       
        ops.agregar("magia_negra", "MAGIA NEGRA");
       }
       ops.agregar("items", "ITEMS");
       ops.agregar("escapar", "ESCAPAR");
       return ops;
    }
    
    public static Opciones opcionesMagiaNegra(String texto, Personaje personaje) {
       Opciones ops = new Opciones(texto);
       ops.agregar("fuego1", "FUEGO");
       if ((playerActual.getNivel() > 2) || (playerActual.getNivel() + playerActual.getNivelFuego() > 2))
       {
        ops.agregar("fuego2", "ERUPCION");
       }
       if (playerActual.getNivel() > 2 && playerActual.getNivelFuego() > 0)
       {
        ops.agregar("fuego3", "INFIERNO");
       }
       ops.agregar("hielo1", "HIELO");
       if (playerActual.getNivel() > 1 || playerActual.getNivel() + playerActual.getNivelHielo() > 1)
       {
        ops.agregar("hielo2", "GLACIAR");
       }
       if (playerActual.getNivel() > 1 && playerActual.getNivelHielo() > 0)
       {
        ops.agregar("hielo3", "CERO ABSOLUTO");
       }
       ops.agregar("trueno1", "TRUENO");
       if (playerActual.getNivel() > 3)
       {
        ops.agregar("trueno2", "TORMENTA");
       }
       if (playerActual.getNivel() > 6)
       {
        ops.agregar("caos", "CAOS");
       }
       ops.agregar("atras", "Volver menú anterior");
       return ops;
    }
    
    public static Opciones opcionesMagiaBlanca(String texto, Personaje personaje) {
       Opciones ops = new Opciones(texto);
       if (("Mago".equals(personaje.getNombre()))
           || ("Arquero".equals(personaje.getNombre()))) 
       {
        ops.agregar("cura1", "CURAR");
       }
       if (("Mago".equals(personaje.getNombre()) && playerActual.getNivel() > 4)
           || ("Arquero".equals(personaje.getNombre())) && playerActual.getNivel() > 2) 
       {
        ops.agregar("cura2", "SALVACION");
       }
       if (("Arquero".equals(personaje.getNombre())) && playerActual.getNivel() > 5) 
       {
        ops.agregar("cura3", "BENDICION");
       }
       if (("Mago".equals(personaje.getNombre()) && playerActual.getNivelVida() > 0)
           || ("Arquero".equals(personaje.getNombre()) && (playerActual.getNivel() > 1))
           || ("Arquero".equals(personaje.getNombre())
                   && (playerActual.getNivel() + playerActual.getNivelVida() > 1))) 
       {
        ops.agregar("vida1", "VIDA");
       }
       if (("Arquero".equals(personaje.getNombre())) && playerActual.getNivel() > 1 
               && playerActual.getNivelVida() > 0) 
       {
        ops.agregar("vida2", "DESPERTAR");
       }
       ops.agregar("atras", "Volver menú anterior");
       return ops;
    }

    public static Opciones opcionesItems(String texto) {
       Opciones ops = new Opciones(texto); 
        ArrayList<UUID> listaItems = Fabrica.traerIdsItems();
        for (UUID id: listaItems) {
            Item item = (Item) RepositorioPrincipal.traer(id);
            if (item.getCantidad() > 0) 
            {
                ops.agregar(item.getNombre(), item.mostarItem());
            }
        }
        ops.agregar("atras", "Volver menú anterior");
       return ops;
    }
    
    public static void usarItem(ArrayList<Personaje> combatientes, Personaje enemigo) {
        Opciones ops = opcionesItems("Elija el item a usar: ");
        Opcion eleccion = IOLethos.elegirOpcion(ops);
        if ("besoDelAlba".equalsIgnoreCase(eleccion.getComando())) 
        {
            IOLethos.mostrarTexto(revivirParty(combatientes,combatientes.indexOf(enemigo), 25));
            Item usado = (Item) RepositorioPrincipal.traer("Beso Del Alba");
            usado.setCantidad(usado.getCantidad() - 1);
        } else if ("Elixir".equalsIgnoreCase(eleccion.getComando()))  
            {
                IOLethos.mostrarTexto(curarParty(combatientes,combatientes.indexOf(enemigo), 50));
                Item usado = (Item) RepositorioPrincipal.traer("Elixir");
                usado.setCantidad(usado.getCantidad() - 1);
            } else {
                if ("atras".equalsIgnoreCase(eleccion.getComando()))
                {
                    ops = opciones("Elija qué hacer este turno: ", combatientes.get(posicion));
                    eleccion = IOLethos.elegirOpcion(ops);
                    IOLethos.mostrarTexto("\n");
                    realizarAccionCombate(eleccion);
                }
            }
    }

    public static void hacerMagiaBlanca(ArrayList<Personaje> combatientes, int i) {
        Opciones ops = opcionesMagiaBlanca("Elija Magia Blanca: ", combatientes.get(i));
        Opcion eleccion = IOLethos.elegirOpcion(ops);
        IOLethos.mostrarTexto("\n");
        realizarMagiaBlanca(eleccion);
    }

    public static void hacerMagiaNegra(ArrayList<Personaje> combatientes, int i) {
        Opciones ops = opcionesMagiaNegra("Elija Magia Negra: ", combatientes.get(i));
        Opcion eleccion = IOLethos.elegirOpcion(ops);
        IOLethos.mostrarTexto("\n");
        realizarMagiaNegra(eleccion);
    }
    
    public static void escaparMasOMenos(ArrayList<Personaje> combatientes, Personaje target) {
        for (Personaje p: combatientes) {
            if (p != target) {
                p.setCurrentHP(0);
            }
        }
    }
    
}