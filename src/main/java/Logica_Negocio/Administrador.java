/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Negocio;

/**
 *
 * @author 1002805933
 */
public class Administrador extends Usuario {
    public Administrador(String usuario, String contraseña){
        super(usuario, contraseña);
    }

    @Override
    public boolean LogOn(String usuario, String contraseña) {
        boolean res=true;
        String comprobarusuario= Helpers.HelperCifrado.CifrarSHA256(getUsu());
        String comprobarcontra= Helpers.HelperCifrado.CifrarSHA256(getContra());
        System.out.println("usu ci abs"+ "\t"+comprobarusuario);
        System.out.println("usu ci abs"+ "\t"+comprobarcontra);
        if (comprobarusuario.compareTo(usuario)==0 && comprobarcontra.compareTo(contraseña)==0){
            return res;
            
        }else{
            return !res;
            
        }
    }
}
