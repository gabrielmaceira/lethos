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

import java.util.UUID;

/**
 *
 * @author fernando
 */


public class Opcion {
    protected UUID entidadId;
    protected String comando;
    protected String texto;
    
    public Opcion(UUID entidadId, String texto) {
        this.entidadId = entidadId;
        this.texto = texto;
    }
    
    public Opcion(String comando, String texto) {
        this.comando =  comando.replaceAll("\\s+","").toLowerCase();
        this.texto = texto;
    }
    
    public Opcion(UUID entidadId) {
        this.entidadId = entidadId;
        this.texto = entidadId.toString();
    }
    
    public Opcion(String comando) {
        this.comando =  comando.replaceAll("\\s+","").toLowerCase();
        this.texto = this.comando;
    }
    
    public boolean esEntidad() {
        if (this.entidadId == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean esComando() {
        if (this.comando == null) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * @return the entidadId
     */
    public UUID getEntidadId() {
        return entidadId;
    }

    /**
     * @return the comando
     */
    public String getComando() {
        return comando;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }
}
