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
 * Conjunto de clases basicas para crear sus propias Entidades dentro del juego. 
 * Es uno de los tres elementos principales en un framework Entidad-Componente-Sistema.
 * Una {@link ifts16.pp.juego.entidades.Entidad} es una de las clases principales
 * y representativas dentro del juego. Su principal funcion es contener una serie
 * de {@link ifts16.pp.juego.componentes.Componente} en su interior que le permitan 
 * interactuar con los {@link ifts16.pp.juego.sistemas.Sistema}.
 * <p>
 * El framework identifica tres tipos de Entidades que se pueden tener dentro del
 * mismo: lugares, personajes e items. Por cada uno de ellos se incluye una clase
 * Abstracta que sirva de base para sus juegos.
 * <p>
 * {@link ifts16.pp.juego.entidades.LugarAbstracto} representa un lugar cualquiera. La funcion principal
 * de un lugar es conectarse con otros lugares e incluir a todos los personajes 
 * e items que se encuentran en su interior. Por ello, la forma mas practica de 
 * trabajar con ellos es haciendo que sus atributos sean componentes con referencias
 * a otras entidades, y nada mas.
 * <p>
 * Aplicando esa vision, y como ayuda, se incluye en el paquete la clase {@link ifts16.pp.juego.entidades.LugarBase}
 * que servira para trabajar directamente o de Guia para quien quiera crear sus propios
 * tipos de lugares mas especificos y relacionados con su juego.
 * <p>
 * Es responsabilidad de quien cree el juego con el framework hacer subclases 
 * de {@link ifts16.pp.juego.entidades.PersonajeAbstracto} e 
 * {@link ifts16.pp.juego.entidades.ItemAbstracto} para adaptarlo a sus necesidades
 * y trabajar con los mismos.
 * 
 * @author Fernando Neubaum
 * @version 1.0
 * @see ifts16.pp.juego.entidades.Entidad
 * @see ifts16.pp.juego.entidades.LugarAbstracto
 * @see ifts16.pp.juego.entidades.PersonajeAbstracto
 * @see ifts16.pp.juego.entidades.ItemAbstracto
 */
package ifts16.pp.juego.entidades;
