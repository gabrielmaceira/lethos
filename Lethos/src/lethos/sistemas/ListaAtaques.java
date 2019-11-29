/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.sistemas;

import java.util.ArrayList;
import java.util.Random;
import lethos.entidades.Personaje;

/**
 *
 * @author Gabriel Maceira
 */
public class ListaAtaques {
    
    /*    public static int ataqueFisico(Personaje ataca, Personaje atacado) {
    int danio = 0;
    Random random = new Random();
    double accuracyAtacante = ataca.getAccuracy();
    double velocidadAtacado = atacado.getVelocidad();
    double resultado;
    
    if (accuracyAtacante > velocidadAtacado) {
    resultado = ((accuracyAtacante - velocidadAtacado)/accuracyAtacante)*100;
    } else {
    resultado = 100 - (((velocidadAtacado - accuracyAtacante)/velocidadAtacado)*100);
    }
    
    if (random.nextInt(101) < resultado)
    {
    danio = (ataca.getAtaque() * ataca.getCantidadAtaques()) - (atacado.getDefensa() / 2) + ((random.nextInt(10)*ataca.getAtaque())/80);
    if (danio < 0)
    {
    danio = 0;
    }
    int temp = atacado.getCurrentHP() - danio;
    if (temp >= 0) {
    atacado.setCurrentHP(temp);
    } else {
    atacado.setCurrentHP(0);
    }
    return danio;
    }
    else {
    return danio;
    }
    }*/    
    public static String ataqueFisico(Personaje ataca, Personaje atacado, int porcentajeFuerza) {
        int danio;
        int danioTotal = 0;
        int cantidadDeGolpes = 0;
        Random random = new Random();
        double accuracyAtacante = ataca.getAccuracy();
        double velocidadAtacado = atacado.getVelocidad();
        double resultado;
        
        if (accuracyAtacante > velocidadAtacado) {
            resultado = ((accuracyAtacante - velocidadAtacado)/accuracyAtacante)*100;
        } else {
            resultado = 100 - (((velocidadAtacado - accuracyAtacante)/velocidadAtacado)*100);
        }

        for (int i = 0; i < ataca.getCantidadAtaques(); i++) {
            if (random.nextInt(101) < resultado + 15)
            {
                danio = (int) (((ataca.getAtaque() * 3) - (atacado.getDefensa() * 2) + ((random.nextInt(10)*ataca.getAtaque())/80))*porcentajeFuerza/100);
                
                if (danio < 0) 
                {
                    danio = 0;
                }
                danioTotal = danioTotal + danio;
                cantidadDeGolpes = cantidadDeGolpes + 1;
            }
        }
        int temp = atacado.getCurrentHP() - danioTotal;
        if (temp >= 0) 
        {
            atacado.setCurrentHP(temp);
            switch (cantidadDeGolpes) {
                case 0:
                    return "";
                case 1:
                    return cantidadDeGolpes + " vez por " + danioTotal + " punto(s) de daño.";
                default:
                    return cantidadDeGolpes + " veces por " + danioTotal + " punto(s) de daño.";
            }
        } else {
            atacado.setCurrentHP(0);
            if (cantidadDeGolpes == 1)
                    {
                        return cantidadDeGolpes + " vez " + " y le dejó fuera de combate.";
                    }
            else {
                return cantidadDeGolpes + " veces " + " y le dejó fuera de combate.";
            }
        }
    }
    
    public static String fuego1(Personaje ataca, Personaje atacado) {
        String salida = "";
        Random random = new Random();
        int danio = ataca.getMagia() - (atacado.getDefensaMagica()) + ((random.nextInt(10)*ataca.getMagia())/30);
        if (danio < 0)
        {
            danio = 0;
        }
        int temp = atacado.getCurrentHP() - danio;
        if (temp >= 0) {
            atacado.setCurrentHP(temp);
        } else {
            atacado.setCurrentHP(0);
        }
        String descripcion = "Una bola de fuego envuelve a su objetivo.\n";
        salida = salida + salidaAtaqueMagico(ataca.getNombre(), atacado.getNombre(), "FUEGO", descripcion, atacado.getCurrentHP() == 0, danio);
        return salida;
    }

