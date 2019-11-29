/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.sistemas;

import ifts16.pp.juego.sistemas.FabricaPrincipal;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Gabriel Maceira
 */
public class FabricaPrincipalLethos extends FabricaPrincipal {
    private static ArrayList<UUID> menusCreados = new ArrayList<>();
    private static ArrayList<UUID> equiposCreados = new ArrayList<>();
    private static ArrayList<String> nombresMenusCreados = new ArrayList<>();
    private static ArrayList<String> nombresEquiposCreados = new ArrayList<>();
 
    public static boolean agregarIdMenu(UUID id) {
    return menusCreados.add(id);
    }
    
    public static boolean agregarIdEquipo(UUID id) {
    return equiposCreados.add(id);
    }
    
    public static ArrayList<UUID> traerIdsMenus() {
        return menusCreados;
    }
    
    public static ArrayList<String> traerNombresMenus() {
        return nombresMenusCreados;
    }
    
    public static ArrayList<UUID> traerIdsEquipos() {
        return equiposCreados;
    }
    
    public static ArrayList<String> traerNombresEquipos() {
        return nombresEquiposCreados;
    }

    
}
