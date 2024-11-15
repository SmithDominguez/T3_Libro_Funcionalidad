/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.sql.ResultSet;
/**
 *
 * @author PC
 */
public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private int cantidad;

    public Libro(String codigo) {
        this.codigo = codigo;
    }

    public Libro(String codigo, String titulo, String autor, int cantidad) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidad = cantidad;
    }
    public Libro(ResultSet rs) {
        try{
            this.codigo = rs.getString(1);
            this.titulo = rs.getString(2);
            this.autor = rs.getString(3);
            this.cantidad = rs.getInt(4);
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getLibroText(){
        return "" +codigo+ " - " + titulo + " - " + autor + " - " + cantidad;
    }
}
