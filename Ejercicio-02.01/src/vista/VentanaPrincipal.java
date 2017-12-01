/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaPrincipal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class VentanaPrincipal extends JFrame {

    private DefaultTreeModel modeloArbol;
    private DefaultMutableTreeNode treenode;
    private JTree nodo;
    private JScrollPane scroll;
    private JButton boton;
    private JPanel panelInicial;
    private List<JLabel> labelList;
    private List<JTextField> textoList;
    private List<JButton> botonList;
    private JComboBox combo;

    public VentanaPrincipal(String titulo) {
        this.setTitle(titulo);
        this.setDefaultCloseOperation(3);
        this.setSize(600, 500);
        this.setLocation(360, 20);
        this.iniciaCompontente();
    }

    public void iniciaCompontente() {

        //Ingreso de datos
        this.panelInicial = new JPanel(new BorderLayout());
        JPanel panelNorte = new JPanel(new BorderLayout());

        this.labelList = new ArrayList<JLabel>();
        this.labelList.add(new JLabel("Directorio Raiz/Carpeta :"));
        this.labelList.add(new JLabel("Nombre Subcarpeta/Archivo: "));
        this.labelList.add(new JLabel("Creacion de Carpetas/Archivos"));

        this.textoList = new ArrayList<JTextField>();
        for (int i = 0; i < this.labelList.size() - 1; i++) {
            this.textoList.add(new JTextField());
        }

        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Crear Raiz"));
        this.botonList.add(new JButton("Crear  C / S / A"));
        this.botonList.add(new JButton("Modificar"));
        this.botonList.add(new JButton("Eliminar"));
        this.botonList.add(new JButton("Mostrar"));
        for (int i = 0; i < this.botonList.size(); i++) {
            this.botonList.get(i).addActionListener(new EventoVentanaPrincipal(this));
        }

        LayoutManager disenio = new GridLayout(4, 1);
        LayoutManager disDatos = new GridLayout(2, 2);
        LayoutManager disAccion = new GridLayout(1, 5);
        LayoutManager disTitulo = new FlowLayout();

        JPanel panelDisenio = new JPanel(disenio);
        JPanel panelTitulo = new JPanel(disTitulo);
        JPanel panelIngreso = new JPanel(disDatos);
        JPanel panelAccion = new JPanel(disAccion);

        for (int i = 0; i < this.labelList.size() - 1; i++) {
            panelIngreso.add(this.labelList.get(i));
            panelIngreso.add(this.textoList.get(i));
        }

        panelTitulo.add(this.labelList.get(2));
        panelAccion.add(this.botonList.get(0));
        panelAccion.add(this.botonList.get(1));
        panelAccion.add(this.botonList.get(2));
        panelAccion.add(this.botonList.get(3));
        panelAccion.add(this.botonList.get(4));
        panelDisenio.add(panelTitulo);
        panelDisenio.add(panelIngreso);
        panelDisenio.add(panelAccion);      

        panelNorte.add(panelDisenio, BorderLayout.NORTH);

        this.panelInicial.add(panelNorte, BorderLayout.NORTH);
        this.panelInicial.add(this.scroll, BorderLayout.CENTER);

        this.add(this.panelInicial);

    }

    public DefaultTreeModel getModeloArbol() {
        return modeloArbol;
    }

    public void setModeloArbol(DefaultTreeModel modeloArbol) {
        this.modeloArbol = modeloArbol;
    }

    public DefaultMutableTreeNode getTreenode() {
        return treenode;
    }

    public void setTreenode(DefaultMutableTreeNode treenode) {
        this.treenode = treenode;
    }

    public JTree getNodo() {
        return nodo;
    }

    public void setNodo(JTree nodo) {
        this.nodo = nodo;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JPanel getPanelInicial() {
        return panelInicial;
    }

    public void setPanelInicial(JPanel panelInicial) {
        this.panelInicial = panelInicial;
    }

    public List<JLabel> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<JLabel> labelList) {
        this.labelList = labelList;
    }

    public List<JTextField> getTextoList() {
        return textoList;
    }

    public void setTextoList(List<JTextField> textoList) {
        this.textoList = textoList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public JComboBox getCombo() {
        return combo;
    }

    public void setCombo(JComboBox combo) {
        this.combo = combo;
    }
    
}