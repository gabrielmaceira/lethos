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

/**
 * Utilidades para dar Opciones al usuario en el juego.
 * Dentro del framework se plantea que la mayoria de las interacciones
 * que tenga un usuario deberian consistir en elegir una de entre un conjunto
 * de opciones.
 * <p>
 * La clase mas basica es {@link ifts16.pp.juego.utiles.Opcion}, la cual representa una sola opcion
 * del conjunto. {@link ifts16.pp.juego.utiles.Opciones} es un grupo con los metodos
 * necesarios para ser mostradas, elegidas, y devuelta la correspondientes.
 * El {@link ifts16.pp.juego.utiles.MapaDeOpciones} consiste en un conjunto de
 * {@link ifts16.pp.juego.utiles.Opciones}. Esta clase esta pensada para 
 * armar menues que permitan representar cosas como dialogos complejos.
 * <p>
 * A su vez, hay dos interfaces pensadas para que las implementen las Entidades
 * y los Componentes con los que va a interactuar el usuario. {@link ifts16.pp.juego.utiles.ConOpciones}
 * tiene los metodos basicos para que un elemento genere sus opciones automaticamente
 * y las devuelva a quien lo pida. {@link ifts16.pp.juego.utiles.ConActividad} 
 * ademas agrega la posibilidad de devolver solamente las opciones activas o inactivas
 * de entre todas las posibles.
 * <p>
 * @author Fernando Neubaum
 * @version 1.0
 * @see ifts16.pp.juego.utiles.Opciones
 * @see ifts16.pp.juego.utiles.Opcion
 * @see ifts16.pp.juego.utiles.MapaDeOpciones
 */
package ifts16.pp.juego.utiles;
