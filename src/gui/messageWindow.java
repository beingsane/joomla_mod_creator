package gui;

import java.awt.Label;
import javax.swing.JTextPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * messageWindow.java
 *
 * Created on Jul 6, 2009, 5:09:40 PM
 */

/**
 *
 * @author Travis
 */
public class messageWindow extends javax.swing.JFrame {

    /** Creates new form messageWindow */
    public messageWindow() {
        initComponents();
    }

    public JTextPane getMessageText() {
        return messageText;
    }

    public void setMessageText(JTextPane messageText) {
        this.messageText = messageText;
    }


    public  void openWindow(){
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageText = new javax.swing.JTextPane();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        okButton.setLabel("Ok");
        okButton.setName("okButton"); // NOI18N
        okButton.addActionListener(formListener);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        messageText.setEditable(false);
        messageText.setEnabled(false);
        messageText.setName("messageText"); // NOI18N
        jScrollPane1.setViewportView(messageText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == okButton) {
                messageWindow.this.okButtonActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
       this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    /**
    * @param args the command line arguments
    */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane messageText;
    private java.awt.Button okButton;
    // End of variables declaration//GEN-END:variables

}