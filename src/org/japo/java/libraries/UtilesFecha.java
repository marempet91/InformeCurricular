/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

/**
 *
 * @author Ivan Rovira <aw.ivanrovira@gmail.com>
 */
public class UtilesFecha {

    public static final boolean validarBisiesto(int any) {

        return any % 400 == 0 || any % 100 != 0 && any % 4 == 0;
    }

    public static final int obtenerDiasMes(int mes, int any) {

        int numDias;

        switch (mes) {

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDias = 30;
                break;
            case 2:
                numDias = validarBisiesto(any) ? 29 : 28;
                break;
            default:
                numDias = 0;

        }
        return numDias;
    }

    public static final boolean validarFecha(int dia, int mes, int any) {

        return dia >= 1 && dia <= obtenerDiasMes(mes, any);

    }

    public static final boolean obtenerValidacion(String fecha) {

        boolean testOK;
        boolean validacion1;
        boolean validacion2 = false;

        if (fecha.charAt(2) == '/' && fecha.charAt(5) == '/'
                || fecha.charAt(2) == '.' && fecha.charAt(5) == '.'
                || fecha.charAt(2) == '-' && fecha.charAt(5) == '-') {
            validacion1 = true;
            testOK = true;
        } else {
            validacion1 = false;
            testOK = false;
        }

        if (fecha.charAt(4) == '/' && fecha.charAt(7) == '/'
                || fecha.charAt(4) == '.' && fecha.charAt(7) == '.'
                || fecha.charAt(4) == '-' && fecha.charAt(7) == '-') {
            validacion2 = false;
        } 

        return testOK ? validacion1 : validacion2;
    }

    public static final int obtenerDiaFecha(String fecha) {

        boolean testOK;
        int datoDia = 0;
        int datoDia2 = 0;

        if (obtenerValidacion(fecha) == true) {
            datoDia = Integer.parseInt(fecha.substring(0, 2));
            testOK = true;
        } else {
            datoDia2 = Integer.parseInt(fecha.substring(8, 10));
            testOK = false;
        }

        return testOK ? datoDia : datoDia2;
    }

    public static final int obtenerMesFecha(String fecha) {

        boolean testOK;
        int datoMes = 0;
        int datoMes2 = 0;

        if (obtenerValidacion(fecha) == true) {
            datoMes = Integer.parseInt(fecha.substring(3, 5));
            testOK = true;
        } else {
            datoMes2 = Integer.parseInt(fecha.substring(5, 7));
            testOK = false;
        }

        return testOK ? datoMes : datoMes2;
    }

    public static final int obtenerAnyFecha(String fecha) {

        boolean testOK;
        int datoAny = 0;
        int datoAny2 = 0;

        if (obtenerValidacion(fecha) == true) {
            datoAny = Integer.parseInt(fecha.substring(6, 10));
            testOK = true;
        } else {
            datoAny2 = Integer.parseInt(fecha.substring(0, 4));
            testOK = false;
        }

        return testOK ? datoAny : datoAny2;
    }
}
