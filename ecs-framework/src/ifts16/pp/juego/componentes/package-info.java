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

/**
 * Componentes basicos e interfaces para crear sus propios componentes.
 * <p>
 * La clase base de la que descienden todas las otras en este paquete es Componente.
 * Un Componente es un objeto cuya funcion es guardar y permitir acceder a las
 * informaciones de una Entidad para que las pueda usar un Sistema.
 * <p>
 * Componente es una clase abstracta cuya principal funcion es permitir aunar
 * a todos los componentes en el arbol de Herencia. Si se necesita un componente
 * que principalmente sea un conjunto de atributos, getters y setters con poca
 * o nada de logica, esta deberia ser la clase de la que deben heredar.
 * <p>
 * {@link ifts16.pp.juego.componentes.Referencia} es una especializacion de 
 * Componente cuyo proposito es establecer un enlace entre la Entidad dentro
 * de la que se encuentra y la Entidad a la que refiere. La podemos entender
 * como un link que sirve para llamar a la Entidad referida. Esta clase deberia
 * ser usada en conjunto con {@link ifts16.pp.juego.sistemas.RepositorioPrincipal}
 * para hallar una Entidad previamente creada y guardada en el.
 * <p>
 * {@link ifts16.pp.juego.componentes.Referencias} es un componente que comprende
 * un conjunto de Referencias. Esto es necesario cuando el componente debe poder
 * conectar con mas de una Entidad a la vez.
 * 
 * @author Fernando Neubaum
 * @version 1.0
 * @see ifts16.pp.juego.componentes.Componente
 * @see ifts16.pp.juego.componentes.Referencia
 * @see ifts16.pp.juego.componentes.Referencias
 * @see ifts16.pp.juego.componentes.ReferenciaLugar
 * @see ifts16.pp.juego.componentes.ReferenciaPersonaje
 * @see ifts16.pp.juego.componentes.ReferenciaItem
 */
package ifts16.pp.juego.componentes;
