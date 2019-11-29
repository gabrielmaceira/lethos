/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.sistemas;

import java.util.Comparator;
import lethos.entidades.Personaje;

/**
 *
 * @author Gabriel Maceira
 */
public class OrdenarLuchadores {

    public static Comparator<Personaje> ordenVelocidad = new Comparator<Personaje>() {

        @Override
	public int compare(Personaje p1, Personaje p2) {
	   int velocidad1 = p1.getVelocidad();
	   int velocidad2 = p2.getVelocidad();
           return velocidad2-velocidad1;
        }
    };      

}

