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
 * Clases basicas para crear sistemas y algunos sistemas ya creados.
 * <p>
 * Los sistemas son los componentes que contienen la logica del juego. Para 
 * resolver cualquier interaccion entre dos o mas entidades se utilizara un 
 * un sistema que se encargara de llevar a cabo las acciones necesarias para que
 * funcione el programa correctamente.
 * <p>
 * La clase {@link ifts16.pp.juego.sistemas.Sistema} es la base para todos los 
 * sistemas, su funcion es permitir
 * definir un ancestro comun para todos ellos en el arbol de herencia. Si bien
 * no parece mucho, si en el futuro se necesitase un atributo o metodo que 
 * compartan todos los sistemas, ese seria el lugar apropiado para agregarlo.
 * <p>
 * Un sistema casi con seguridad no podra resolver todo de forma aislada, sino 
 * que requerira de otros que le permitan resolver otras partes y 
 * <p>
 * {@link ifts16.pp.juego.sistemas.IOBase} es donde estan definidas las entradas
 * y salidas principales del juego. Es una interfaz grafica muy sencilla que
 * consiste en una ventana con una salida textual y una entrada tambien textual.
 * Esta clase posee a su vez una serie de metodos estaticos para interactuar 
 * facilmente con esos dos elementos.
 * <p>
 * {@link ifts16.pp.juego.sistemas.RepositorioPrincipal} es un repositorio creado
 * para poder alojar cualquier Entidad del juego. De asi quererlo este puede 
 * ser el unico repositorio que necesiten en su juego; de otra manera se puede 
 * optar por crear otros repositorios especificos con la clase 
 * {@link ifts16.pp.juego.sistemas.Repositorio}.
 * <p>
 * {@link ifts16.pp.juego.sistemas.FabricaPrincipal} es una fabrica general donde
 * se podran implementar metodos para crear los lugares, personajes e items del juego.
 * Tambien es en este lugar donde se deberian establecer todas las relaciones
 * iniciales entre las entidades, asi como el proceso de creacion del personaje
 * jugador.
 * <p>
 * {@link ifts16.pp.juego.sistemas.NavegacionBase} es un sistema que permite 
 * desplazarse entre lugares conectados. La clase {@link ifts16.pp.juego.entidades.LugarBase}
 * esta pensada para ser usada con este Sistema. Los componentes relevantes para
 * este sistema son vecinos y portal.
 * 
 * @author Fernando Neubaum
 * @version 1.0
 * @see ifts16.pp.juego.sistemas.Sistema
 * @see ifts16.pp.juego.sistemas.IOBase
 * @see ifts16.pp.juego.sistemas.RepositorioPrincipal
 * @see ifts16.pp.juego.sistemas.FabricaPrincipal
 * @see ifts16.pp.juego.sistemas.NavegacionBase
 */
package ifts16.pp.juego.sistemas;
