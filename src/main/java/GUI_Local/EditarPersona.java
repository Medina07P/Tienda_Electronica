/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_Local;

import Logica_Conexion.Conexion;
import Logica_Conexion.PersonaDAO;
import Logica_Negocio.Persona;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author Santiago Lopez
 */
public class EditarPersona extends javax.swing.JFrame {

    /**
     * Creates new form RegistarBDLocal
     */
    Persona per;
    public String pathc;
    public String pathc1;
    public String pathc2;
    public String pathc3;
    public String s;
    public String s1;
    public String s2;
    public String s3;
    
    public EditarPersona() {
        initComponents();
        this.setLocationRelativeTo(null);
        Path currentRelativePath = Paths.get("");
        s = currentRelativePath.toAbsolutePath().toString();
        s1 = currentRelativePath.toAbsolutePath().toString();
        s2 = currentRelativePath.toAbsolutePath().toString();
        s3 = currentRelativePath.toAbsolutePath().toString();
        pathc = s + "\\Images\\" + "Background2" + ".jpg";
        pathc1 = s1 + "\\Images\\" + "Lupa" + ".PNG";
        pathc2 = s2 + "\\Images\\" + "Editar" + ".PNG";
        pathc3 = s3 + "\\Images\\" + "Atras" + ".PNG";
        establecerImagen();
        establecerImagenEditar();
        establecerImagenLupa();
        establecerImagenatras();
        jButton2.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void establecerImagen() {
        
        Image img = null;
        try {
            File file = new File(pathc);
            img = ImageIO.read(new File(pathc));
            //5. Setear la imagen al JLabel
            jLabel9.setIcon(new ImageIcon(img));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }
    }
    public void establecerImagenLupa() {
        
        Image img = null;
        try {
            File file = new File(pathc1);
           img = ImageIO.read(new File(pathc1));
            //5. Setear la imagen al JLabel
            jButton1.setIcon(new ImageIcon(img));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }
    }
    public void establecerImagenEditar() {
        
        Image img = null;
        try {
            File file = new File(pathc2);
           img = ImageIO.read(new File(pathc2));
            //5. Setear la imagen al JLabel
            jButton2.setIcon(new ImageIcon(img));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }
    }
            public void establecerImagenatras() {
        
        Image img = null;
        try {
            File file = new File(pathc3);
           img = ImageIO.read(new File(pathc3));
            //5. Setear la imagen al JLabel
            jButton3.setIcon(new ImageIcon(img));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(255, 165, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 40, 128, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 80, 128, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 120, 128, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 158, 128, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 198, 128, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 232, 128, -1));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 272, 128, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("Uid");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 255));
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 83, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 255));
        jLabel3.setText("Apellido");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 123, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 255));
        jLabel4.setText("Direccion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 161, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 255, 255));
        jLabel5.setText("Cedula");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 201, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 255, 255));
        jLabel6.setText("Productos");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 235, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 255, 255));
        jLabel7.setText("Nombre Imagen");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 278, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Editar Persona Local");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 165, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 165, 0));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String uid = jTextField1.getText();
        String nombre = jTextField2.getText();
        String apellido = jTextField3.getText();
        String direccion = jTextField4.getText();
        String cedula = jTextField5.getText();
        String producto = jTextField6.getText();
        String nombreimg = jTextField7.getText();
        int res, res1, res2, res3, res4, res5, res6;
            

        res = Helpers.HelperValidacion.ValidarTodo(nombre);
        res1 = Helpers.HelperValidacion.ValidarTodo(apellido);
        res2 = Helpers.HelperValidacion.ValidarTodoLetra(cedula);
        res3 =  Helpers.HelperValidacion.ValidarTodoDireccion(direccion);
        res4 = Helpers.HelperValidacion.ValidarTodoSerial(nombreimg);
        res5 = Helpers.HelperValidacion.ValidarVacio(producto);
        res6 = Helpers.HelperValidacion.ValidarTodoLetra(uid);
        if (res == 0 && res1 == 0 && res2 == 0 && res3==0 && res4==0 && res5==0 && res6==0) {
        try {
            per = new Persona(uid, nombre, apellido, direccion, cedula, producto, nombreimg);
            PersonaDAO dao = new PersonaDAO();
            dao.update(per);
            JOptionPane.showMessageDialog(null, "Actualizar Exitoso");
        } catch (Exception e) {
            System.out.println("Excepcion" + e);
        }
           }
        else{
            if (res6 >= 1) {
                jTextField1.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo uid");
            } 
             if (res >= 1) {
                jTextField2.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo nombre");
            }
            if (res1 >= 1) {
                jTextField3.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo apellido ");
            }
            if (res3 >= 1) {
                jTextField4.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo direccion");
            }
            if (res2 >= 1) {
                jTextField5.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo cedula");
            } 
             
            if (res5 >= 1) {
                jTextField6.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo Producto");
            } 
            if (res4 >= 1) {
                jTextField7.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo Nombre Imagen");
            } 
        }  

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PersonaDAO per = new PersonaDAO();
        String id = jTextField1.getText();
        try {
            Persona persona = per.getPersona(id);
            if (persona == null) {
                jTextField1.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "No se ha encontrado persona");
            }
            jTextField1.setText(persona.getUid());
            jTextField2.setText(persona.getNombre());
            jTextField3.setText(persona.getApellido());
            jTextField4.setText(persona.getDireccion());
            jTextField5.setText(persona.getCedula());
            jTextField6.setText(persona.getProducto());
            jTextField7.setText(persona.getNom_img());
            jButton2.setVisible(true);
            jTextField1.setEditable(false);
            
            
        } catch (Exception e) {
            System.out.println("Excepcion" + e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MenuLocal menu = new MenuLocal();
        menu.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistarBDLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistarBDLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistarBDLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistarBDLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistarBDLocal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
