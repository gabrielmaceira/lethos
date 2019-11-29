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

import ifts16.pp.juego.componentes.ReferenciaLugar;

/**
 * Clase abstracta con la raiz comun de todos los lugares del juego.
 * Esta clase hace poco mas que crear una subclase de Entidad y dar cuerpo a 
 * los metodos abstractos {@link LugarAbstracto#referencia()} y 
 * {@link LugarAbstracto#referencia(java.lang.String)}.
 * Su valor esta en su posicion en el arbol de Herencia, cualquier tipo
 * de lugar deberia ser una subclase de esta.
 * {@link LugarBase} es una subclase provista por este framework donde se incluyen
 * atributos con componentes y metodos para empezar a trabajar facilmente con
 * el mismo. Si se desean mas o menos cosas de las que estan provistas alli, 
 * siempre se puede hacer una subclase con lo que corresponda.
 * 
 * @author Fernando Neubaum
 * @version 1.0
 * @see Entidad
 * @see LugarBase
 */
public abstract class LugarAbstracto extends Entidad {

    /**
     * El Constructor de esta clase, solamente llama al de {@link ifts16.pp.juego.entidades.Entidad}.
     */
    public LugarAbstracto() {
        super();
    }
    
    /**
     * El Constructor de esta clase, llama al de {@link ifts16.pp.juego.entidades.Entidad}
     * y le pasa el nombre asignado.
     * @param nombre El nombre a asignar al Lugar.
     */
    public LugarAbstracto(String nombre) {
        super(nombre);
    }
    
    @Override
    public ReferenciaLugar referencia(String nombre) {
        return new ReferenciaLugar(this.getId(), nombre);
    }
    
    @Override
    public ReferenciaLugar referencia() {
        return new ReferenciaLugar(this.getId(), this.getNombre());
    }
}