    public static String fuego2(Personaje ataca, Personaje atacado) {
        String salida = "";
        Random random = new Random();
        int danio = (int) (ataca.getMagia()*1.5 - (atacado.getDefensaMagica()/2) + (random.nextInt(10)*ataca.getMagia())/30);
        if (danio < 0)
        {
            danio = 0;
        }
        int temp = atacado.getCurrentHP() - danio;
        if (temp >= 0) {
            atacado.setCurrentHP(temp);                
        } else {
            atacado.setCurrentHP(0);
        }
        String descripcion = "Lluvia de lava cae y golpea la tierra.\n";
        salida = salida + salidaAtaqueMagico(ataca.getNombre(), atacado.getNombre(), "ERUPCION", descripcion, atacado.getCurrentHP() == 0, danio);    
        return salida;  
    }
    
    public static String fuego3(Personaje ataca, Personaje atacado) {
        String salida = "";
        Random random = new Random();
        int danio =(int) (ataca.getMagia()*2.2 - (atacado.getDefensaMagica()/2) + (random.nextInt(10)*ataca.getMagia())/30);
        if (danio < 0)
        {
            danio = 0;
        }
        int temp = atacado.getCurrentHP() - danio;
        if (temp >= 0) {
            atacado.setCurrentHP(temp);                
        } else {
            atacado.setCurrentHP(0);
        }
        String descripcion = "Le rodean llamas, magma, y le azotadan piedras calizas.\n";
        salida = salida + salidaAtaqueMagico(ataca.getNombre(), atacado.getNombre(), "INFIERNO", descripcion, atacado.getCurrentHP() == 0, danio);    
        return salida;
    }
    
    public static String hielo1(Personaje ataca, Personaje atacado) {
        String salida = "";
        Random random = new Random();
        int danio = ataca.getMagia() - (atacado.getDefensaMagica()/2) + (random.nextInt(10)*ataca.getMagia())/80;
        if (danio < 0)
        {
            danio = 0;
        }
        int temp = atacado.getCurrentHP() - danio;
        if (temp >= 0) {
            atacado.setCurrentHP(temp);                
        } else {
            atacado.setCurrentHP(0);
        }
        String descripcion = "Hielo le envuelve y congela momentáneamente.\n";
        salida = salida + salidaAtaqueMagico(ataca.getNombre(), atacado.getNombre(), "HIELO", descripcion, atacado.getCurrentHP() == 0, danio);    
        return salida;
    }
    
    public static String hielo2(Personaje ataca, Personaje atacado) {
        String salida = "";
        Random random = new Random();
        int danio = (int) (ataca.getMagia()*1.7 - (atacado.getDefensaMagica()/2) + (random.nextInt(10)*ataca.getMagia())/80);
        if (danio < 0)
        {
            danio = 0;
        }
        int temp = atacado.getCurrentHP() - danio;
        if (temp >= 0) {
            atacado.setCurrentHP(temp);                
        } else {
            atacado.setCurrentHP(0);
        }
        String descripcion = "Una masa de hielo gigantesca de hielo cae y le golpea.\n";
        salida = salida + salidaAtaqueMagico(ataca.getNombre(), atacado.getNombre(), "GLACIAR", descripcion, atacado.getCurrentHP() == 0, danio);    
        return salida;
    }
    
    public static String hielo3(Personaje ataca, Personaje atacado) {
        String salida = "";
        Random random = new Random();
        int danio = (int) (ataca.getMagia()*3 - (atacado.getDefensaMagica()/2) + (random.nextInt(10)*ataca.getMagia())/60);
        if (danio < 0)
        {
            danio = 0;
        }
        int temp = atacado.getCurrentHP() - danio;
        if (temp >= 0) {
            atacado.setCurrentHP(temp);                
        } else {
            atacado.setCurrentHP(0);
        }
        String descripcion = "El aire se paraliza y se congela, llegando al Cero Absoluto.\n";
        salida = salida + salidaAtaqueMagico(ataca.getNombre(), atacado.getNombre(), "CERO ABSOLUTO", descripcion, atacado.getCurrentHP() == 0, danio);    
        return salida;
    }
    
