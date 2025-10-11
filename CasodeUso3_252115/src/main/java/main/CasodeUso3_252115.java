/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import controllers.ControlInscripcion;
import models.GestorDeInscripcion;
import views.PantallaListaTalleres;

/**
 *
 * @author sonic
 */
public class CasodeUso3_252115 {

    public static void main(String[] args) {
        GestorDeInscripcion modelo = new GestorDeInscripcion();
        ControlInscripcion control = new ControlInscripcion(modelo);
        PantallaListaTalleres pantalla = new PantallaListaTalleres(control);
        pantalla.setVisible(true);
    }
}
