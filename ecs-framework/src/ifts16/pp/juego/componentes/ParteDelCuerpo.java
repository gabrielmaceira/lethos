/*
 * The MIT License
 *
 * Copyright 2018 fernando.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ifts16.pp.juego.componentes;

/**
 *
 * @author fernando
 */
public enum ParteDelCuerpo {
    Cabeza,
    Torso,
    Brazos,
    Piernas,
    Espalda,
    Manos,
    ManoDerecha,
    ManoIzquierda,
    Cintura,
    Cuello,
    Dedo,
    Oreja,
    Ojos,
    Nariz;
    
    @Override
    public String toString() {
        switch(this) {
            case Cabeza:
                return "Cabeza";
            case Torso:
                return "Torso";
            case Brazos:
                return "Brazos";
            case Piernas:
                return "Piernas";
            case Espalda:
                return "Espalda";
            case Manos:
                return "Manos";
            case ManoDerecha:
                return "Mano derecha";
            case ManoIzquierda:
                return "Mano izquierda";
            case Cintura:
                return "Cintura";
            case Cuello:
                return "Cuello";
            case Dedo:
                return "Dedo";
            case Oreja:
                return "Oreja";
            case Ojos:
                return "Ojos";
            case Nariz:
                return "Nariz";
            default:
                return "";
            
        }
    }
}