    public static String trueno1(Personaje ataca, Personaje atacado) {
        String salida = "";
        Random random = new Random();
        int danio = ataca.getMagia() - (atacado.getDefensaMagica()) + (random.nextInt(10)*ataca.getMagia())/20;
        if (danio < 0)
        {
            danio = 0;
        }
        int temp = atacado.getCurrentHP() - danio;
        if (temp >= 0) {
            atacado.setCurrentHP(temp);                
        } else {
            atacado.setCurrentHP(0);
        }
        String descripcion = "Una descarga eléctrica le golpea.\n";
        salida = salida + salidaAtaqueMagico(ataca.getNombre(), atacado.getNombre(), "TRUENO", descripcion, atacado.getCurrentHP() == 0, danio);
        return salida;
    }
    
    public static String trueno2(Personaje ataca, Personaje atacado) {
        String salida = "";
        Random random = new Random();
        int danio = (int) (ataca.getMagia()*2 - (atacado.getDefensaMagica()/3) + (random.nextInt(10)*ataca.getMagia())/60);
        if (danio < 0)
        {
            danio = 0;
        }
        int temp = atacado.getCurrentHP() - danio;
        if (temp >= 0) {
            atacado.setCurrentHP(temp);                
        } else {
            atacado.setCurrentHP(0);
        }
        String descripcion = "Vientos huracanados y descargas potentes le hacen vibrar.\n";
        salida = salida + salidaAtaqueMagico(ataca.getNombre(), atacado.getNombre(), "TORMENTA", descripcion, atacado.getCurrentHP() == 0, danio);    
        return salida;
    }
    
    public static String caos(Personaje ataca, Personaje atacado) {
        String salida = "";
        Random random = new Random();
        int danio = (int) (ataca.getMagia()*3) + ((random.nextInt(10)*ataca.getMagia())/15);
        if (danio < 0)
        {
            danio = 0;
        }
        int temp = atacado.getCurrentHP() - danio;
        if (temp >= 0) {
            atacado.setCurrentHP(temp);                
        } else {
            atacado.setCurrentHP(0);
        }
        String descripcion = "Un portal a otra dimensión se abre, de donde sirvientes del Caos emergen "
                + "a corroer su carne.\n";
        salida = salida + salidaAtaqueMagico(ataca.getNombre(), atacado.getNombre(), "CAOS", descripcion, atacado.getCurrentHP() == 0, danio);    
        return salida;
    }
    
    public static String curar(Personaje personaje, int porcentaje) {
        int recupera = 0;
        if (personaje.getCurrentHP() > 0)
        {
            recupera = (personaje.getMaxHP()*porcentaje/100);
            if (recupera + personaje.getCurrentHP() > personaje.getMaxHP()) 
            {
                recupera = personaje.getMaxHP() - personaje.getCurrentHP();
            }
            personaje.setCurrentHP((int) (personaje.getCurrentHP() + recupera));
        }
        return personaje.getNombre() + " recuperó " + recupera + " puntos de daño.\n";
    }

    public static String curarParty(ArrayList<Personaje> lista, int posEnemigo, int porcentaje) {
        String resultadoCuracion = "";
        for (int i = 0; i < lista.size(); i++) {
            if (i != posEnemigo) 
            {
               resultadoCuracion = resultadoCuracion + curar(lista.get(i), porcentaje);
            }
        }
        return resultadoCuracion;
    }

    public static String revivir(Personaje personaje, int porcentaje) {
        int recupera = 0;
        if (personaje.getCurrentHP() == 0)
        {
            recupera = (personaje.getMaxHP()*porcentaje/100);
            personaje.setCurrentHP((int) (personaje.getCurrentHP() + recupera));
        }
        return personaje.getNombre() + " recuperó " + recupera + " puntos de daño.\n";        
    }
    
    public static String revivirParty(ArrayList<Personaje> lista, int posEnemigo, int porcentaje) {
        String resultadoRevivir = "";
        for (int i = 0; i < lista.size(); i++) {
            if (i != posEnemigo) 
            {
               resultadoRevivir = resultadoRevivir + revivir(lista.get(i), porcentaje);
            }
        }
        return resultadoRevivir;        
    }
    
    public static String salidaAtaqueMagico(String atacante, String atacado, String hechizo,
            String descripcion, boolean dead, int danio) {
        String salida = "";
        salida = salida + atacante + " lanzó el hechizo " + hechizo + " contra " + atacado + ".\n";
        if (dead) {
            salida = salida + atacado + " quedó fuera de combate.\n";
        } else {
            salida = salida + descripcion + atacado + " perdió " + danio + " punto(s) de daño.\n";
        }
       return salida;
    }
    
}
