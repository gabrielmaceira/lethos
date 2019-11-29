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
package ifts16.pp.juego.componentes;

import ifts16.pp.juego.utiles.ConActividad;
import ifts16.pp.juego.utiles.Opciones;
import java.util.ArrayList;
import java.util.UUID;


public class Referencias<R extends Referencia> extends Componente implements ConActividad {
    protected ArrayList<R> lista;
    
    public Referencias() {
        this.lista = new ArrayList<>();
    }
    
    public R agregar(R ref) {
        if (this.lista.add(ref)) {
            return ref;
        }
        return null;
    }
    
    public R traer(UUID id) {
        for (R ref: lista) {
            if (ref.refiereA() == id) {
                return ref;
            }
        }
        return null;
    }
    
    public R traer(int posicion) {
        return lista.get(posicion);
    }
    
    public boolean existe(UUID id) {
        for (R ref: lista) {
            if (ref.refiereA() == id) {
                return true;
            }
        }
        return false;
    }
    
    public R reemplazar(R referencia) {
        for (R ref: lista) {
            if (ref.refiereA() == referencia.refiereA()) {
                this.lista.remove(ref);
                this.lista.add(referencia);
                return referencia;
            }
        }
        return null;
    }
    
    public boolean eliminar(UUID id) {
        for (R ref: lista) {
            if (ref.refiereA() == id) {
                lista.remove(ref);
            }
            return true;
        }
        return false;
    }
    
    public boolean eliminar(R referencia) {
        return lista.remove(referencia);
    }
    
    public R eliminar(int posicion) {
        return lista.remove(posicion);
    }
    
    public boolean vacio() {
        return this.lista.isEmpty();
    }
    
    public ArrayList<R> mostrar() {
        return this.lista;
    }
    
    public ArrayList<R> mostrarActivas() {
        ArrayList<R> activas = new ArrayList<R>();
        for (R r : this.lista) {
            if (r.estaActiva()) {
                activas.add(r);
            }
        }
        return activas;
    }
    
    public ArrayList<R> mostrarInactivas() {
        ArrayList<R> inactivas = new ArrayList<R>();
        for (R r : this.lista) {
            if (!r.estaActiva()) {
                inactivas.add(r);
            }
        }
        return inactivas;
    }
    
    @Override
    public Opciones opciones(String mensaje) {
        Opciones ops = new Opciones(mensaje);
        for (R ref: this.mostrar()) {
            ops.agregar(ref.refiereA(), ref.verTexto());
        }
        return ops;
    }
    
    @Override
    public Opciones opcionesActivas(String mensaje) {
        Opciones ops = new Opciones(mensaje);
        for (R ref: this.mostrarActivas()) {
            ops.agregar(ref.refiereA(), ref.verTexto());
        }
        return ops;
    }
    
    @Override
    public Opciones opcionesInactivas(String mensaje) {
        Opciones ops = new Opciones(mensaje);
        for (R ref: this.mostrarInactivas()) {
            ops.agregar(ref.refiereA(), ref.verTexto());
        }
        return ops;
    }
    
    @Override
    public Opciones opciones() {
        return this.opciones("Elija una de las siguientes referencias.");
    }
}
