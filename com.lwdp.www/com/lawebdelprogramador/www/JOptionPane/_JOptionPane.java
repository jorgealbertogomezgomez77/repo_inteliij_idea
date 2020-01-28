
package lawebdelprogramador.www.JOptionPane;

import javax.swing.*;

/**
 * @author Ing. Jorge Alberto Gomez Gomez, January 30 of the 2019, 02:07 AM
 * @mail jorgealbertogomezgomez77@gmail.com
 * @link https://oase1973.wixsite.com/oswaldoserrano/menu-principal
 */

public class _JOptionPane {
    public static void main(String[] args) {
        int res;
        String cadena;
        ImageIcon foto;
        foto = new ImageIcon("josedavid.jpg");

        JOptionPane.showMessageDialog(null, "Mensaje Basico...");
        JOptionPane.showMessageDialog(null, "Mensaje de Error...", "ERROR", 0);
        JOptionPane.showMessageDialog(null, "Mensaje de Información...", "INFORMACIÓN", 1);
        JOptionPane.showMessageDialog(null, "Mensaje de Advertencia...", "ADVERTENCIA", 2);
        JOptionPane.showMessageDialog(null, "Mensaje de Pregunta...", "PREGUNTA", 3);
        JOptionPane.showMessageDialog(null, "Mensaje sin Titulo, ni Icono...", " ", -1);
        JOptionPane.showMessageDialog(null, "Mensaje con Icono Personalizado...", "ICONO... JOSE DAVID", 0, foto);


        cadena = JOptionPane.showInputDialog("Insertar un valor o cadena...");
        JOptionPane.showMessageDialog(null, "El valor o cadena ingresado es: " + cadena);
        cadena = JOptionPane.showInputDialog(null,"Ingresa un valor o cadena, despues del codigo de inicio", "123 ");
        JOptionPane.showMessageDialog(null, "El valor o cadena ingresado es: " + cadena);
        cadena = JOptionPane.showInputDialog(null, "Ingresar un valor o cadena, despues del codigo de inicio", "ABC ");
        JOptionPane.showMessageDialog(null, "El valor o cadena ingresado es: " + cadena);
        cadena = JOptionPane.showInputDialog(null, "Ingresar un valor o cadena", "ERROR", 0);
        JOptionPane.showMessageDialog(null, "El valor o cadena ingresado es: " + cadena);
        cadena = JOptionPane.showInputDialog(null, "Ingresar un valor o cadena", "INFORMACION", 1);
        JOptionPane.showMessageDialog(null, "El valor o cadena ingresado es: " + cadena);
        cadena = JOptionPane.showInputDialog(null, "Ingresar un valor o cadena", "ADVERTENCIA", 2);
        JOptionPane.showMessageDialog(null, "El valor o cadena ingresado es: " + cadena);
        cadena = JOptionPane.showInputDialog(null, "Ingresar un valor o cadena", "PREGUNTA", 3);
        JOptionPane.showMessageDialog(null, "El valor o cadena ingresado es: " + cadena);
        cadena = JOptionPane.showInputDialog(null, "Ingresar un valor o cadena", " ", -1);
        JOptionPane.showMessageDialog(null, "El valor o cadena ingresado es: " + cadena);
        cadena = (String)JOptionPane.showInputDialog(null, "Ingresar un valor o cadena", "ICONO PERSONAL", 0, foto, null, null);
        JOptionPane.showMessageDialog(null, "El valor o cadena ingresado es: " + cadena);


        res = JOptionPane.showConfirmDialog(null, "¿¿ Guardar los cambios ??");
        JOptionPane.showMessageDialog(null, "La respuesta es: " + res);
        res = JOptionPane.showConfirmDialog(null, "¿¿ Guardar los cambios ??", "PREGUNTA", 0);
        JOptionPane.showMessageDialog(null, "La respuesta es: " + res);
        res = JOptionPane.showConfirmDialog(null, "¿¿ Guardar los cambios ??", "PREGUNTA", 1);
        JOptionPane.showMessageDialog(null, "La respuesta es: " + res);
        res = JOptionPane.showConfirmDialog(null, "¿¿ Guardar los cambios ??", "PREGUNTA", 2);
        JOptionPane.showMessageDialog(null, "La respuesta es: " + res);
        res = JOptionPane.showConfirmDialog(null, "¿¿ Guardar los cambios ??", "PREGUNTA", -1);
        JOptionPane.showMessageDialog(null, "La respuesta es: " + res);
        res = JOptionPane.showConfirmDialog(null, "¿¿ Guardar los cambios ??", "ERROR... PREGUNTA", 1,0);
        JOptionPane.showMessageDialog(null, "La respuesta es: " + res);
        res = JOptionPane.showConfirmDialog(null, "¿¿ Guardar los cambios ??", "INFORMACION... PREGUNTA", 1,1);
        JOptionPane.showMessageDialog(null, "La respuesta es: " + res);
        res = JOptionPane.showConfirmDialog(null, "¿¿ Guardar los cambios ??", "ADVERTENCIA... PREGUNTA", 1,2);
        JOptionPane.showMessageDialog(null, "La respuesta es: " + res);
        res = JOptionPane.showConfirmDialog(null, "¿¿ Guardar los cambios ??", "PREGUNTA... UNA PREGUNTA", 1,3);
        JOptionPane.showMessageDialog(null, "La respuesta es: " + res);
        res = JOptionPane.showConfirmDialog(null, "¿¿ Guardar los cambios ??", " ", 1,-1);
        JOptionPane.showMessageDialog(null, "La respuesta es: " + res);
        res = JOptionPane.showConfirmDialog(null, "¿¿ Guardar los cambios ??", "PREGUNTA... JOSE DAVID", 1, 0, foto);
        JOptionPane.showMessageDialog(null, "La respuesta es: " + res);
    }
}
