/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Vista;

import Client.ChatClientImpl;
import Client.ChatClientInterface;
import Server.ChatServerInterface;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;

/**
 *
 * @author raulbrun
 */
public class vPrincipal extends javax.swing.JPanel {

    private final ChatClientImpl usuario;
    private final VFrame ventana;
    private final ChatServerInterface servidor;
    private DefaultListModel modelo;
    /**
     * Creates new form vPrincipal
     * @param cliente
     * @param v
     * @param server
     */
    public vPrincipal(ChatClientImpl cliente, VFrame v, ChatServerInterface server) {
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
        jButton1 = new javax.swing.JButton();
        goTo_miCuenta = new javax.swing.JButton();
        conversacionActual = new javax.swing.JLabel();
        enviarArchivo = new javax.swing.JButton();

        setBackground(new java.awt.Color(224, 224, 224));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(821, 524));

        conversacion.setEditable(false);
        conversacion.setColumns(20);
        conversacion.setRows(5);
        conversacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane1.setViewportView(conversacion);

        textoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoEnviarActionPerformed(evt);
            }
        });

        botonEnviar.setBackground(new java.awt.Color(19, 128, 52));
        botonEnviar.setForeground(new java.awt.Color(254, 254, 254));
        botonEnviar.setText("Enviar");
        botonEnviar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        listaAmigos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        listaAmigos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(listaAmigos);

        goTo_petAmistad.setBackground(new java.awt.Color(214, 123, 44));
        goTo_petAmistad.setForeground(new java.awt.Color(254, 254, 254));
        goTo_petAmistad.setText("Peticiones Amistad");
        goTo_petAmistad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        goTo_petAmistad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goTo_petAmistadActionPerformed(evt);
            }
        });

        notificaciones.setFont(new java.awt.Font("Noto Sans", 3, 14)); // NOI18N
        notificaciones.setForeground(new java.awt.Color(37, 180, 61));

        goTo_login.setBackground(new java.awt.Color(175, 2, 29));
        goTo_login.setForeground(new java.awt.Color(254, 254, 254));
        goTo_login.setText("Cerrar Sesión");
        goTo_login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        goTo_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goTo_loginActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(91, 91, 91));
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText(">");
        jButton1.setActionCommand(">");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        goTo_miCuenta.setBackground(new java.awt.Color(254, 254, 254));
        goTo_miCuenta.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        goTo_miCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Vista/icono-perfil-azul.png"))); // NOI18N
        goTo_miCuenta.setText("Mi Cuenta");
        goTo_miCuenta.setBorder(null);
        goTo_miCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goTo_miCuentaActionPerformed(evt);
            }
        });

        conversacionActual.setFont(new java.awt.Font("Noto Sans", 3, 14)); // NOI18N
        conversacionActual.setForeground(new java.awt.Color(1, 16, 94));

        enviarArchivo.setBackground(new java.awt.Color(7, 56, 197));
        enviarArchivo.setForeground(new java.awt.Color(254, 254, 254));
        enviarArchivo.setText("Enviar Archivo");
        enviarArchivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        enviarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(goTo_petAmistad, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goTo_login, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(conversacionActual, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(goTo_miCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enviarArchivo)))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goTo_login, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(goTo_petAmistad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(notificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(goTo_miCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(conversacionActual, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(enviarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoEnviar)
                            .addComponent(botonEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void goTo_petAmistadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goTo_petAmistadActionPerformed
        // TODO add your handling code here:
        PeticionesAmistad pT = new PeticionesAmistad(this, ventana);
        ventana.setContentPane(pT);
        ventana.setVisible(true);
    }//GEN-LAST:event_goTo_petAmistadActionPerformed

    private void textoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoEnviarActionPerformed

    private void goTo_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goTo_loginActionPerformed
        try {
            // TODO add your handling code here:
            servidor.unRegister(usuario);
            Login vista = new Login(servidor, ventana);
            ventana.setContentPane(vista);
            ventana.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(vPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_goTo_loginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index;
        index = listaAmigos.getSelectedIndex();
        if(index >= 0){
            String nombre = (String)modelo.get(index);
            this.actualizaConversacion(nombre);
            conversacionActual.setText(nombre);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        // TODO add your handling code here:
        int index;
        index = listaAmigos.getSelectedIndex();
        if(index >= 0){
            String nombre = (String)modelo.get(index);
            String mensaje = textoEnviar.getText();
            try {
                usuario.enviarMensaje(nombre, mensaje);
                textoEnviar.setText("");
            } catch (RemoteException ex) {
                //Error al enviar
                Logger.getLogger(vPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botonEnviarActionPerformed

    private void goTo_miCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goTo_miCuentaActionPerformed
        // TODO add your handling code here:
        MiCuenta mC = new MiCuenta(this, ventana);
        ventana.setContentPane(mC);
        ventana.setVisible(true);
    }//GEN-LAST:event_goTo_miCuentaActionPerformed

    private void enviarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarArchivoActionPerformed
        /*Función encargada de enviar archivos entre clientes ~~ */
        if(!conversacionActual.getText().equals("")){
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(this);
            File archivo = chooser.getSelectedFile();
            if(archivo != null){
                Path ruta = Paths.get(archivo.getAbsolutePath());
                try {
                    byte[] data = Files.readAllBytes(ruta);
                    String destino = conversacionActual.getText();

                    usuario.getAmigos().get(destino).envioArchivo("("+usuario.getNombre()+"-"+ destino +")"+archivo.getName(), data, data.length);
                    usuario.enviarMensaje(destino, "ARCHIVO : " + archivo.getName());
                } catch (IOException ex) {
                    Logger.getLogger(vPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_enviarArchivoActionPerformed
    
    public void actualizaAmigos(){

            modelo = new DefaultListModel();
            Set<String> keySet = usuario.getAmigos().keySet();
            Iterator it = keySet.iterator();
            while(it.hasNext())
                modelo.addElement((String)it.next());
            
            listaAmigos.setModel(modelo);
        
    }
    
    public void actualizaConversacion(String nombre){
        String cadena = usuario.getConversacion(nombre);
        if(cadena != null)
            conversacion.setText(cadena);
        else
            conversacion.setText("--CHAT VACÍO--");
    }
    
    public void newLogin(String nombre){
        notificaciones.setText(nombre +" ha iniciado sesión");
        actualizaAmigos();
    }
    
    protected ChatClientImpl getUsuario(){
        return usuario;
    }
    protected ChatServerInterface getServidor(){
        return servidor;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnviar;
    private javax.swing.JTextArea conversacion;
    private javax.swing.JLabel conversacionActual;
    private javax.swing.JButton enviarArchivo;
    private javax.swing.JButton goTo_login;
    private javax.swing.JButton goTo_miCuenta;
    private javax.swing.JButton goTo_petAmistad;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaAmigos;
    private javax.swing.JLabel notificaciones;
    private javax.swing.JTextField textoEnviar;
    // End of variables declaration//GEN-END:variables
}
