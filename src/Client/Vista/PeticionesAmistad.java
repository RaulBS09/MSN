/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Vista;

import Client.ChatClientImpl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author raulbrun
 */
public class PeticionesAmistad extends javax.swing.JPanel {
    private final vPrincipal vista;
    private VFrame ventana;
    private DefaultListModel modelo;
    private DefaultListModel modeloBuscar;
    /**
     * Creates new form PeticionesAmistad
     */
    public PeticionesAmistad(vPrincipal vista, VFrame cuadro) {
        initComponents();
        this.vista = vista;
        ventana = cuadro;
        not_nuevoAmigo.setVisible(false);
        not_envioPeticion.setVisible(false);
        modelo = new DefaultListModel();
        modeloBuscar = new DefaultListModel();
        try {
            ArrayList<String> peticiones = vista.getServidor().getPeticiones(vista.getUsuario().getNombre());
            for(String s : peticiones)
                modelo.addElement(s);
            listaPeticiones.setModel(modelo);
        } catch (RemoteException ex) {
            Logger.getLogger(PeticionesAmistad.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        listaPeticiones = new javax.swing.JList<>();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        botonRechazar = new javax.swing.JButton();
        not_nuevoAmigo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        peticionAmistad = new javax.swing.JTextField();
        botonEnviar = new javax.swing.JButton();
        not_envioPeticion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaBusca = new javax.swing.JList<>();
        botonBuscar = new javax.swing.JButton();

        jScrollPane1.setViewportView(listaPeticiones);

        back.setText("Atrás");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setText("Peticiones de amistad pendientes");

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonRechazar.setText("Rechazar");
        botonRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRechazarActionPerformed(evt);
            }
        });

        not_nuevoAmigo.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        not_nuevoAmigo.setForeground(new java.awt.Color(1, 197, 57));
        not_nuevoAmigo.setText("Ahora x es tu amigo");

        jLabel2.setText("Enviar petición de amistad a: ");

        botonEnviar.setText("Enviar");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        not_envioPeticion.setFont(new java.awt.Font("Noto Sans", 3, 14)); // NOI18N
        not_envioPeticion.setForeground(new java.awt.Color(65, 196, 70));
        not_envioPeticion.setText("Petición enviada correctamente");

        jScrollPane2.setViewportView(listaBusca);

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(not_nuevoAmigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonRechazar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(peticionAmistad, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar))
                    .addComponent(not_envioPeticion)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEnviar)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(not_envioPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(botonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonRechazar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(peticionAmistad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonBuscar))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addComponent(botonEnviar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(not_nuevoAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // TODO add your handling code here:
        int index;
        index = listaPeticiones.getSelectedIndex();
        if(index >= 0){
            String amigo = (String)modelo.get(index);
            try {
                vista.getServidor().aceptarPeticion(amigo, vista.getUsuario().getNombre());
                modelo.removeElementAt(index);
                listaPeticiones.setModel(modelo);
                not_nuevoAmigo.setText("Ahora " + amigo + " es tu nuevo amigo.");
                not_nuevoAmigo.setVisible(true);
                vista.actualizaAmigos();
            } catch (RemoteException ex) {
                //Error al enviar
                Logger.getLogger(vPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        try {
            // TODO add your handling code here:
            int index;
            index = listaBusca.getSelectedIndex();
            if(index >= 0){
                String amigo = (String)modeloBuscar.get(index);
                vista.getServidor().envioPeticionAmistad(vista.getUsuario().getNombre(), amigo);
                not_envioPeticion.setVisible(true);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(PeticionesAmistad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonEnviarActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        ventana.setContentPane(vista);
        ventana.setVisible(true);
        vista.actualizaAmigos();
    }//GEN-LAST:event_backActionPerformed

    private void botonRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRechazarActionPerformed
        // TODO add your handling code here:
        int index;
        index = listaPeticiones.getSelectedIndex();
        if(index >= 0){
            String amigo = (String)modelo.get(index);
            try {
                vista.getServidor().rechazarPeticion(amigo, vista.getUsuario().getNombre());
                modelo.removeElementAt(index);
                listaPeticiones.setModel(modelo);
            } catch (RemoteException ex) {
                //Error al enviar
                Logger.getLogger(vPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botonRechazarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        try {
            // TODO add your handling code here:
            ArrayList<String> resultado = vista.getServidor().buscarUsuarios(vista.getUsuario().getNombre(), peticionAmistad.getText());
            modeloBuscar.clear();
            
            for(String user : resultado) 
                modeloBuscar.addElement(user);
            
            listaBusca.setModel(modeloBuscar);
        } catch (RemoteException ex) {
            Logger.getLogger(PeticionesAmistad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_botonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JButton botonRechazar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaBusca;
    private javax.swing.JList<String> listaPeticiones;
    private javax.swing.JLabel not_envioPeticion;
    private javax.swing.JLabel not_nuevoAmigo;
    private javax.swing.JTextField peticionAmistad;
    // End of variables declaration//GEN-END:variables
}
