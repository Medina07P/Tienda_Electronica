/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Negocio;

/**
 *
 * @author 1002805933
 */
public abstract class Usuario {
    //Se crea los atributos
    private String usu;
    private String contra;
    
    //Se crea el constructor

    public Usuario(String usu, String contra) {
        this.usu = usu;
        this.contra = contra;
    }
    
    //Se crea los setters y getters

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    //Se crea el método Logon
    //Se indica para luego ser implementado en la clase hija
    public abstract boolean LogOn(String usuario, String contraseña);
    
}
