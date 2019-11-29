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

import ifts16.pp.juego.entidades.Entidad;
import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author fernando
 */
public class RepositorioPrincipal extends Sistema {
    protected static HashMap<UUID,Entidad> entidades = new HashMap<>();
    protected static HashMap<String,UUID> nombres = new HashMap<>();

    
    public static UUID obtenerId(String nombre) {
        return nombres.get(nombre);
    }
    
    public static Entidad traer(UUID id) {
        return entidades.get(id);
    }
    
    public static Entidad traer(String nombre) {
        UUID id = nombres.get(nombre);
        if (id == null) {
            return null;
        } else {
            return entidades.get(id);
        }
        
    }
    
    public static Entidad agregar(Entidad ent) {
         return entidades.put(ent.getId(), ent);
    }
    
    public static Entidad agregar(Entidad ent, String nombre) {
        Entidad retorno = entidades.put(ent.getId(), ent);
        nombres.put(nombre, ent.getId());
        return retorno;
    }
    
    public static boolean existe(UUID id) {
        return entidades.containsKey(id);
    }
    
    public static boolean existe(String nombre) {
        UUID id = obtenerId(nombre);
        return entidades.containsKey(id) && nombres.containsKey(nombre);
    }
    
    public static Entidad reemplazar(Entidad ent) {
        return entidades.put(ent.getId(), ent);
    }

    
    public static Entidad eliminar(Entidad ent) {
        return entidades.remove(ent.getId());
    }
    
    public static Entidad eliminar(UUID id) {
        return entidades.remove(id);
    }
    
    public static Entidad eliminar(String nombre) {
        UUID id = nombres.get(nombre);
        if (id == null) {
            return null;
        } else {
            return entidades.remove(id);
        } 
    }
    
    @Override
    public String toString() {
        return "Repositorio Principal";
    }
}
