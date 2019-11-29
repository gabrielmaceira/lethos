/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.componentes;

import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import java.util.ArrayList;
import lethos.entidades.Personaje;
import java.util.Random;
import static lethos.sistemas.CombateEnemigos.*;

/**
 *
 * @author Gabriel Maceira
 */
public class PartesCombate {
    
    public static void ataqueEnemigo(ArrayList<Personaje> enemigos, int i, boolean defendiendo){
        Random random = new Random();
        int azar = random.nextInt(101);
        switch(RepositorioPrincipal.traer(enemigos.get(i).getId()).getNombre()) {
        case "Erognar, el Anciano" :       
            ataqueErognar(enemigos, i, azar, random, defendiendo);
            break;
        case "Aparición":
            ataqueAparicion(enemigos, i, azar, random, defendiendo);
            break;
        case "Troll de la Montaña":
            ataqueTroll(enemigos, i, azar, random, defendiendo);
          break;
        case "Gigante de Magma":
            ataqueMagma(enemigos, i, azar, random, defendiendo);
           break;
        case "Serena, Sacerdotisa de Diamante":
            ataqueSerena(enemigos, i, azar, random, defendiendo);
          break;
        case "Serpiente Emplumada":
            ataqueSerpiente(enemigos, i, azar, random, defendiendo);
            break;
        case "Kobo, Príncipe Goblin":
            ataqueKobo(enemigos, i, azar, random, defendiendo);
            break;
        }
        
    }
    
}
