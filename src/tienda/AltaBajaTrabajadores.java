/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class AltaBajaTrabajadores extends javax.swing.JFrame {

    DefaultTableModel modelo;
    Statement sent;
    
    Conexion cc = new Conexion();
    Connection conectar = cc.conexion();
    private int resultadoActualizado;
    
    int b;
    //String a =  String.valueOf(b);
    String a =  Integer.toString(b);
    /**
     * Creates new form AltaBajaTrabajadores
     */
    public AltaBajaTrabajadores() {
        initComponents();
        setLocationRelativeTo(null);
        Llenar();
    }
    
    void Llenar(){
        try{
            String[]titulos = {"Codigo","Usuario","Contraseña"};
            String sql = "SELECT * FROM login";
            modelo= new DefaultTableModel(null,titulos);
            sent = conectar.createStatement();
           ResultSet rs = sent.executeQuery(sql);
           
           String []fila  = new String[3];
           
           while(rs.next()){
               fila[0] = rs.getString("id");
               fila[1] = rs.getString("usuario");
               fila[2] = rs.getString("contraseña");
               
               modelo.addRow(fila);
           }
           tblDatos.setModel(modelo);
        }catch(Exception e){
            e.printStackTrace();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        psswContraseña = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Alta y baja de trabajadores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 11, -1, -1));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, 556, 96));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 168, 120, -1));
        getContentPane().add(psswContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 122, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, -1, -1));

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo azul.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 580, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        MenuAdministrador me = new MenuAdministrador();
        me.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        String contra = new String(psswContraseña.getPassword());
        
        try {
            PreparedStatement pst = conectar.prepareStatement("INSERT INTO login(usuario,contraseña) VALUES (?,?)");
            pst.setString(1, txtUsuario.getText());
            pst.setString(2, contra);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Datos agregados");
            Llenar();
          }catch(Exception e){
              System.out.print(e.getMessage());
          }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = tblDatos.getSelectedRow();
            String sql = "DELETE FROM login WHERE id="+tblDatos.getValueAt(fila, 0);
            sent = conectar.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                Llenar();
                JOptionPane.showMessageDialog(null, "Datos eliminados");
                 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        // TODO add your handling code here:
        if(evt.getButton()==1){
            int fila = tblDatos.getSelectedRow();
            
            try {
                
                String sql = "SELECT * FROM login WHERE id="+tblDatos.getValueAt(fila, 0);
                sent = conectar.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                while(rs.next()){
                    txtUsuario.setText(rs.getString(2));
                    psswContraseña.setText(rs.getString(3));
                }
            } catch (Exception e) {
            }
            
        }
    }//GEN-LAST:event_tblDatosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int fila = tblDatos.getSelectedRow();
            try {
        String consulta = "UPDATE login SET "
                + "usuario='"+txtUsuario.getText()+"',"
                + "contraseña='"+psswContraseña.getText()+"' "
                + "WHERE id='"+tblDatos.getValueAt(fila, 0)+"';";
        
        System.out.println(consulta);
        Statement sentencia = conectar.createStatement();
        resultadoActualizado = sentencia.executeUpdate(consulta);
        if (resultadoActualizado > 0) {
                System.out.println("Producto Actualizado");
         }
        Llenar();
        } catch (Exception e) {
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        
        char c = evt.getKeyChar();
        
        if((c<'a' || c>'z') && (c<'A' || c>'Z')) evt.consume();
        
    }//GEN-LAST:event_txtUsuarioKeyTyped

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
            java.util.logging.Logger.getLogger(AltaBajaTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaBajaTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaBajaTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaBajaTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaBajaTrabajadores().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField psswContraseña;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
