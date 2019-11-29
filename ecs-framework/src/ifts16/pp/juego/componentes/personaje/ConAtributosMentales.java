/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifts16.pp.juego.componentes.personaje;

/**
 *
 * @author fernando
 */
public interface ConAtributosMentales {
    public int inteligencia();
    public int aumentarInteligencia(int cantidad);
    public int disminuirInteligencia(int cantidad);
    public int carisma();
    public int aumentarCarisma(int cantidad);
    public int disminuirCarisma(int cantidad);
    public int percepcion();
    public int aumentarPercepcion(int cantidad);
    public int disminuirPercepcion(int cantidad);
}
