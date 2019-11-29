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
package ifts16.pp.juego.entidades;

import ifts16.pp.juego.componentes.ReferenciaItem;

/**
 * Clase abstracta con la raiz comun de todos los items del juego.
 * Esta clase hace poco mas que crear una subclase de Entidad y dar cuerpo a 
 * los metodos abstractos {@link ItemAbstracto#referencia()} y 
 * {@link ItemAbstracto#referencia(java.lang.String)}.
 * Su valor esta en su posicion en el arbol de Herencia, cualquier tipo
 * de item deberia ser una subclase de esta.
 * 
 * @author Fernando Neubaum
 * @version 1.0
 * @see ifts16.pp.juego.entidades.Entidad
 */

public abstract class ItemAbstracto extends Entidad {

    /**
     * El Constructor de esta clase, solamente llama al de {@link ifts16.pp.juego.entidades.Entidad}.
     */
    public ItemAbstracto() {
        super();
    }
    
    /**
     * El Constructor de esta clase, llama al de {@link ifts16.pp.juego.entidades.Entidad}
     * y le pasa el nombre asignado.
     * @param nombre El nombre del item.
     */
    public ItemAbstracto(String nombre) {
        super(nombre);
    }
    
    
    @Override
    public ReferenciaItem referencia(String nombre) {
        return new ReferenciaItem(this.getId(), nombre);
    }
    
    @Override
    public ReferenciaItem referencia() {
        return new ReferenciaItem(this.getId(), this.getNombre());
    }
}
