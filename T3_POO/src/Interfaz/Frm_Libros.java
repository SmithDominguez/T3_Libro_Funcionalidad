/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Conexion.DataAccesLibro;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import Entidades.Libro;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Conexion.DataBaseConnection;
import java.util.List;
import javax.swing.DefaultListModel;
/**
 *
 * @author PC
 */
public class Frm_Libros extends javax.swing.JFrame {
    
    private Connection conexion;
    private Statement st;
    private DefaultListModel modelList = new DefaultListModel();
    private List<Libro> librosLista;
    /**
     * Creates new form Frm_Libros
     */
    public Frm_Libros() {
        conectarDB();
        initComponents();
        list_Libros.setModel(modelList);
        listarLibros();
        limpiarCampos();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        txt_titulo = new javax.swing.JTextField();
        txt_autor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_Libros = new javax.swing.JList<>();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel1.setText("LIBROS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 10, 110, 30);

        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 50, 60, 20);

        jLabel3.setText("Cantidad Disponible");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 140, 130, 16);

        jLabel4.setText("Titulo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 80, 60, 16);

        jLabel5.setText("Autor");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 110, 60, 16);

        txt_cantidad.setText("jTextField1");
        getContentPane().add(txt_cantidad);
        txt_cantidad.setBounds(150, 140, 150, 22);

        txt_codigo.setText("jTextField1");
        getContentPane().add(txt_codigo);
        txt_codigo.setBounds(100, 50, 150, 22);

        txt_titulo.setText("jTextField1");
        getContentPane().add(txt_titulo);
        txt_titulo.setBounds(100, 80, 150, 22);

        txt_autor.setText("jTextField1");
        getContentPane().add(txt_autor);
        txt_autor.setBounds(100, 110, 150, 22);

        list_Libros.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list_Libros);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 170, 400, 170);

        btn_agregar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregar);
        btn_agregar.setBounds(320, 40, 90, 23);

        btn_eliminar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar);
        btn_eliminar.setBounds(320, 100, 90, 23);

        btn_buscar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar);
        btn_buscar.setBounds(320, 70, 90, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        try {
            Libro libro = new Libro(txt_codigo.getText(), txt_titulo.getText(),txt_autor.getText(),Integer.parseInt(txt_cantidad.getText()));
            insertarLibro(libro);
            limpiarCampos();
            listarLibros();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Rellena los datos");
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        int index = list_Libros.getSelectedIndex();
        if (index != -1) {
            Libro libroSeleccionado = librosLista.get(index);
            eliminarLibro(libroSeleccionado);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para eliminar.");
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String codigo = txt_codigo.getText();
        Libro libro = new Libro(codigo);
        //buscarUsuario(libro,codigo);
    }//GEN-LAST:event_btn_buscarActionPerformed
    private void conectarDB(){
        try {
            conexion = DataBaseConnection.getConnection();
            st = conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Libros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                                                                                          
    
    //METODOS
    private void insertarLibro(Libro libro){
        try {
            DataAccesLibro dao = new DataAccesLibro(st, libro);
            dao.insertarLibro();
            JOptionPane.showMessageDialog(this, "Insertado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese datos correctamente");
        }
    }
    private void eliminarLibro(Libro libro){
        try {
            DataAccesLibro dao = new DataAccesLibro(st, libro);
            dao.eliminarLibro();
            listarLibros();
            JOptionPane.showMessageDialog(this, "Eliminado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR: No se pudo eliminar");
        }
    } 

    private void listarLibros(){
        try {
            DataAccesLibro dao = new DataAccesLibro(st);
            librosLista = dao.getListaLibros();
            modelList.clear();
            for (Libro libro : librosLista) {
                modelList.addElement(libro.getCodigo()+" - " + libro.getTitulo() + " - " + libro.getAutor()+ " - " + libro.getCantidad());
            }
        } catch (Exception e) {
            Logger.getLogger(Frm_Libros.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void limpiarCampos() {
        txt_codigo.setText("");
        txt_titulo.setText("");
        txt_autor.setText("");
        txt_cantidad.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list_Libros;
    private javax.swing.JTextField txt_autor;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
