/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.componentes;

import Utiles.OpcionesLethos;
import ifts16.pp.juego.componentes.Componente;
import ifts16.pp.juego.utiles.ConActividad;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Gabriel Maceira
 */
public class ReferenciasLethos<R extends ReferenciaLethos> extends Componente implements ConActividad {
    protected ArrayList<R> lista;
    
    public ReferenciasLethos() {
        this.lista = new ArrayList<>();
    }
    
    public R agregar(R ref) {
        if (this.lista.add(ref)) {
            return ref;
        }
        return null;
    }
    
    public R traer(UUID id) {
        for (R ref: lista) {
            if (ref.refiereA() == id) {
                return ref;
            }
        }
        return null;
    }
    
    public R traer(int posicion) {
        return lista.get(posicion);
    }
    
    public boolean existe(UUID id) {
        for (R ref: lista) {
            if (ref.refiereA() == id) {
                return true;
            }
        }
        return false;
    }
    
    public R reemplazar(R referencia) {
        for (R ref: lista) {
            if (ref.refiereA() == referencia.refiereA()) {
                this.lista.remove(ref);
                this.lista.add(referencia);
                return referencia;
            }
        }
        return null;
    }
    
    public boolean eliminar(UUID id) {
        for (R ref: lista) {
            if (ref.refiereA() == id) {
                lista.remove(ref);
            }
            return true;
        }
        return false;
    }
    
    public boolean eliminar(R referencia) {
        return lista.remove(referencia);
    }
    
    public R eliminar(int posicion) {
        return lista.remove(posicion);
    }
    
    public boolean vacio() {
        return this.lista.isEmpty();
    }
    
    public ArrayList<R> mostrar() {
        return this.lista;
    }
    
    public ArrayList<R> mostrarActivas() {
        ArrayList<R> activas = new ArrayList<R>();
        for (R r : this.lista) {
            if (r.estaActiva()) {
                activas.add(r);
            }
        }
        return activas;
    }
    
    public ArrayList<R> mostrarInactivas() {
        ArrayList<R> inactivas = new ArrayList<R>();
        for (R r : this.lista) {
            if (!r.estaActiva()) {
                inactivas.add(r);
            }
        }
        return inactivas;
    }
    
    @Override
    public OpcionesLethos opciones(String mensaje) {
        OpcionesLethos ops = new OpcionesLethos(mensaje);
        for (R ref: this.mostrar()) {
            ops.agregar(ref.refiereA(), ref.verTexto());
        }
        return ops;
    }
    
    @Override
    public OpcionesLethos opcionesActivas(String mensaje) {
        OpcionesLethos ops = new OpcionesLethos(mensaje);
        for (R ref: this.mostrarActivas()) {
            ops.agregar(ref.refiereA(), ref.verTexto());
        }
        return ops;
    }
    
    @Override
    public OpcionesLethos opcionesInactivas(String mensaje) {
        OpcionesLethos ops = new OpcionesLethos(mensaje);
        for (R ref: this.mostrarInactivas()) {
            ops.agregar(ref.refiereA(), ref.verTexto());
        }
        return ops;
    }
    
    @Override
    public OpcionesLethos opciones() {
        return this.opciones("Elija una de las siguientes referencias.");
    }
}

