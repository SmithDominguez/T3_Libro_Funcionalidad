/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.time.LocalDate;
/**
 *
 * @author PC
 */
public class Devolucion {
    private String id;
    private LocalDate fechaDevolucion;
    private double multa;

    public Devolucion(LocalDate fechaDevolucion, double multa) {
        this.fechaDevolucion = fechaDevolucion;
        this.multa = multa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
}
