/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.componentes;

import ifts16.pp.juego.componentes.Componente;
import java.util.UUID;

/**
 *
 * @author Gabriel Maceira
 */
public abstract class ReferenciaLethos extends Componente {
    protected UUID referencia;
    protected TipoLethos tipoReferencia;
    protected String texto;
    protected boolean activa;
   
    public ReferenciaLethos(UUID referencia, TipoLethos tipoReferencia, String texto) {
        this.referencia = referencia;
        this.tipoReferencia = tipoReferencia;
        this.texto = texto;
        this.activa = true;
    }
    
    public UUID refiereA() {
        return this.referencia;
    }
    
    public TipoLethos tipoReferencia() {
        return this.tipoReferencia;
    }
    
    public String verTexto() {
        return this.texto;
    }
    
    public boolean estaActiva() {
        return this.activa;
    }
    
    public void activar() {
        if (this.activa == false) {
            this.activa = true;   
        }
    }
    
    public void desactivar() {
        if (this.activa == true) {
            this.activa = false; 
        }
    }
    
    @Override
    public String toString() {
        if (this.texto == null || this.texto.isEmpty()) {
            return "Referencia de Entidad con id "  + this.refiereA().toString() + 
            " y tipo " + this.tipoReferencia.toString();
        } else {
            return this.texto;
        }
    }
}
