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
import java.util.ArrayList;
import java.util.UUID;


public abstract class Fabrica<E extends Entidad> extends FabricaAbstracta {
    protected static ArrayList<UUID> entidadesCreadas;
    protected static ArrayList<String> nombresEntidadesCreadas;
    
    public static boolean agregarId(UUID id) {
        return entidadesCreadas.add(id);
    }
    
    public static boolean agregarNombre(String nombre) {
        return nombresEntidadesCreadas.add(nombre);
    }
    
    public static ArrayList<UUID> traerIds() {
        return entidadesCreadas;
    }
    
    public static ArrayList<String> traerNombres() {
        return nombresEntidadesCreadas;
    }
    
    public abstract E crear();
    public abstract E crear(String nombre);
}
