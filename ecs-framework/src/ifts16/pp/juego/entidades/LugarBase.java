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

import ifts16.pp.juego.componentes.ReferenciaItem;
import ifts16.pp.juego.componentes.ReferenciaLugar;
import ifts16.pp.juego.componentes.ReferenciaPersonaje;
import ifts16.pp.juego.componentes.Referencias;
import ifts16.pp.juego.utiles.ConOpciones;
import ifts16.pp.juego.utiles.Opciones;


/**
 * Esta clase sirve de base para lugares.
 * Posee una serie de componentes que no son mas que referencias a otros lugares,
 * personajes e items. Las referencias a lugares representan conexiones que tiene
 * este lugar con otros. Las de personajes representan a sus habitantes y los
 * items elementos que se encuentran en el lugar y no pertenecen a ningun personaje
 * en particular.
 * <p>
 * La gran mayoria de los metodos sirven para trabajar con esas referencias, pero
 * hay algunos, como todos los que comienzan con la palabra tiene, que informan
 * si el
 * 
 * @author Fernando Neubaum
 */
public class LugarBase extends LugarAbstracto implements ConOpciones {

    /**
     * Una breve descripcion del lugar para mostrarle al jugador cuando llegue.
     */
    protected String descripcion;

    /**
     * Componente con las referencias a los lugares limitrofes de este.
     */
    protected Referencias<ReferenciaLugar> vecinos;
    
    /**
     * Componente con las referencias a los lugares conectados por un portal
     */
    protected Referencias<ReferenciaLugar> portal;

    /**
     * Componente con las referencias a los personajes que pueden luchar.
     */
    protected Referencias<ReferenciaPersonaje> luchadores;

    /**
     * Componente con las referencias a los personajes que pueden comerciar.
     */
    protected Referencias<ReferenciaPersonaje> comerciantes;

    /**
     * Componente con las referencias a los personajes que pueden hablar.
     */
    protected Referencias<ReferenciaPersonaje> habladores;
    
    /**
     * Componente con las referencias a las misiones del lugar.
     */
    protected Referencias<ReferenciaItem> misiones;
    
    /**
     * Componente con las referencias a los items del lugar.
     */
    public Referencias<ReferenciaItem> items;

    
    public LugarBase(String nombre, String descripcion) {
        super(nombre);
        this.setDescripcion(descripcion);
    }
    
