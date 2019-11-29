/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.sistemas;

import java.util.ArrayList;
import java.util.Random;
import lethos.entidades.Personaje;
import static lethos.sistemas.ListaAtaques.*;
import static lethos.componentes.ResultadoAtaques.*;

/**
 *
 * @author Gabriel Maceira
 */
public class CombateEnemigos {
    
    public static void ataqueErognar(ArrayList<Personaje> enemigos, int i, int azar, Random random, boolean defendiendo) {
        Personaje enemigo = enemigos.get(i);
        if (enemigo.getCurrentHP() < enemigo.getMaxHP()/10){
            if (azar < 30) 
            {
                IOLethos.mostrarTexto(enemigo.getNombre() + " extiende sus raíces.");
                IOLethos.mostrarTexto(curar(enemigo, 25));
            } else {
                int resultadoAzar = tirarDado(random, enemigos, i, defendiendo);
                IOLethos.mostrarTexto(fuego1(enemigo, enemigos.get(resultadoAzar)));
            }
        } else {
                int resultadoAzar = tirarDado(random, enemigos, i, defendiendo);
            if (azar < 85) 
            {
                String salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 100);
                IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
            } else {
                IOLethos.mostrarTexto(fuego1(enemigo, enemigos.get(resultadoAzar)));
            }
        }        
    }
    
    public static void ataqueAparicion(ArrayList<Personaje> enemigos, int i, int azar, Random random, boolean defendiendo){
        Personaje enemigo = enemigos.get(i);
        int resultadoAzar = tirarDado(random, enemigos, i, defendiendo);  
        
            if (enemigo.getCurrentHP() < (enemigo.getMaxHP()/20)){
                if (azar < 20) 
                {
                    IOLethos.mostrarTexto(trueno1(enemigo, enemigos.get(resultadoAzar)));
                } else {
                        if (azar < 60)
                        {
                            IOLethos.mostrarTexto(hielo1(enemigo, enemigos.get(resultadoAzar)));
                        }
                        else {
                            String salidaAtaque= ataqueFisico(enemigo, enemigos.get(resultadoAzar), 100);
                            IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
                        }
                }
            } else {
                if (azar < 20) 
                {
                    IOLethos.mostrarTexto(hielo1(enemigo, enemigos.get(resultadoAzar)));
                } else {
                    String salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 100);
                    IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
                }
            }
    }
    
    public static void ataqueTroll(ArrayList<Personaje> enemigos, int i, int azar, Random random, boolean defendiendo){
        Personaje enemigo = enemigos.get(i);
        if (enemigo.getCurrentHP() < enemigo.getMaxHP()/5){
            if (azar < 12) 
            {
                IOLethos.mostrarTexto(enemigo.getNombre() + " come una manzana.\n");
                IOLethos.mostrarTexto(curar(enemigo, 25));
            } else {
            int resultadoAzar = tirarDado(random, enemigos, i, defendiendo);            
            String salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 75);
            IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
            
            resultadoAzar = tirarDado(random, enemigos, i, defendiendo);            
            salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 75);
            IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
            
            resultadoAzar = tirarDado(random, enemigos, i, defendiendo);            
            salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 75);
            IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
            }
        } else {
            if (azar < 85) 
            {
            int resultadoAzar = tirarDado(random, enemigos, i, defendiendo);            
            String salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 70);
            IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
            
            resultadoAzar = tirarDado(random, enemigos, i, defendiendo);            
            salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 70);
            IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
            }
            else {
                IOLethos.mostrarTexto(enemigo.getNombre() + " parece distraido.\n");
            }
        }        
    }
    
    public static void ataqueMagma(ArrayList<Personaje> enemigos, int i, int azar, Random random, boolean defendiendo){
        Personaje enemigo = enemigos.get(i);
        if (enemigo.getCurrentHP() < enemigo.getMaxHP()/5){
            if (azar < 60) 
            {
                IOLethos.mostrarTexto(enemigo.getNombre() + " se hunde en la lava.\n");
                IOLethos.mostrarTexto(curar(enemigo, 20));
            } else {
                int resultadoAzar = tirarDado(random, enemigos, i, defendiendo);
                    IOLethos.mostrarTexto(fuego1(enemigo, enemigos.get(resultadoAzar)));
            }
        } else {
            int resultadoAzar = tirarDado(random, enemigos, i, defendiendo);
            if (azar < 85) 
            {
            String salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 100);
            IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
            }
            else {
                IOLethos.mostrarTexto(fuego2(enemigo, enemigos.get(resultadoAzar)));
            }
        }        
    }
    
    public static void ataqueSerena(ArrayList<Personaje> enemigos, int i, int azar, Random random, boolean defendiendo){
        Personaje enemigo = enemigos.get(i);
        int resultadoAzar = tirarDado(random, enemigos, i, defendiendo);
            
            if (enemigo.getCurrentHP() < (enemigo.getMaxHP()/30)){
                if (azar < 15) 
                {
                    IOLethos.mostrarTexto(hielo3(enemigo, enemigos.get(resultadoAzar)));
                } else {
                        if (azar < 70)
                        {
                        IOLethos.mostrarTexto(hielo2(enemigo, enemigos.get(resultadoAzar)));
                        }
                        else {
                        String salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 80);
                        IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
                        
                        resultadoAzar = tirarDado(random, enemigos, i, defendiendo);
                        salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 80);
                        IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
                        }
                }
            } else {
                if (azar < 30) 
                {
                    IOLethos.mostrarTexto(hielo2(enemigo, enemigos.get(resultadoAzar)));
                } else {
                    String salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 100);
                    IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
                }
            }
    }
    
    public static void ataqueSerpiente(ArrayList<Personaje> enemigos, int i, int azar, Random random, boolean defendiendo){
        Personaje enemigo = enemigos.get(i);
        int resultadoAzar = tirarDado(random, enemigos, i, defendiendo);
            
            if (enemigo.getCurrentHP() < (enemigo.getMaxHP()/5)){
                if (azar < 20) 
                {
                    IOLethos.mostrarTexto(trueno2(enemigo, enemigos.get(resultadoAzar)));
                } else {
                        if (azar < 60)
                        {
                            IOLethos.mostrarTexto(hielo2(enemigo, enemigos.get(resultadoAzar)));
                        }
                        else {
                        String salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 75);
                        IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
                        
                        resultadoAzar = tirarDado(random, enemigos, i, defendiendo);
                        salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 75);
                        IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
                        }
                }
            } else {
                if (azar < 40) 
                {
                    IOLethos.mostrarTexto(trueno1(enemigo, enemigos.get(resultadoAzar)));
                } else {
                    String salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 100);
                    IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
                }
            }
    }
    
    public static void ataqueKobo(ArrayList<Personaje> enemigos, int i, int azar, Random random, boolean defendiendo){
        Personaje enemigo = enemigos.get(i);
        if (enemigo.getCurrentHP() < enemigo.getMaxHP()/10){
            if (azar < 33) 
            {
                IOLethos.mostrarTexto(enemigo.getNombre() + " concentra los poderes de la oscuridad.");
                IOLethos.mostrarTexto(curar(enemigo, 33));
            } else {
                int resultadoAzar = tirarDado(random, enemigos, i, defendiendo);
                if (azar < 30)
                    {
                    IOLethos.mostrarTexto(fuego3(enemigo, enemigos.get(resultadoAzar)));
                    } 
                    else if (azar < 60)
                        {
                        IOLethos.mostrarTexto(hielo3(enemigo, enemigos.get(resultadoAzar)));
                        } else if (azar < 90) 
                            {
                            IOLethos.mostrarTexto(caos(enemigo, enemigos.get(resultadoAzar)));
                            }
                        else {
                        String salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 80);
                        IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));

                        resultadoAzar = tirarDado(random, enemigos, i, defendiendo);            
                        salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 60);
                        IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));

                        resultadoAzar = tirarDado(random, enemigos, i, defendiendo);            
                        salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 110);
                        IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));                       
                        }
                }
        } 
        else {
            int resultadoAzar = tirarDado(random, enemigos, i, defendiendo);
            if (azar < 20)
                {
                IOLethos.mostrarTexto(fuego2(enemigo, enemigos.get(resultadoAzar)));
                } 
                else if (azar < 40)
                    {
                    IOLethos.mostrarTexto(hielo2(enemigo, enemigos.get(resultadoAzar)));
                    } else if (azar < 70) 
                        {
                        resultadoAzar = tirarDado(random, enemigos, i, defendiendo);            
                        String salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar), 120);
                        IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));

                        resultadoAzar = tirarDado(random, enemigos, i, defendiendo);            
                        salidaAtaque = ataqueFisico(enemigo, enemigos.get(resultadoAzar),80);
                        IOLethos.mostrarTexto(resultadoAtaque(enemigos, i, resultadoAzar, salidaAtaque));
                        }
                    else {
                        IOLethos.mostrarTexto(trueno2(enemigo, enemigos.get(resultadoAzar)));
                    }
            }
    }
    
    public static int tirarDado(Random random, ArrayList<Personaje> enemigos, int i, boolean defendiendo) {
        int resultadoAzar = random.nextInt(enemigos.size());
        if (!defendiendo) 
        {
            while (resultadoAzar == i || enemigos.get(resultadoAzar).getCurrentHP() <= 0) 
            {
                resultadoAzar = random.nextInt(enemigos.size());    
            }
            return resultadoAzar;
        } else {
            resultadoAzar = 0;
            while (!enemigos.get(resultadoAzar).getNombre().equalsIgnoreCase("caballero")) {
                resultadoAzar++;
            }
        }
        return resultadoAzar;
    }
}
