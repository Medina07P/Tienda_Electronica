/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Conexion;

import static Logica_Conexion.PersonaDAO.con;
import Logica_Negocio.Persona;
import Logica_Negocio.Producto;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.nio.charset.CodingErrorAction;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author 1002805933
 */
public class PersonaProvider {

    CollectionReference reference;
    public static Firestore db;

    public static boolean GuardarPersona(String coleccion, String documento, Map<String, Object> data) {

        db = FirestoreClient.getFirestore();

        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Guardando Correctamente");
            return true;

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    public static ArrayList CargarInfoPersona() {
        Persona objper;
        Producto produ;

        ArrayList<Persona> lspersona = new ArrayList<>();
        ArrayList<Persona> lsprodu = new ArrayList<>();

        try {
            CollectionReference persona = Conexion.db.collection("Persona");
            ApiFuture<QuerySnapshot> querySnap = persona.get();
            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                objper = new Persona(document.getString("uid"),
                        document.getString("Nombre"),
                        document.getString("Apellido"),
                        document.getString("Cedula"),
                        document.getString("Direccion"),
                        document.getString("Productos"),
                        document.getString("Nom_img")
                );
                lspersona.add(objper);
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return lspersona;
    }

    public static boolean RetornarUid(String uid) {
        ArrayList<String> uids = new ArrayList<>();
        boolean rta = true;
        try {
            CollectionReference persona = Conexion.db.collection("Persona");
            ApiFuture<QuerySnapshot> querySnap = persona.get();
            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                uids.add(document.getString("uid"));

            }
            for (int i = 0; i < uids.size(); i++) {
                if (uid.equals(uids.get(i))) {
                    return rta;
                } else {
                    return !rta;
                }

            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return rta;
    }

    public static Persona CargarInfoPersonaCodigo(String codigo) {
        Persona objper;
        Persona objper1 = null;

        ArrayList<Persona> lspersona = new ArrayList<>();
        ArrayList<Producto> lsprodu = new ArrayList<>();

        try {
            CollectionReference persona = Conexion.db.collection("Persona");
            ApiFuture<QuerySnapshot> querySnap = persona.get();
            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                objper = new Persona(document.getString("uid"),
                        document.getString("Nombre"),
                        document.getString("Apellido"),
                        document.getString("Cedula"),
                        document.getString("Direccion"),
                        document.getString("Productos"),
                        document.getString("Nom_img")
                );
                lspersona.add(objper);
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        
        for (int i = 0; i < lspersona.size();i++){
           
         if (codigo.equals(lspersona.get(i).getUid()))
         {
                objper1 = lspersona.get(i);
            }
        }
        return objper1;
    }
}
