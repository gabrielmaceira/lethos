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
package ifts16.pp.juego.utiles;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author fernando
 */
public class Opciones {
    protected ArrayList<Opcion> lista;
    protected String mensaje;
    
    public Opciones() {
        this.lista = new ArrayList<>();
        this.mensaje = "Seleccionar una de las siguientes opciones";
    }
    
    public Opciones(String mensaje) {
        this.lista = new ArrayList<>();
        this.mensaje = mensaje;
    }
    
    public Opcion opcionElegida(int posicion) {
        return this.lista.get(posicion - 1);
    }
    
    public String comandoElegido(int posicion) {
        Opcion op = this.lista.get(posicion - 1);
        return op.getComando();
    }
    
    public UUID idElegida(int posicion) {
        Opcion op = this.lista.get(posicion - 1);
        return op.getEntidadId();
    }
    
    public boolean eleccionEsComando(int posicion) {
        Opcion op = this.lista.get(posicion - 1);
        return op.esComando();
    }
    
    public boolean eleccionEsEntidad(int posicion) {
        Opcion op = this.lista.get(posicion - 1);
        return op.esEntidad();
    }
    
    public boolean agregar(Opcion op) {
        return this.lista.add(op);
    }
    
    public boolean agregar(UUID entidad, String texto) {
        Opcion op = new Opcion(entidad, texto);
        return this.lista.add(op);
    }
    
    public boolean agregar(String comando, String texto) {
        Opcion op = new Opcion(comando, texto);
        return this.lista.add(op);
    }
    
    public int cantidad() {
        return this.lista.size();
    }
    
    public ArrayList<String> darFormato() {
        ArrayList<String> ops = new ArrayList<String>();
        for (Opcion op: this.lista) {
            ops.add((ops.size() + 1) + ".- " + op.getTexto());
        }
        return ops;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
