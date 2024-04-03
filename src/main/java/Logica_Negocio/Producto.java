/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Negocio;

/**
 *
 * @author 1002805933
 */
public class Producto {
    //Se crea los atributos
    public String nombre, marca, serial;
    
    //Se crean los contructores
    public Producto(){}

    public Producto(String nombre, String marca, String serial) {
        this.nombre = nombre;
        this.marca = marca;
        this.serial = serial;
    }
    
    //Se crean los setters y los getters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
    
    
}