    /**
     * Getter de la descripcion del lugar.
     * @return La descripcion del lugar.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de la descripcion del lugar.
     * @param descripcion La descripcion.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Informa si el lugar tiene lugares limitrofes.
     * @return Verdadero si tiene, falso si no.
     */
    public boolean tieneVecinos() {
        if (this.getVecinos() == null || this.getVecinos().vacio()) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Informa si el lugar posee un portal.
     * @return Verdadero si tiene, falso si no.
     */
    public boolean tienePortal() {
        if (this.getPortal() == null || this.getPortal().vacio()) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Informa si hay luchadores en el lugar.
     * @return Verdadero si tiene, falso si no.
     */
    public boolean tieneLuchadores() {
        if (this.getLuchadores() == null || this.getLuchadores().vacio()) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Informa si hay comerciantes en el lugar.
     * @return Verdadero si tiene, falso si no.
     */
    public boolean tieneComerciantes() {
        if (this.getComerciantes() == null || this.getComerciantes().vacio()) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Informa si hay gente con quien se pueda entablar un dialogo.
     * @return Verdadero si tiene, falso si no.
     */
    public boolean tieneHabladores() {
        if (this.getHabladores() == null || this.getHabladores().vacio()) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Informa si el lugar posee misiones que el jugador pueda cumplir.
     * @return Verdadero si tiene, falso si no.
     */
    public boolean tieneMisiones() {
        if (this.getMisiones() == null || this.getMisiones().vacio()) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Informa si hay items sueltos en el lugar.
     * @return Verdadero si tiene, falso si no.
     */
    public boolean tieneItems() {
        if (this.getItems() == null || this.getItems().vacio()) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * Getter de los vecinos del lugar.
     * @return El Componente con las referencias a los lugares limitrofes.
     */
    public Referencias<ReferenciaLugar> getVecinos() {
        return vecinos;
    }

    /**
     * Agrega una referencia de lugar como vecino.
     * @param lugar Referencia de lugar.
     */
    public void agregarVecino(ReferenciaLugar lugar) {
        if (this.vecinos == null) {
            this.vecinos = new Referencias<>();
        }
        this.vecinos.agregar(lugar);
    }

    /**
     * Getter del portal de la zona.
     * @return El Componente con las referencias a los lugares conectados por el portal.
     */
    public Referencias<ReferenciaLugar> getPortal() {
        return portal;
    }

    /**
     * Agrega una referencia de lugar al componente de portal.
     * @param lugar La Referencia del lugar.
     */
    public void agregarAPortal(ReferenciaLugar lugar) {
        if (this.portal == null) {
            this.portal = new Referencias<>();
        }
        this.portal.agregar(lugar);
    }

    /**
     * Devuelve el componente con las referencias a los luchadores del lugar.
     * @return Las referencias de los personajes que pueden luchar.
     */
    public Referencias<ReferenciaPersonaje> getLuchadores() {
        return luchadores;
    }

    /**
     * Agrega un referencia de personaje al componente de luchadores.
     * @param personaje Una referencia de personaje.
     */
    public void agregarLuchador(ReferenciaPersonaje personaje) {
        if (this.luchadores == null) {
            this.luchadores = new Referencias<>();
        }
        this.luchadores.agregar(personaje);
    }

    /**
     * Devuelve a todos los comerciantes del lugar.
     * @return La lista de referencias de comerciantes.
     */
    public Referencias<ReferenciaPersonaje> getComerciantes() {
        return comerciantes;
    }

    /**
     * Agrega una referencia de personaje al componente de comerciantes.
     * @param personaje La referencia del personaje
     */
    public void agregarComerciante(ReferenciaPersonaje personaje) {
        if (this.comerciantes == null) {
            this.comerciantes = new Referencias<>();
        }
        this.comerciantes.agregar(personaje);
    }

    /**
     * Devuelve las referencias de los personajes con los que se puede hablar.
     * @return La lista de referencias de personajes.
     */
    public Referencias<ReferenciaPersonaje> getHabladores() {
        return habladores;
    }

    /**
     * Agrega una referencia de personaje al componente de habladores.
     * @param personaje La referencia del personaje.
     */
    public void agregarHablador(ReferenciaPersonaje personaje) {
        if (this.habladores == null) {
            this.habladores = new Referencias<>();
        }
        this.habladores.agregar(personaje);
    }

    /**
     * Devuelve las misiones disponibles.
     * @return Las referencias a las misiones.
     */
    public Referencias<ReferenciaItem> getMisiones() {
        return misiones;
    }

    /**
     * Agrega una mision disponible en el lugar.
     * @param mision La referencia del item.
     */
    public void agregarMision(ReferenciaItem mision) {
        if (this.misiones == null) {
            this.misiones = new Referencias<>();
        }
        this.misiones.agregar(mision);
    }

    /**
     * Getter del componente de items.
     * @return Los items del lugar.
     */
    public Referencias<ReferenciaItem> getItems() {
        return items;
    }

    /**
     * Agrega un item a la lista de items del lugar.
     * @param item La referencia del item.
     */
    public void agregarItem(ReferenciaItem item) {
        if (this.items == null) {
            this.items = new Referencias<>();
        }
        this.items.agregar(item);
    }

        
    /**
     * Crea automaticamente una lista de opciones con lo que se puede hacer en el lugar.
     * @param mensaje El mensaje a mostrar antes de dar a elegir las opciones.
     * @return Las opciones creadas.
     */
    @Override
    public Opciones opciones(String mensaje) {
        Opciones ops = new Opciones(mensaje);
        if (this.tieneVecinos()) {
            ops.agregar("vecinos", "Ir a un lugar que limite con este.");
        }
        if (this.tienePortal()) {
            ops.agregar("portal", "Ir a un lugar conectado por el portal de la zona.");
        }
        if (this.tieneLuchadores()) {
            ops.agregar("luchadores", "Combatir con los enemigos de lugar.");
        }
        if (this.tieneComerciantes()) {
            ops.agregar("comerciantes", "Comerciar con los mercaderes del lugar.");
        }
        if (this.tieneHabladores()) {
            ops.agregar("habladores", "Hablar con los habitantes de la zona.");
        }
        if (this.tieneMisiones()) {
            ops.agregar("misiones", "Buscar misiones de la gente del lugar.");
        }
        if (this.tieneItems()) {
            ops.agregar("items", "Ver los items de la zona.");
        }
        return ops;
    }
    
    /**
     * Crea automaticamente una lista de opciones con lo que se puede hacer en el lugar. 
     * @return Las opciones creadas.
     */
    @Override
    public Opciones opciones() {
        return this.opciones("Elija lo que desea hacer en este lugar.");
    }   
}
