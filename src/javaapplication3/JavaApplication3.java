/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aramshanker
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Class clazz = Class.forName("javaapplication3.LocaleLanguageValidValue");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaApplication3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
