/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splash;

import componentes.AWTUtilities;
import componentes.FadeEffect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Rojeru San
 */
public class SplashScreen extends javax.swing.JFrame {
    
    private Thread tiempo = null;
    
    private Timer t;
    private ActionListener al;

    /**
     * Creates new form Splash
     */
    public SplashScreen() {
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (progreso.getValue() < 100) {
                    progreso.setValue(progreso.getValue() + 7);                    
                    int valor = progreso.getValue();
                    if ((valor % 2) == 0){
                        lblImg.setIcon(new ImageIcon(getClass().getResource("/img/splash.png")));
                    }else{
                        lblImg.setIcon(new ImageIcon(getClass().getResource("/img/splash1.png")));
                    }
                } else {
                    t.stop();
                    mostrarVentana();
                }
            }
        };
        t = new Timer(500, al);
        initComponents();
        this.progreso.setVisible(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
        this.setLocationRelativeTo(null);
        AWTUtilities.setOpaque(this, false);
        FadeEffect.fadeInFrame(this, 50, 0.1f);
        t.start();
    }
    
    public void mostrarVentana() {
        FadeEffect.fadeOutFrameSplash(this, 50, 0.1f);
        new principal.Principal().setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progreso = new javax.swing.JProgressBar();
        lblImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/splash.png"))); // NOI18N
        lblImg.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        getContentPane().add(lblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblImg;
    private javax.swing.JProgressBar progreso;
    // End of variables declaration//GEN-END:variables
}