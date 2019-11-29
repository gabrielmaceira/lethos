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
package ifts16.pp.juego.componentes;

import ifts16.pp.juego.entidades.Tipo;
import java.util.UUID;

/**
 *
 * @author fernando
 */
public abstract class Referencia extends Componente {
    protected UUID referencia;
    protected Tipo tipoReferencia;
    protected String texto;
    protected boolean activa;
    
    
    public Referencia(UUID referencia, Tipo tipoReferencia, String texto) {
        this.referencia = referencia;
        this.tipoReferencia = tipoReferencia;
        this.texto = texto;
        this.activa = true;
    }
    
    public UUID refiereA() {
        return this.referencia;
    }
    
    public Tipo tipoReferencia() {
        return this.tipoReferencia;
    }
    
    public String verTexto() {
        return this.texto;
    }
    
    public boolean estaActiva() {
        return this.activa;
    }
    
    public void activar() {
        if (this.activa == false) {
            this.activa = true;   
        }
    }
    
    public void desactivar() {
        if (this.activa == true) {
            this.activa = false; 
        }
    }
    
    @Override
    public String toString() {
        if (this.texto == null || this.texto.isEmpty()) {
            return "Referencia de Entidad con id "  + this.refiereA().toString() + 
            " y tipo " + this.tipoReferencia.toString();
        } else {
            return this.texto;
        }
    }
}