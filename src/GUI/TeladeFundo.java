/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Ncesar
 */
public class TeladeFundo extends javax.swing.JInternalFrame {

    /**
     * Creates new form TeladeFundo
     */
    public TeladeFundo() {
        super(null, false, false, false);
        initComponents();
        try {
            Fundo = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("FundoTela.png"),"FundoTela.png"));
        } catch (Exception e) {
        }      
    }
    
    public void paint(Graphics fundo){
           fundo.drawImage(Fundo, 0, 0, getWidth(), getHeight(), this);
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

protected static Image Fundo;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}