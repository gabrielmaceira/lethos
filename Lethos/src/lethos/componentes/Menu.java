/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.componentes;

import ifts16.pp.juego.componentes.Referencia;
import ifts16.pp.juego.componentes.Referencias;
import ifts16.pp.juego.entidades.Entidad;
import java.util.UUID;
import lethos.componentes.ReferenciaMenu;
import lethos.componentes.ReferenciasLethos;

/**
 *
 * @author Gabriel Maceira
 */
public class Menu extends Entidad {
    protected ReferenciasLethos<ReferenciaMenu> partesMenu;
    
    public Menu(String nombre) {
        this.nombre = nombre;
    }
    
    public ReferenciaMenu referencia(UUID referencia, String texto) {
        return new ReferenciaMenu(this.getId(), nombre);
    }
    
    public ReferenciaMenu referenciaMenus(String texto) {
        return new ReferenciaMenu(this.getId(), texto);
    }

    public ReferenciaMenu referenciaMenus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void agregarEntradaMenu(ReferenciaMenu parteMenu) {
    if (this.partesMenu == null) {
        this.partesMenu = new ReferenciasLethos<>();
    }
    this.partesMenu.agregar(parteMenu);
    }

    @Override
    public Referencia referencia(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Referencia referencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ReferenciasLethos<ReferenciaMenu> getPartesMenu() {
        return this.partesMenu;
    }
}
