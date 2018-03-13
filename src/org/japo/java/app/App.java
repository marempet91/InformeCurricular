/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.app;

import java.util.Properties;
import org.japo.java.libraries.UtilesApp;
import java.lang.Double;

/**
 *
 * @author (c) 2017 Martín Emilov Petkov - marempet@gmail.com
 */
public class App {

    public static final String PRP_ALUMNO = "alumno";
    public static final String PRP_EXPEDIENTE = "expediente";
    public static final String PRP_CICLO = "ciclo";
    public static final String PRP_CURSO = "curso";
    public static final String PRP_MODULOS = "modulo";
    public static final String PRP_NOTAS_EV_UNO = "ev1";
    public static final String PRP_NOTAS_EV_DOS = "ev2";
    public static final String PRP_NOTAS_EV_TRES = "ev3";


    public void launchApp() {
//Importar propiedades
        Properties prp = UtilesApp.importarPropiedades();

//importar datos
        String[] modulos = prp.getProperty(PRP_MODULOS).split("-");
        String[] notas_ev1 = prp.getProperty(PRP_NOTAS_EV_UNO).split("-");
        String[] notas_ev2 = prp.getProperty(PRP_NOTAS_EV_DOS).split("-");
        String[] notas_ev3 = prp.getProperty(PRP_NOTAS_EV_TRES).split("-");

//calcular medias
        double notas_final[] = new double[modulos.length];
        for (int i = 0; i < notas_final.length; i++) {
            notas_final[i] = 0.0;
        }
        String notas_text[] = new String[modulos.length];
        for (int i = 0; i < notas_text.length; i++) {
            notas_text[i] = "";
        }
        int susp = 0;
        for (int i = 0; i < notas_ev1.length; i++) {
            notas_final[i] = (Double.parseDouble(notas_ev1[i]) + Double.parseDouble(notas_ev2[i]) + Double.parseDouble(notas_ev3[i])) / 3;
            if (notas_final[i] < 5.0) {
                susp++;
                notas_text[i] = "SUSPENDIDO";
            } else {
                notas_text[i] = "APROBADO";
            }
        }

//Bucle principal
        System.out.printf("INFORME CURRICULAR - CICLO: %s -CURSO: %s\n", prp.getProperty(PRP_CICLO), prp.getProperty(PRP_CURSO));
        System.out.println("=====================================================");
        System.out.printf("Alumno .....: %s\n", prp.getProperty(PRP_ALUMNO));
        System.out.printf("Expediente .: %s\n", prp.getProperty(PRP_EXPEDIENTE));
        System.out.println("-----------------------------------------------------");
        System.out.println("Modulo        1EV    2EV    3EV     FINAL");
        System.out.println("---------    -----  -----  -----    -----");
        for (int i = 0; i < modulos.length; i++) {
            System.out.printf("%s   %5s  %5s  %5s    %5.1f - %s\n", modulos[i], notas_ev1[i], notas_ev2[i], notas_ev3[i], notas_final[i], notas_text[i]);
        }
        System.out.println("---");
        System.out.println("Atención a los padres:");
        System.out.printf("Su hijo/a tiene %d modulos suspendidos\n", susp);
    }

}
