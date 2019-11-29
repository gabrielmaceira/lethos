/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.componentes;

import java.util.ArrayList;
import lethos.entidades.Personaje;

/**
 *
 * @author Gabriel Maceira
 */
public class ResultadoAtaques {
    
    /*    public static String resultadoAtaque(ArrayList<Personaje> enemigos, int atacante, int atacado, int danio) {
    String nombreAtacante = enemigos.get(atacante).getNombre();
    String nombreAtacado = enemigos.get(atacado).getNombre();
    String salida = "";
    if (danio == 0) {
    salida = salida + nombreAtacado + " esquiva el ataque de " + nombreAtacante + ".\n";
    }
    else {
    if (enemigos.get(atacado).getCurrentHP() == 0)
    {
    salida = salida + nombreAtacante + " ataca a " + nombreAtacado + ", y le deja fuera de combate.\n";
    }
    else {
    salida = salida + nombreAtacante + " ataca a " + nombreAtacado + ", y le causa " + danio + " puntos de daño.\n";
    }
    }
    return salida;
    }*/
    public static String resultadoAtaque(ArrayList<Personaje> enemigos, int atacante, 
            int atacado, String resultadoAtaque) {
        String nombreAtacante = enemigos.get(atacante).getNombre();
        String nombreAtacado = enemigos.get(atacado).getNombre();
        String salida = "";
        if (resultadoAtaque.equalsIgnoreCase("")) {
            salida = salida + nombreAtacado + " esquivó el ataque de " + nombreAtacante + ".\n";
        }
        else {
            salida = salida + nombreAtacante + " atacó a " + nombreAtacado + " " + resultadoAtaque;            
        }
        return salida;
    }    
}
