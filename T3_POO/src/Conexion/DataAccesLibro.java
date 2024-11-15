/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Entidades.Libro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DataAccesLibro {

    private Statement st;
    private Libro libro;

    public DataAccesLibro(Statement st) {
        this.st = st;
    }

    public DataAccesLibro(Statement st, Libro libro) {
        this.st = st;
        this.libro = libro;
    }

    public List<Libro> getListaLibros() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM Libros");
        List<Libro> libros = new ArrayList<>();
        while (rs.next()) {
            Libro libro = new Libro(rs);
            libros.add(libro);
        }
        return libros;
    }

    public void insertarLibro() throws SQLException {
        try {
            // Incluir todos los valores al realizar la inserción
            int codigo = Integer.parseInt(libro.getCodigo());
            String titulo = libro.getTitulo();
            String autor = libro.getAutor();
            int cantidad = libro.getCantidad();

            // Query para insertar con todos los campos
            st.execute("INSERT INTO Libros (Codigo, Titulo, Autor, Cantidad) VALUES (" 
                    + codigo + ", '" + titulo + "', '" + autor + "', " + cantidad + ")");
            System.out.println("Libro insertado correctamente.");
        } catch (SQLException e) {
            throw new SQLException("Error al insertar libro: " + e.getMessage());
        }
    }

    public void eliminarLibro() throws SQLException {
        try {
            st.execute("DELETE FROM Libros WHERE Codigo = " + libro.getCodigo());
            System.out.println("Libro eliminado correctamente.");
        } catch (SQLException e) {
            throw new SQLException("Error al eliminar libro: " + e.getMessage());
        }
    }
    public Libro buscar() throws SQLException {
        Libro libroEncontrado = null;
        try {
            // Consulta para buscar el libro por código
            String query = "SELECT * FROM Libros WHERE Codigo = " + libro.getCodigo();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                // Crear un objeto Libro con los datos obtenidos
                libroEncontrado = new Libro(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al buscar el libro: " + e.getMessage());
        }
        return libroEncontrado;
    }
}