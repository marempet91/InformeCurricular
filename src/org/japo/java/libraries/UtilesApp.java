/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

/**
 *
 * @author Victor Hugo Polo Polo - victorpolodev@gmail.com ®
 */
public class UtilesApp {
    //MENSAJES CONSTANTES
    public static final String DEF_FICHERO_PRP = "app.properties";
    public static final String DEF_FICHERO_XML = "app.xml";
    
    
    public static Properties importarPropiedades(){
        return importarPropiedades(DEF_FICHERO_PRP);
    }
    
    public static Properties importarPropiedadesXML(){
        return importarPropiedades(DEF_FICHERO_XML);
    }
            
    
    public static Properties importarPropiedades(String fichero){
        //Objeto de propiedades Vacio
        Properties prp = new Properties();
        //Cargar fichero de propiedades
        try(FileReader fr = new FileReader(fichero)){
            prp.load(fr);
        }catch (Exception e){
            System.out.println("ERROR: Acceso al fichero " + fichero);
        }
        //Devolver propiedades
        return prp;
    }
    //Fichero Propiedades XML > Objeto Propiedades
    public static Properties importarPropiedadesXML(String fichero){
        //Objeto de Propiedades Vacio
        Properties prp = new Properties();
        //Cargar fichero de Propiedades
        try(FileInputStream fisXml = new FileInputStream(fichero)){
            //Cargar propiedades
            prp.loadFromXML(fisXml);
        }catch (Exception e){
            System.out.println("ERROR: Acceso al fichero " + fichero);
        }
        return prp;
    }
    
    //Propiedades > XML
    public static boolean exportarPropiedadesXML(Properties prp, String fichero){
        //Semaforo estado
        boolean procesoOk = false;
        
        //Proceso de salvaguarda de propiedades
        try(FileOutputStream fosXml = new FileOutputStream(fichero)){
            //Guarda las propiedades
            prp.storeToXML(fosXml, null);
            
            //Proceso Ok
            procesoOk = true;
        } catch (Exception e){
            //Mensaje de Error
            System.out.println(e);
        }
        
        //Devuelve Estado
        return procesoOk;
    }
}
