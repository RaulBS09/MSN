/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Vista;

import Client.ChatClientInterface;
import Server.ChatServerInterface;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author raulbrun
 */
public class vPrincipal extends javax.swing.JPanel {

    private final ChatClientInterface usuario;
    private final VFrame ventana;
    private final ChatServerInterface servidor;
    /**
     * Creates new form vPrincipal
     * @param cliente
     * @param v
     * @param server
     */
    public vPrincipal(ChatClientInterface cliente, VFrame v, ChatServerInterface server) {
        initComponents();
        usuario = cliente;
        ventana = v;
        servidor = server;
        this.actualizaAmigos();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        conversacion = new javax.swing.JTextArea();
        textoEnviar = new javax.swing.JTextField();
        botonEnviar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAmigos = new javax.swing.JList<>();
        goTo_petAmistad = new javax.swing.JButton();
        notificaciones = new javax.swing.JLabel();
        goTo_login = new javax.swing.JButton();

        setBackground(new java.awt.Color(224, 224, 224));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        conversacion.setEditable(false);
        conversacion.setColumns(20);
        conversacion.setRows(5);
        jScrollPane1.setViewportView(conversacion);

        textoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoEnviarActionPerformed(evt);
            }
        });

        botonEnviar.setText("Enviar");

        listaAmigos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        listaAmigos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(listaAmigos);

        goTo_petAmistad.setText("Peticiones Amistad");
        goTo_petAmistad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goTo_petAmistadActionPerformed(evt);
            }
        });

        notificaciones.setForeground(new java.awt.Color(68, 142, 241));
        notificaciones.setText(".:");

        goTo_login.setBackground(new java.awt.Color(192, 124, 124));
        goTo_login.setForeground(new java.awt.Color(151, 2, 2));
        goTo_login.setText("Cerrar Sesión");
        goTo_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goTo_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(goTo_petAmistad)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(notificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                    .addComponent(goTo_login))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEnviar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goTo_login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notificaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(goTo_petAmistad)
                        .addGap(27, 27, 27))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void goTo_petAmistadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goTo_petAmistadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goTo_petAmistadActionPerformed

    private void textoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoEnviarActionPerformed

    private void goTo_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goTo_loginActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_goTo_loginActionPerformed
    public void actualizaAmigos(){
        try{
            int i = 0;
            String amigos[] = new String[usuario.getAmigos().size()];
            for (Map.Entry e : usuario.getAmigos().entrySet()) {
                amigos[i] = (String)e.getKey();
                i++;
            }
            listaAmigos = new JList(amigos);
        }catch(RemoteException re){
            System.out.println(re);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnviar;
    private javax.swing.JTextArea conversacion;
    private javax.swing.JButton goTo_login;
    private javax.swing.JButton goTo_petAmistad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaAmigos;
    private javax.swing.JLabel notificaciones;
    private javax.swing.JTextField textoEnviar;
    // End of variables declaration//GEN-END:variables
}
