/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.entidades;

import ifts16.pp.juego.entidades.ItemAbstracto;
import java.util.UUID;
import lethos.sistemas.IOLethos;

/**
 *
 * @author Gabriel Maceira
 */

public class Item extends ItemAbstracto {
    protected UUID id;
    protected String nombre;
    protected boolean activo;
    protected String descripcion;
    protected int cantidad;
    
    public Item(String nombre, String descripcion, int cantidad) {
    this.id = UUID.randomUUID();
    this.nombre =  nombre;
    this.activo = true;
    this.descripcion = descripcion;
    this.cantidad = cantidad;
    }

    /**
     * @return the id
     */
    @Override
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String mostarItem() {
        return this.getNombre() + " (x" + this.getCantidad() + ") - " + this.getDescripcion();
    }

}
