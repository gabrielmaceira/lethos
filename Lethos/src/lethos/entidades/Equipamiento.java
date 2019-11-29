/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.entidades;

/**
 *
 * @author Gabriel Maceira
 */
public class Equipamiento extends Item {
    protected String clase;
    protected String tipo;
    protected int ataque;
    protected int defensa;
    protected int velocidad;
    protected int cantidadAtaques;
    protected int magia;
    protected int defensaMagica;
    protected int accuracy;
    protected boolean activo;

    public Equipamiento(String nombre, String descripcion, String clase, String tipo, int cantidad, int ataque, int defensa,
            int velocidad, int cantidadAtaques, int magia, int defensaMagica, int accuracy) {
        super(nombre, descripcion, cantidad);
        this.clase = clase;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.cantidadAtaques = cantidadAtaques;
        this.magia = magia;
        this.defensaMagica = defensaMagica;
        this.accuracy = accuracy;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo() {
        this.activo = true;
    }
    
    public void setInactivo() {
        this.activo = false;
    }
    
}
