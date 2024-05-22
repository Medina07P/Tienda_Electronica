/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Conexion;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Lopez
 */
public class Conexion {

    public static Firestore db;
     private static Connection con = null;

        public static void Conectar() {
        try {
            List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
            if (firebaseApps == null || firebaseApps.isEmpty()) {
                FileInputStream as = new FileInputStream("tienda-electronica.json");
                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(as))
                        .build();

                FirebaseApp.initializeApp(options);
                System.out.println("Conexión a Firestore establecida.");
            } else {
                System.out.println("FirebaseApp ya está inicializado.");
            }

            db = FirestoreClient.getFirestore();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static Connection getConnection() {
        String url = "jdbc:mysql:// localhost:3306/prueba";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return con;
    }


    
    
    public static void CerrarConexion() {
        if (db != null) {
            try {
                // No hay método explícito para cerrar Firestore, así que simplemente lo establecemos a null
                db = null;
                System.out.println("Conexión a Firestore cerrada.");
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        } else {
            System.out.println("No hay conexión activa para cerrar.");
        }
    }

    public static Firestore getFirestore() {
        return db;
    }
     
}
