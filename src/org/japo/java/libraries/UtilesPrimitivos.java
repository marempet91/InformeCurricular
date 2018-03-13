/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author CicloM
 */
public class UtilesPrimitivos {

    public static final Scanner SCN = new Scanner(System.in, "ISO-8859-1");

    public static final int obtenerEntero(String msgUsr, String msgErr) {

        SCN.useLocale(Locale.ENGLISH);

        int dato = 0;
        boolean entradaOK = true;

        do {
            try {
                System.out.print(msgUsr);
                dato = SCN.nextInt();
                entradaOK = false;
            } catch (Exception e) {
                System.out.println(msgErr);
            } finally {
                SCN.nextLine();
            }

        } while (entradaOK);
        return dato;
    }

    public static final int obtenerPar(String msgUsr, String msgErr) {

        SCN.useLocale(Locale.ENGLISH);

        int dato = 0;
        boolean parOK;

        do {
            dato = obtenerEntero(msgUsr, msgErr);
            parOK = dato % 2 == 0;
            if (!parOK) {
                System.out.println("ERROR: Numero Impar");
            }
        } while (!parOK);
        return dato;
    }

    public static final int obtenerEnteroRango(String msgUsr, String msgErr, int min, int max) {

        SCN.useLocale(Locale.ENGLISH);

        int dato = 0;
        boolean rangoOK = true;

        do {
            try {
                dato = obtenerEntero(msgUsr, msgErr);
                rangoOK = dato >= min && dato <= max;
                if (!rangoOK) {
                    System.out.println("ERROR: Fuera de rango");
                }
            } catch (Exception e) {
                System.out.println("ERROR: Error de entrada");
            } 

        } while (!rangoOK);
        return dato;
    }

    public static final char obtenerChar(char caracter) {

        SCN.useLocale(Locale.ENGLISH);

        char dato = '0';
        boolean charOK = true;

        do {
            try {
                System.out.print("Introduce un carácter ...: ");
                dato = SCN.nextLine().charAt(0);
                charOK = false;
            } catch (Exception e) {
                System.out.println("ERROR: Char Incorrecto");
            }
        } while (charOK);
        return dato;
    }

    public static final String obtenerString(String cadena) {

        SCN.useLocale(Locale.ENGLISH);

        System.out.print("Introduce una cadena ...: ");

        String dato;

        dato = SCN.nextLine().trim();

        return dato;
    }

    public static boolean validarParidad(double num) {

        return num % 2 == 0;
    }

    public static boolean validarSigno(double num) {

        return num >= 0;
    }

    public static double obtenerMayor(double n1, double n2) {

        double dato;

        if (n1 > n2) {
            dato = n1;
        } else {
            dato = n2;
        }

        return dato;
    }

    public static double obtenerMenor(double n1, double n2) {

        double dato;

        if (n1 < n2) {
            dato = n1;
        } else {
            dato = n2;
        }

        return dato;
    }

    public static int obtenerRelacion(double n1, double n2) {
        
        int dato;
        
        if(n1 > n2) {
            dato = 1;
        }else if (n1 == n2) {
            dato = 0;
        }else {
            dato = -1;
        }
        return dato;

    }

}
