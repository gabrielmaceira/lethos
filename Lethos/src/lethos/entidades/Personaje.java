/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.entidades;

import ifts16.pp.juego.entidades.PersonajeAbstracto;
import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import java.util.UUID;
import lethos.sistemas.IOLethos;

/**
 *
 * @author Gabriel Maceira
 */
public class Personaje extends PersonajeAbstracto {
    protected String nombre;
    protected int maxHP;
    protected int currentHP;
    protected int ataque;
    protected int defensa;
    protected int velocidad;
    protected int cantidadAtaques;
    protected int magia;
    protected int defensaMagica;
    protected int accuracy;
    protected boolean envenenado;
    protected boolean activo;
    protected UUID manoIzquierda;
    protected UUID manoDerecha;
    protected UUID armadura;
    protected UUID accesorio;
    
    
    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getCantidadAtaques() {
        return cantidadAtaques;
    }

    public void setCantidadAtaques(int cantidadAtaques) {
        this.cantidadAtaques = cantidadAtaques;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public int getDefensaMagica() {
        return defensaMagica;
    }

    public void setDefensaMagica(int defensaMagica) {
        this.defensaMagica = defensaMagica;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public boolean isEnvenenado() {
        return envenenado;
    }

    public void setEnvenenado(boolean envenenado) {
        this.envenenado = envenenado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    public void mostrarEstado() {
        IOLethos.mostrarTexto("Nombre: " + this.getNombre());
        IOLethos.mostrarTexto("Max HP: " + this.getMaxHP());
        IOLethos.mostrarTexto("Ataque: " + this.getAtaque());
        IOLethos.mostrarTexto("Defensa: " + this.getDefensa());
        IOLethos.mostrarTexto("Cantidad de Ataques: " + this.getCantidadAtaques());
        IOLethos.mostrarTexto("Magia: " + this.getMagia());
        IOLethos.mostrarTexto("Defensa mágica: " + this.getDefensaMagica());
        IOLethos.mostrarTexto("Velocidad: " + this.getVelocidad());
        IOLethos.mostrarTexto("Accuracy: " + this.getAccuracy());
        if (this.getManoDerecha() != null) {
            IOLethos.mostrarTexto("Mano Derecha: " + RepositorioPrincipal.traer(this.getManoDerecha()).getNombre());
        }
        if (this.getManoIzquierda() != null) {
            IOLethos.mostrarTexto("Mano Izquierda: " + RepositorioPrincipal.traer(this.getManoIzquierda()).getNombre());
        }
        if (this.getArmadura() != null) {
            IOLethos.mostrarTexto("Armadura: " + RepositorioPrincipal.traer(this.getArmadura()).getNombre());
        }
        if (this.getAccesorio() != null) {
            IOLethos.mostrarTexto("Accesorio: " + RepositorioPrincipal.traer(this.getAccesorio()).getNombre());
        }
        IOLethos.mostrarTexto("\n");
    }

    public UUID getManoIzquierda() {
        return manoIzquierda;
    }

    public void setManoIzquierda(UUID manoIzquierda) {
        this.manoIzquierda = manoIzquierda;
    }

    public UUID getManoDerecha() {
        return manoDerecha;
    }

    public void setManoDerecha(UUID manoDerecha) {
        this.manoDerecha = manoDerecha;
    }

    public UUID getArmadura() {
        return armadura;
    }

    public void setArmadura(UUID armadura) {
        this.armadura = armadura;
    }

    public UUID getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(UUID accesorio) {
        this.accesorio = accesorio;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    
}
