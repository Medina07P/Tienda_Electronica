/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import Logica_Conexion.PersonaProvider;
import Logica_Negocio.Persona;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 1002805933
 */
public class HelperRegistro {
    public static void RegistrarPersonaNube(Persona objper, int id, String producto)
    {
       boolean res= PersonaProvider.RetornarUid(objper.getUid());
       if(!res){
           try {
               Map<String, Object> datos= new HashMap<>();
               datos.put("uid", objper.getUid());
               datos.put("Nombre", objper.getNombre());
               datos.put("Apellido", objper.getApellido());
               datos.put("Direccion", objper.getDireccion());
               datos.put("Cedula", objper.getCedula());
               datos.put("Productos", objper.getProductos());
               datos.put("Nom_img", objper.getNom_img());
               long inicio= System.currentTimeMillis();
               PersonaProvider.GuardarPersona("Persona", String.valueOf(id),datos);
               long fin= System.currentTimeMillis();
               HelperTiempo.RetornarTiempo(fin, inicio);
               System.out.println("Persona guardada con exito con id"+"\t"+id);
           }catch (Exception e) {
               System.out.println("Errro"+ e.getMessage());
           }
       }else {
           System.out.println("El uid ya existe");
       }
        
    }
    
}
