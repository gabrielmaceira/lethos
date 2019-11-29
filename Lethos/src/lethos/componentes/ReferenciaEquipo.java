/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.componentes;
import java.util.UUID;

/**
 *
 * @author Gabriel Maceira
 */
public class ReferenciaEquipo extends ReferenciaLethos {
    
    public ReferenciaEquipo(UUID referencia, String texto) {
        super(referencia, TipoLethos.Equipo, texto);
    }
    
}