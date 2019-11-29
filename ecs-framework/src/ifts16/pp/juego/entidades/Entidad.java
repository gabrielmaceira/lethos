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
package ifts16.pp.juego.entidades;

import ifts16.pp.juego.componentes.Referencia;
import java.util.UUID;


/**
 * La base de todas las Entidades que tengamos en el juego.
 * La misma provee tres elementos basicos, uno es requerido por cualquier Entidad
 * y los otros dos no, pero son muy utiles.
 * El id es un {@link java.util.UUID} que permite distinguir a dos entidades 
 * diferentes, es el requisito minimo que tiene una Entidad.
 * El nombre es un texto que permite a un humano distinguir a dos entidades mas,
 * facilmente. Aun asi, dos entidades pueden tener el mismo nombre, pero si su
 * id es distinto se trata de entidades diferentes.
 * Es una clase abstracta, por lo que no se pueden crear instancias de la misma.
 * Esta pensada para que creen sus propias Entidades.
 * 
 * @author Fernando Neubaum
 * @version 1.0
 * @see LugarAbstracto
 * @see ItemAbstracto
 * @see PersonajeAbstracto
 */
public abstract class Entidad {

    /**
     * El id de la entidad, generado de forma automatica.
     */
    protected UUID id;

    /**
     * El nombre de la entidad, asignado por el programador o nulo.
     */
    protected String nombre;

    /**
     * El estado activo o inactivo, para marcar si la entidad se quiere excluir 
     * de forma temporal o permanente de las opciones disponibles.
     */
    protected boolean activo;

    /**
     * Este es el constructor que no requiere parametros. Por defecto le asigna
     * un identificador unico y universal de forma completamente aleatoria, da un valor nulo al 
     * nombre e indica que la Entidad esta activa. Si se quiere desactivar antes
     * de usarlo no requiere mas que usar {@link Entidad#desactivar() }
     */
    public Entidad() {
        this.id = UUID.randomUUID();
        this.nombre =  null;
        this.activo = true;
    }
    
    /**
     * El segundo constructor que permite el Polimorfismo Ad Hoc. Por defecto le asigna
     * un {@link UUID} de forma completamente aleatoria, da un el valor del Parametro Real al 
     * nombre e indica que la Entidad esta activa. Si se quiere desactivar antes
     * de usarlo no requiere mas que usar {@link Entidad#desactivar() }
     * 
     * @param nombre El nombre a asignar a la Entidad
     */
    public Entidad(String nombre) {
        this.id = UUID.randomUUID();
        this.nombre =  nombre;
        this.activo = true;
    }
    
    /**
     * Devuelve el id generado automaticamente. Este id permite distinguir a una
     * entidad particular de cualquier otra.
     * Es indispensable para poder  trabajar con el {@link ifts16.pp.juego.sistemas.RepositorioPrincipal}
     * y crear una {@link ifts16.pp.juego.componentes.Referencia}.
     * 
     * @return El UUID de la Entidad 
     */
    public UUID getId() {
        return this.id;
    }
    
    /**
     * Devuelve el nombre asignado a la Entidad, y un valor null si no se le 
     * asigno ninguno.
     * 
     * @return El nombre de la Entidad o null si no lo posee.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Establece el nombre de la Entidad, le puede asignar uno nuevo o  modificar
     * el que tiene. No tiene ningun tipo de validacion. De requerirse eso se
     * puede anular este metodo en una subclase.
     * 
     * @param nombre que se le asignara a la Entidad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve el estado de la Entidad en lo que respecta a su Actividad.
     * Si esta activa, devuelve Verdadero, y si no falso.
     * 
     * @return El estado en el que se encuentra la Entidad
     */
    public boolean getActividad() {
        return this.activo;
    }
    
    /**
     * Si la entidad se encuentra activa, la desactiva. De otra forma, no hace
     * nada.
     * 
     */
    public void desactivar() {
        if (this.activo == true) {
            this.activo = false;
        } 
    }
    
    /**
     * Si la Entidad se encuentra desactivada, la activa. De otra forma, no
     * hace nada.
     * 
     */
    public void activar() {
        if (this.activo == false) {
            this.activo = true;
        }
    }
    
    /**
     * Un metodo que crea y devuelve la referencia de esta Entidad.
     * Esta pensada para ser usada junto con componentes que pertenezcan o 
     * hereden de la clase {@link ifts16.pp.juego.componentes.Referencias}.
     * Esos componentes guardaran un elemento devuelto por este metodo.
     * Si no esta implementado antes en el arbol de Herencia, una clase debe
     * implementarlo.
     * 
     * @param texto el texto que visualizara el usuario de esta referencia
     * @return La {@link ifts16.pp.juego.componentes.Referencia} de esta Entidad
     * @see ifts16.pp.juego.componentes.Referencia
     * @see ifts16.pp.juego.componentes.Referencias
     */
    public abstract Referencia referencia(String texto);
    
    /**
     * Un metodo que crea y devuelve la referencia de esta Entidad.
     * Esta pensada para ser usada junto con componentes que pertenezcan o 
     * hereden de la clase {@link ifts16.pp.juego.componentes.Referencias}.
     * Esos componentes guardaran un elemento devuelto por este metodo.
     * Si no esta implementado antes en el arbol de Herencia, una clase debe
     * implementarlo.
     * No requiere parametros porque deberia generarle un nombre o utilizar el
     * de la Entidad para agregarlo a la Referencia.
     * @return la {@link ifts16.pp.juego.componentes.Referencia} de esta Entidad
     * @see ifts16.pp.juego.componentes.Referencia
     * @see ifts16.pp.juego.componentes.Referencias
     */
    public abstract Referencia referencia();
    
    /**
     * Este metodo devuelve un String que representa a la Entidad. Es
     * util cuando necesitamos mostrar un texto que la represente.
     * 
     * @return El texto que representa a la entidad
     */
    @Override
    public String toString() {
        if (this.getNombre() == null) {
            return "Entidad de clase " + this.getClass().getSimpleName() + 
            " con id " + this.getId().toString();
        } else {
            return this.getNombre();
        }
        
    }
}
