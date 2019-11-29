/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.sistemas;

import Utiles.OpcionesLethos;
import ifts16.pp.juego.componentes.ReferenciaItem;
import ifts16.pp.juego.componentes.Referencias;
import ifts16.pp.juego.entidades.LugarBase;
import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import lethos.entidades.Item;

public class BaseLethos extends LugarBase {
    private boolean aniquilado;
    private String descripcionSecundaria;
    protected Referencias<ReferenciaItem> equipoLugar;
    
	public BaseLethos(String nombre, String descripcion, String descripionSecundaria, boolean aniquilado) {
		super(nombre, descripcion);
                this.descripcionSecundaria = descripionSecundaria;
                this.aniquilado = aniquilado;
	}

    public boolean isAniquilado() {
        return aniquilado;
    }

    public void setAniquilado(boolean aniquilado) {
        this.aniquilado = aniquilado;
    }

    public String getDescripcionSecundaria() {
        return descripcionSecundaria;
    }

    public void setDescripcionSecundaria(String descripcionSecundaria) {
        this.descripcionSecundaria = descripcionSecundaria;
    }

    @Override
    public OpcionesLethos opciones(String mensaje) {
        OpcionesLethos ops = new OpcionesLethos(mensaje);
        if (this.tieneVecinos() && this.isAniquilado()) {
            ops.agregar("vecinos", "Ir a un lugar que limite con este.");
        }
        if (this.tienePortal() && this.isAniquilado()) {
            ops.agregar("portal", "Ir a un lugar conectado por el portal de la zona.");
        }
        if (this.tieneLuchadores() && this.isAniquilado()) {
            ops.agregar("luchadores", "Volver a combatir con Jefe");
        }
        if (this.tieneLuchadores() && !this.isAniquilado()) {
            ops.agregar("luchadores", "Combatir con Jefe");
        }
        if (this.tieneComerciantes() && this.isAniquilado()) {
            ops.agregar("comerciantes", "Comerciar con los mercaderes del lugar.");
        }
        if (this.tieneHabladores() && this.isAniquilado()) {
            ops.agregar("habladores", "Hablar con los habitantes de la zona.");
        }
        if (this.tieneMisiones() && this.isAniquilado()) {
            ops.agregar("misiones", "Buscar misiones de la gente del lugar.");
        }
        if (this.tieneItems() && this.isAniquilado()) {
            ops.agregar("items", "Ver los items de la zona.");
        }
        if (this.tieneEquipo() && this.isAniquilado()) {
            ops.agregar("equipo", "Ver el equipamiento de la zona.");
        }
        Item item = (Item) RepositorioPrincipal.traer("Vuelo");
        if (item.getCantidad() > 0 && this.getNombre() != "Ciudad de Ipgra") {
            ops.agregar("vuelo", "Volar a Ipgra");
        }
        ops.agregar("menu", "Acceder al menu");
        return ops;
    }
 
    public Referencias<ReferenciaItem> getEquipoLugar() {
        return equipoLugar;
    }

    public void agregarEquipoLugar(ReferenciaItem item) {
        if (this.equipoLugar == null) {
            this.equipoLugar = new Referencias<>();
        }
        this.equipoLugar.agregar(item);
    }    
    
    public boolean tieneEquipo() {
        if (this.getEquipoLugar() == null || this.getEquipoLugar().vacio()) {
            return false;
        } else {
            return true;
        }
    }
    
}
