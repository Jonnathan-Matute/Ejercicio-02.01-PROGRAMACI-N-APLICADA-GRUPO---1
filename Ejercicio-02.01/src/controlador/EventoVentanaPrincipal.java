package controlador;

import vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class EventoVentanaPrincipal implements ActionListener {

    private VentanaPrincipal ventana;

    public EventoVentanaPrincipal(VentanaPrincipal ventana) {

        this.ventana = ventana;
    }

    File f;

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            //Crear Raiz
            if (ae.getSource().equals(this.ventana.getBotonList().get(0))) {
                if (this.ventana.getTextoList().get(0).getText().equals("")) {
                    throw new ExcepcionCamposVacios("");
                }
                String nombre1 = this.ventana.getTextoList().get(0).getText();
                System.out.println(nombre1);
                f = new File("" + nombre1);
                f.mkdir();
                for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                    this.ventana.getTextoList().get(i).setText(null);
                }
            }
            //Crear Carpetas, Subcarpetas, Archivos
            if (ae.getSource().equals(this.ventana.getBotonList().get(1))) {
                for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                    if (this.ventana.getTextoList().get(i).getText().equals("")) {
                        throw new ExcepcionCamposVacios("");
                    }
                }
                String nombre1 = this.ventana.getTextoList().get(0).getText();
                String nombre2 = this.ventana.getTextoList().get(1).getText();
                System.out.println(nombre1);
                File f3 = new File("" + nombre1), f2 = null;
                f3.mkdir();
                for (int i = 0; i < nombre2.length(); i++) {
                    if (nombre2.charAt(i) == 46) {
                        String nombre3 = (nombre2.substring(0, i - 1));
                        String extension = (nombre2.substring(i + 1, nombre2.length()));
                        File f1 = new File("" + nombre1);
                        try {
                            f = new File(File.createTempFile(nombre3, "." + extension, new File(f3.getPath())).getPath());
                            f2 = new File(f1.getPath() + "/" + nombre2);
                        } catch (IOException ex) {
                            System.out.println("Error");
                        }
                    } else {
                        File f = new File("" + nombre1 + "/" + nombre2);
                        f.mkdir();
                    }
                }
                f.renameTo(f2);
                f2.delete();
                for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                    this.ventana.getTextoList().get(i).setText(null);
                }
            }
            //Modifica Carpetas, Subcarpetas, Archivos
            if (ae.getSource().equals(this.ventana.getBotonList().get(2))) {
                for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                    if (this.ventana.getTextoList().get(i).getText().equals("")) {
                        throw new ExcepcionCamposVacios("");
                    }
                }
                String nombre1 = this.ventana.getTextoList().get(0).getText();
                String nombre2 = this.ventana.getTextoList().get(1).getText();
                File f = new File("" + nombre1);
                File f2 = new File("" + nombre2);
                f.renameTo(f2);
                for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                    this.ventana.getTextoList().get(i).setText(null);
                }
            }
            //Eliminar Carpetas, Subcarpetas, Archivos
            if (ae.getSource().equals(this.ventana.getBotonList().get(3))) {
                if (this.ventana.getTextoList().get(0).getText().equals("")) {
                    throw new ExcepcionCamposVacios("");
                }
                f = new File("" + this.ventana.getTextoList().get(0).getText());
                System.out.println(f.getPath());
                f.delete();
            }
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "No dejar los campos vacios");
        }
        if (ae.getSource().equals(this.ventana.getBotonList().get(4))) {
            System.out.println("hola");
            this.ventana.setTreenode(new DefaultMutableTreeNode("eclipse"));
            this.ventana.setModeloArbol(new DefaultTreeModel(this.ventana.getTreenode()));
            this.ventana.setNodo(new JTree(this.ventana.getModeloArbol()));
            this.ventana.setScroll(new JScrollPane(this.ventana.getNodo()));
            DefaultMutableTreeNode hijo = new DefaultMutableTreeNode("java");
            this.ventana.getModeloArbol().insertNodeInto(hijo, this.ventana.getTreenode(), 0);
        }
    }
}
