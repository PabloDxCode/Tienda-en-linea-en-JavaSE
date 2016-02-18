/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.awt.Color;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class JFProductos extends javax.swing.JFrame {

    DefaultTableModel valoresTabla;
    Conexion cc = new Conexion();
    Connection conectar = cc.conexion();
    private Statement sent;

    /**
     * Creates new form Productos
     */
    public JFProductos() {
        initComponents();
        btn_modificar.setEnabled(false);
        btn_guardar.setEnabled(false);
        btnInsetar.setEnabled(false);

        panelIzq.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 12, Color.black), "Datos", TitledBorder.LEFT, TitledBorder.TOP));

        panelDer.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black), "Consulta", TitledBorder.LEFT, TitledBorder.TOP));

    }
    
    void Llenar(){
        try{
            String[]titulos = {"ID","Articulo","Categoria","Precio","Imagen"};
            String sql = "SELECT * FROM productos";
            valoresTabla= new DefaultTableModel(null,titulos);
            sent = conectar.createStatement();
           ResultSet rs = sent.executeQuery(sql);
           
           String []fila  = new String[5];
           
           while(rs.next()){
               fila[0] = rs.getString("codigo");
               fila[1] = rs.getString("articulo");
               fila[2] = rs.getString("Categoria");
               fila[3] = rs.getString("precio");
               fila[4] = rs.getString("imagen");
               
               valoresTabla.addRow(fila);
           }
           tabla_datos.setModel(valoresTabla);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    public void listaProductos() {
        try {
            //ConectaDB c = new ConectaDB();
            ResultSet resultadoProductos;
            ResultSetMetaData datosConsulta;

            String consulta = "SELECT codigo, articulo, Categoria, precio, imagen FROM productos";
            Statement sentencia = conectar.createStatement();
            resultadoProductos = sentencia.executeQuery(consulta);

            datosConsulta = resultadoProductos.getMetaData();
            Object[] filasConsulta = new Object[datosConsulta.getColumnCount()];
            valoresTabla = (DefaultTableModel) tabla_datos.getModel();

            while (resultadoProductos.next()) {
                for (int i = 0; i < filasConsulta.length; i++) {
                    filasConsulta[i] = resultadoProductos.getObject(i + 1);
                }
                valoresTabla.addRow(filasConsulta);
            }
            tabla_datos.setModel(valoresTabla);
        } catch (Exception e) {
            System.out.println("No consulta productos");
        }
    }

    public void productoSeleccionado(int idProducto) {

        try {

            //ConectaDB c = new ConectaDB();
            ResultSet resultadoSeleccionado;
            String pathImg = "";
            String consulta = "SELECT codigo, articulo, Categoria, precio, imagen FROM productos WHERE codigo ='" + idProducto + "';";
            Statement sentencia = conectar.createStatement();
            resultadoSeleccionado = sentencia.executeQuery(consulta);

            while (resultadoSeleccionado.next()) {
                txtID.setText(resultadoSeleccionado.getString(1));
                txtArticulo.setText(resultadoSeleccionado.getString(2));
                txtCategoria.setText(resultadoSeleccionado.getString(3));
                txtPrecio.setText(resultadoSeleccionado.getString(4));

                pathImg = resultadoSeleccionado.getString(5);
                txtImagen.setText(pathImg);
                System.out.println(pathImg);

                lb_img.setIcon(new ImageIcon(getClass().getResource(txtImagen.getText())));
            }

        } catch (Exception e) {
            System.out.println("No selecciona producto");
        }

    }

    public void actualizarProducto(int idProductoActual) {
        try {
            //ConectaDB c = new ConectaDB();
            int resultadoActualizado;

            String consulta = "UPDATE productos SET "
                    + "articulo ='" + txtArticulo.getText() + "', "
                    + "Categoria ='" + txtCategoria.getText() + "', "
                    + "precio ='" + txtPrecio.getText() + "', "
                    + "imagen ='" + txtImagen.getText() + "' "
                    + "WHERE codigo='" + idProductoActual + "';";
            System.out.println(consulta);
            Statement sentencia = conectar.createStatement();
            resultadoActualizado = sentencia.executeUpdate(consulta);

            if (resultadoActualizado > 0) {
                System.out.println("Producto Actualizado");
            }

        } catch (Exception e) {
            System.out.println("No actualiza producto");
        }
    }

    public void limpiarTabla() {
        for (int i = valoresTabla.getRowCount() - 1; i >= 0; i--) {
            valoresTabla.removeRow(i);
        }
        tabla_datos.setModel(valoresTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        panelIzq = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        lb_id = new javax.swing.JLabel();
        lb_categoria = new javax.swing.JLabel();
        lb_nombre = new javax.swing.JLabel();
        lb_precio = new javax.swing.JLabel();
        lb_imagen = new javax.swing.JLabel();
        txtArticulo = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtImagen = new javax.swing.JTextField();
        lb_img = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnInsetar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelDer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_datos = new javax.swing.JTable();
        btn_consultar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        panelIzq.setBackground(new java.awt.Color(204, 204, 255));
        panelIzq.setForeground(new java.awt.Color(255, 255, 255));
        panelIzq.setLayout(null);

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/database-check-icon.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.setToolTipText("Boton Guardar");
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        panelIzq.add(btn_guardar);
        btn_guardar.setBounds(70, 50, 110, 40);

        lb_id.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lb_id.setText("ID Producto:");
        panelIzq.add(lb_id);
        lb_id.setBounds(64, 130, 69, 15);

        lb_categoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lb_categoria.setText("Articulo:");
        panelIzq.add(lb_categoria);
        lb_categoria.setBounds(64, 168, 47, 15);

        lb_nombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lb_nombre.setText("Categoria:");
        panelIzq.add(lb_nombre);
        lb_nombre.setBounds(64, 208, 58, 15);

        lb_precio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lb_precio.setText("Precio:");
        panelIzq.add(lb_precio);
        lb_precio.setBounds(64, 253, 40, 15);

        lb_imagen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_imagen.setText("Imagen:");
        panelIzq.add(lb_imagen);
        lb_imagen.setBounds(64, 299, 50, 15);

        txtArticulo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        panelIzq.add(txtArticulo);
        txtArticulo.setBounds(151, 166, 256, 20);
        panelIzq.add(txtCategoria);
        txtCategoria.setBounds(151, 206, 256, 20);
        panelIzq.add(txtPrecio);
        txtPrecio.setBounds(151, 251, 256, 20);
        panelIzq.add(txtImagen);
        txtImagen.setBounds(151, 297, 256, 20);

        lb_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelIzq.add(lb_img);
        lb_img.setBounds(230, 380, 90, 90);

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Regresar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setToolTipText("Boton Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panelIzq.add(btnRegresar);
        btnRegresar.setBounds(340, 50, 110, 40);

        txtID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        panelIzq.add(txtID);
        txtID.setBounds(151, 128, 99, 20);

        btnInsetar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/insert.png"))); // NOI18N
        btnInsetar.setText("Insertar");
        btnInsetar.setToolTipText("Boton Insertar");
        btnInsetar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsetarActionPerformed(evt);
            }
        });
        panelIzq.add(btnInsetar);
        btnInsetar.setBounds(200, 50, 120, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/marco.jpg"))); // NOI18N
        panelIzq.add(jLabel1);
        jLabel1.setBounds(180, 340, 180, 170);

        getContentPane().add(panelIzq);

        panelDer.setBackground(new java.awt.Color(204, 204, 255));

        tabla_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Articulo", "Categoria", "Precio", "Imagen"
            }
        ));
        tabla_datos.setToolTipText("De click sobre algun producto para modificar");
        tabla_datos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_datos);

        btn_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/database_1_32.png"))); // NOI18N
        btn_consultar.setText("Consultar");
        btn_consultar.setToolTipText("Boton Consultar");
        btn_consultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/change.png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setToolTipText("Boton Modificar");
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/database-delete-icon.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Boton Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDerLayout = new javax.swing.GroupLayout(panelDer);
        panelDer.setLayout(panelDerLayout);
        panelDerLayout.setHorizontalGroup(
            panelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerLayout.createSequentialGroup()
                .addGroup(panelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDerLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btn_consultar)
                        .addGap(21, 21, 21)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelDerLayout.setVerticalGroup(
            panelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_consultar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        getContentPane().add(panelDer);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
        // TODO add your handling code here:
        listaProductos();
        btn_modificar.setEnabled(true);
    }//GEN-LAST:event_btn_consultarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        int num = tabla_datos.getSelectedRow();
        
        int valor = 0;
        String val = tabla_datos.getModel().getValueAt(num, 0).toString();
        txtID.setText("" + val);
        int valN = Integer.parseInt(val);
        
        
        System.out.println(""+valN);
        if(valN<1){
            JOptionPane.showMessageDialog(null, "Porfavor seleccione alguna opcion de la tabla","Articulo no seleccionado",JOptionPane.ERROR_MESSAGE);
        }else{
        
            
       productoSeleccionado(valN);
        
        btn_guardar.setEnabled(true);
        btnInsetar.setEnabled(true);
        }

    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        
        if(txtArticulo.getText().equals("") || txtCategoria.getText().equals("") || txtID.getText().equals("") || txtImagen.getText().equals("") || txtPrecio.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Porfavor confirme que los campos esten llenos","Campos vacios",JOptionPane.ERROR_MESSAGE);
        }else{
        limpiarTabla();
        int numM = Integer.parseInt(txtID.getText());
        
        actualizarProducto(numM);
        
        listaProductos();
        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        MenuAdministrador me = new MenuAdministrador();
        me.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tabla_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_datosMouseClicked
        // TODO add your handling code here:
        if(evt.getButton()==1){
            int fila = tabla_datos.getSelectedRow();
            
            try {
                
                String sql = "SELECT * FROM productos WHERE codigo="+tabla_datos.getValueAt(fila, 0);
                sent = conectar.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_tabla_datosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = tabla_datos.getSelectedRow();
            String sql = "DELETE FROM productos WHERE codigo="+tabla_datos.getValueAt(fila, 0);
            sent = conectar.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                Llenar();
                //listaProductos();
                JOptionPane.showMessageDialog(null, "Datos eliminados","Datos Borrados",JOptionPane.INFORMATION_MESSAGE);
                 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnInsetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsetarActionPerformed
        // TODO add your handling code here:
        
        if(txtArticulo.getText().equals("") || txtCategoria.getText().equals("") || txtID.getText().equals("") || txtImagen.getText().equals("") || txtPrecio.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Porfavor confirme que los campos esten llenos","Campos vacios",JOptionPane.ERROR_MESSAGE);
        }else{
        
        try {
            PreparedStatement pst = conectar.prepareStatement("INSERT INTO productos(codigo, articulo, Categoria, precio, imagen) VALUES (?,?,?,?,?)");
            pst.setString(1, txtID.getText());
            pst.setString(2, txtArticulo.getText());
            pst.setString(3, txtCategoria.getText());
            pst.setString(4, txtPrecio.getText());
            pst.setString(5, txtImagen.getText());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Datos agregados");
            Llenar();
            //listaProductos();
          }catch(Exception e){
              System.out.print(e.getMessage());
          }
        }
    }//GEN-LAST:event_btnInsetarActionPerformed

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
            java.util.logging.Logger.getLogger(JFProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFProductos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsetar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_categoria;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_imagen;
    private javax.swing.JLabel lb_img;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JLabel lb_precio;
    private javax.swing.JPanel panelDer;
    private javax.swing.JPanel panelIzq;
    private javax.swing.JTable tabla_datos;
    private javax.swing.JTextField txtArticulo;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtImagen;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
