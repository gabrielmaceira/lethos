/*
 * The MIT License
 *
 * Copyright 2018 Fernando Neubaum.
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


public class Repositorio<E extends Entidad> extends Sistema {
    protected HashMap<UUID,E> entidades = new HashMap<>();
    protected HashMap<String,UUID> nombres = new HashMap<>();

    
    public UUID obtenerId(String nombre) {
        return nombres.get(nombre);
    }
    
    public E traer(UUID id) {
        return entidades.get(id);
    }
    
    public E traer(String nombre) {
        UUID id = nombres.get(nombre);
        if (id == null) {
            return null;
        } else {
            return this.entidades.get(id);
        }
        
    }
    
    public E agregar(E ent) {
         return entidades.put(ent.getId(), ent);
    }
    
    public E agregar(E ent, String nombre) {
        E retorno = entidades.put(ent.getId(), ent);
        nombres.put(nombre, ent.getId());
        return retorno;  
    }
    
    public boolean existe(UUID id) {
        return entidades.containsKey(id);
    }
    
    public boolean existe(String nombre) {
        UUID id = this.obtenerId(nombre);
        return entidades.containsKey(id) && nombres.containsKey(nombre);
    }
    
    public  E reemplazar(E ent) {
        return entidades.put(ent.getId(), ent);
    }
    
    public E reemplazar(E ent, String nombre) {
        UUID id = nombres.get(nombre);
        if (id == null) {
            return null;
        } else {
            return entidades.put(id, ent);
        } 
    }
    
    public E eliminar(E ent) {
        return entidades.remove(ent.getId());
    }
    
    public E eliminar(UUID id) {
        return entidades.remove(id);
    }
    
    public E eliminar(String nombre) {
        UUID id = nombres.get(nombre);
        if (id == null) {
            return null;
        } else {
            return entidades.remove(id);
        } 
    }
    
    @Override
    public String toString() {
        return "Repositorio " + this.getClass().getSimpleName();
    }
}
