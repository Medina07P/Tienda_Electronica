/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_Admin;

import Helpers.HelperRegistro;
import Helpers.HelperValidacion;
import Logica_Conexion.Conexion;
import Logica_Negocio.Persona;
import Logica_Negocio.Producto;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author Santiago Lopez
 */
public class RegistrarPersonaAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarPersona
     */
    public ArrayList<Producto> lsproductos = new ArrayList<>();
    public ArrayList<Persona> lspersona = new ArrayList<>();
    Persona objper;
    String producto = "";
    int numglobal = 0;
    int band = 0;
      public String pathc;
      public String pathc1;
      public String pathc2;
      public String pathc3;
     public String s;
     public String s1;
     public String s2;
     public String s3;

    public RegistrarPersonaAdministrador() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(500,500);
        

        jTextField5.setVisible(false);
        jTextField6.setVisible(false);
        jTextField7.setVisible(false);
        jTextField8.setVisible(false);
        jTextField9.setVisible(false);
        jButton4.setVisible(false);
        jLabel12.setVisible(false);
        
        
        Path currentRelativePath = Paths.get("");
         s = currentRelativePath.toAbsolutePath().toString();
         s1 = currentRelativePath.toAbsolutePath().toString();
         s2 = currentRelativePath.toAbsolutePath().toString();
         s3 = currentRelativePath.toAbsolutePath().toString();
         pathc = s + "\\Images\\"+"Background2"+".jpg";
         pathc1 = s1 + "\\Images\\"+"Atras"+".PNG";
         pathc2 = s2 + "\\Images\\"+"Aceptar"+".PNG";
         pathc3 = s3 + "\\Images\\"+"Registrar"+".PNG";
        establecerImagen();
        establecerImagenaceptar();
        establecerImagenatras();
        establecerImagenpersona();
        establecerImagenproducto();

    }

    public int RegistrarNumeroProductos() {
        String num_pro = jTextField4.getText();
        int res1= HelperValidacion.ValidarVacio(num_pro);
        int numero = 0;
        int band=0;
        
        if(res1==0){
        try {
            numero = Integer.parseInt(num_pro);
        } catch (NumberFormatException e) {
            jTextField4.setBorder(new LineBorder(Color.RED, 2));
            System.out.println("Digite un numero valido" + e.getMessage());
            band = 1;
        }
        }else
        {
         JOptionPane.showMessageDialog(null, "Campo Vacio!");
         jTextField4.setBorder(new LineBorder(Color.RED, 2));
          band=1;
        }
        
        if(band==0){
        int res = HelperValidacion.ValidarCantidadRango(numero);
        

        if (res == 1 && band == 0) {
            numglobal = numero;
            numero = 0;
             jTextField4.setBorder(new LineBorder(Color.BLACK, 1));
            return 1;
        } else {
            jTextField4.setBorder(new LineBorder(Color.RED, 2));
            JOptionPane.showMessageDialog(null, "El numero no se encuentra en el rango");
            return 0;
        }
        }
    return 0;
    }

    public void RegistarProducto() {

        String nombre = jTextField1.getText();
        String marca = jTextField2.getText();
        String serial = jTextField3.getText();

        int res, res1, res2;

        res = Helpers.HelperValidacion.ValidarTodo(nombre);
        res1 = Helpers.HelperValidacion.ValidarTodo(marca);
        res2 = Helpers.HelperValidacion.ValidarTodoSerial(serial);

        if (res == 0 && res1 == 0 && res2 == 0) {

            jTextField1.setBorder(new LineBorder(Color.BLACK, 1));
            jTextField2.setBorder(new LineBorder(Color.BLACK, 1));
            jTextField3.setBorder(new LineBorder(Color.BLACK, 1));
            
            Producto objproducto = new Producto(nombre, marca, serial);
            lsproductos.add(objproducto);
            band++;
            
            JOptionPane.showMessageDialog(null, "Registrando producto"+"\t"+band+"de"+numglobal);

            if (band == numglobal) {

                System.out.println("Alcanzo el Limite de registro");

                jTextField5.setVisible(true);
                jTextField6.setVisible(true);
                jTextField7.setVisible(true);
                jTextField8.setVisible(true);
                jTextField9.setVisible(true);
                jTextField1.setVisible(false);
                jTextField2.setVisible(false);
                jTextField3.setVisible(false);
                jButton2.setVisible(false);

            }
        } else {
            if (res >= 1) {
                jTextField1.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo nombre");
            }
            if (res1 >= 1) {
                jTextField2.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo marca ");
            }
            if (res2 >= 1) {
                jTextField3.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campos serial");
            } 
        }

    }

    public void RegistrarPersona() {

        String nombre = jTextField5.getText();
        String apellido = jTextField6.getText();
         String cedula = jTextField7.getText();
        String direccion = jTextField8.getText();
        String nom_img = jTextField9.getText();
        
              int res, res1, res2, res3, res4;

        res = Helpers.HelperValidacion.ValidarTodo(nombre);
        res1 = Helpers.HelperValidacion.ValidarTodo(apellido);
        res2 = Helpers.HelperValidacion.ValidarTodoLetra(cedula);
        res3 =  Helpers.HelperValidacion.ValidarTodoDireccion(direccion);
        res4 = Helpers.HelperValidacion.ValidarTodoSerial(nom_img);
        
        if(res==0 && res1==0 && res2==0 && res3==0 && res4==0){

        for (int i = 0; i < lsproductos.size(); i++) {
            producto += lsproductos.get(i).getNombre() + "," + lsproductos.get(i).getMarca() + "," + lsproductos.get(i).getSerial() + ";";

        }

        int id = (int) (Math.random() * 100000);

        objper = new Persona(String.valueOf(id), nombre, apellido, direccion, cedula, producto, nom_img);
        lspersona.add(objper);
        objper.setProductos(lsproductos);
        HelperRegistro.RegistrarPersonaNubeI(objper, id, producto);
        producto = "";

        jTextField5.setVisible(false);
        jTextField6.setVisible(false);
        jTextField7.setVisible(false);
        jTextField8.setVisible(false);
        jTextField9.setVisible(false);
        jButton1.setVisible(false);
        jButton4.setVisible(true);
        jLabel12.setVisible(true);

        jLabel12.setText("Registro exitoso, El id del cliente es:" + "\t" + id);
        }else
        {
            if (res >= 1) {
                jTextField5.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo nombre");
            }
            if (res1 >= 1) {
                jTextField6.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo apellido ");
            }
            if (res2 >= 1) {
                jTextField7.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campos cedula");
            } 
             if (res3 >= 1) {
                jTextField8.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campos direccion");
            }
              if (res4 >= 1) {
                jTextField9.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campos nombre imagen");
            } 
        }

    }

     public void establecerImagen() {
        
        Image img = null;
        try {
            File file = new File(pathc);
           img = ImageIO.read(new File(pathc));
            //5. Setear la imagen al JLabel
            jLabel13.setIcon(new ImageIcon(img));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }
    }
     
     public void establecerImagenatras() {
        
        Image img = null;
        try {
            File file = new File(pathc1);
           img = ImageIO.read(new File(pathc1));
            //5. Setear la imagen al JLabel
            jButton4.setIcon(new ImageIcon(img));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }
    }
       public void establecerImagenaceptar() {
        
        Image img = null;
        try {
            File file = new File(pathc2);
           img = ImageIO.read(new File(pathc2));
            //5. Setear la imagen al JLabel
            jButton3.setIcon(new ImageIcon(img));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }
    }
         public void establecerImagenproducto() {
        
        Image img = null;
        try {
            File file = new File(pathc3);
           img = ImageIO.read(new File(pathc3));
            //5. Setear la imagen al JLabel
            jButton2.setIcon(new ImageIcon(img));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }
    }
           public void establecerImagenpersona() {
        
        Image img = null;
        try {
            File file = new File(pathc3);
           img = ImageIO.read(new File(pathc3));
            //5. Setear la imagen al JLabel
            jButton1.setIcon(new ImageIcon(img));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Persona Administrador");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registrar Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 140, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 72, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Marca");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Serial");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 70, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 69, 260, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 260, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 132, 260, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad Productos");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 43, 150, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 103, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 242, 80, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Apellido");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 273, 80, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Direccion");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 326, 80, -1));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 239, 187, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 267, 187, -1));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 295, 187, -1));
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 323, 187, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cedula");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 298, 80, -1));

        jButton1.setBackground(new java.awt.Color(255, 165, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 255, 255));
        jButton1.setActionCommand("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 50, 40));

        jButton2.setBackground(new java.awt.Color(255, 165, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 255, 255));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 50, -1));

        jButton3.setBackground(new java.awt.Color(255, 165, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 255, 255));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 50, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Registrar Persona");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 217, 130, -1));

        jButton4.setBackground(new java.awt.Color(255, 165, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 255, 255));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 50, 20));
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 351, 187, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nombre Imagen");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 357, 140, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 404, 380, -1));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 500));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 480, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        RegistarProducto();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegistrarPersona();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int retorno = RegistrarNumeroProductos();
        if (retorno == 1) {
            jTextField4.setVisible(false);
            jButton3.setVisible(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MenuAdministrador menu = new MenuAdministrador();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarPersonaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersonaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersonaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersonaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarPersonaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
