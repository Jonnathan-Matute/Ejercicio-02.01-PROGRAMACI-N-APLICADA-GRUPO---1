/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import modelo.FileCA;

/**
 *
 * @author jonnathan matute
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<FileCA> fCA= new ArrayList<FileCA>();
        GestionDato gD= new GestionDato(fCA);
        VentanaPrincipal vP = new VentanaPrincipal("Files",gD);
        vP.setVisible(true);
    }
    
}
