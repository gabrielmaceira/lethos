/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.componentes;

import ifts16.pp.juego.componentes.Referencia;
import java.util.UUID;

/**
 *
 * @author Gabriel Maceira
 */
public class ReferenciaMenu extends ReferenciaLethos { 
    
    public ReferenciaMenu(UUID referencia, String texto) {
        super(referencia, TipoLethos.MenuItem, texto);
    }
}