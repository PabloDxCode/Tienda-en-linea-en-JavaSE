/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SplashScream.java
 *
 * Created on 08/07/2012, 02:29:17 AM
 */

package tienda;

import Clases.Hilo;
import Clases.Trasparencia;
import javax.swing.JFrame;

/**
 *
 * @author robert
 */
public class SplashScream extends javax.swing.JFrame implements Runnable {

    private Thread Hilo;
    /** Creates new form SplashScream */
    public SplashScream() {
        new Trasparencia().TransCompFrame(this);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 300, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Imagenes base/splash_screen.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 600, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     new Hilo(jProgressBar1).start();
    }//GEN-LAST:event_formWindowOpened
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScream().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
public void run(){

    try {
        this.setLocationRelativeTo(null);
        this.setLocation(400, 200);
        this.setVisible(true);
        Hilo.sleep(3100);
        this.dispose();
        
        Login lo=new Login();
        lo.setLocationRelativeTo(null);
        lo.setVisible(true);
        lo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    } catch (Exception e) {
    }
}
}
