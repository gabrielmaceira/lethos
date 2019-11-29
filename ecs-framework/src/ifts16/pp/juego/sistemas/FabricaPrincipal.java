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

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author fernando
 */
public abstract class FabricaPrincipal extends FabricaAbstracta {
    protected static ArrayList<UUID> lugaresCreados = new ArrayList<>();
    protected static ArrayList<UUID> personajesCreados = new ArrayList<>();
    protected static ArrayList<UUID> itemsCreados = new ArrayList<>();
    protected static ArrayList<String> nombresLugaresCreados = new ArrayList<>();
    protected static ArrayList<String> nombresPersonajesCreados = new ArrayList<>();
    protected static ArrayList<String> nombresItemsCreados = new ArrayList<>();

    public static boolean agregarIdLugar(UUID id) {
        return lugaresCreados.add(id);
    }
    
    public static boolean agregarIdPersonaje(UUID id) {
        return personajesCreados.add(id);
    }
    
    public static boolean agregarIdItem(UUID id) {
        return itemsCreados.add(id);
    }

    /**
     * @return the lugaresCreados
     */
    public static ArrayList<UUID> traerLugaresCreados() {
        return lugaresCreados;
    }

    /**
     * @return the personajesCreados
     */
    public static ArrayList<UUID> traerIdsPersonajes() {
        return personajesCreados;
    }

    /**
     * @return the itemsCreados
     */
    public static ArrayList<UUID> traerIdsItems() {
        return itemsCreados;
    }
    
    
    /**
     * @return the nombresLugaresCreados
     */
    public static ArrayList<String> traerNombresLugares() {
        return nombresLugaresCreados;
    }

    /**
     * @return the nombresPersonajesCreados
     */
    public static ArrayList<String> traerNombresPersonajes() {
        return nombresPersonajesCreados;
    }

    /**
     * @return the nombresItemsCreados
     */
    public static ArrayList<String> traerNombresItems() {
        return nombresItemsCreados;
    }
        
    public static void crearPersonajeJugador() {
        
    }
    
    public static void crearLugares() {
        
    }
    
    public static void crearPersonajes() {
        
    }
    
    public static void conectarMundo() {
        
    }
    
    public static void poblarMundo() {
        
    }
    
    public static void agregarItemsAMundo() {
        
    }
    
    public static void agregarItemsAPersonajes() {
        
    }
}
