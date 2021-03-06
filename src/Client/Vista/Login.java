/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Vista;

import Client.ChatClientImpl;
import Client.ChatClientInterface;
import Server.ChatServerInterface;
import java.rmi.RemoteException;

/**
 *
 * @author raulbrun
 */
public class Login extends javax.swing.JPanel {
    private final ChatServerInterface servidor;
    private final VFrame ventana;
    /**
     * Creates new form Login
     * @param server
     * @param v
     */
    public Login(ChatServerInterface server, VFrame v) {
        initComponents();
        servidor = server;
        ventana = v;
        mensajeError.setVisible(false);
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
        userName = new javax.swing.JTextField();
        passwd = new javax.swing.JPasswordField();
        titulo = new javax.swing.JLabel();
        subtitulo = new javax.swing.JLabel();
        goTo_vPrincipal = new javax.swing.JButton();
        mensajeError = new javax.swing.JLabel();
        botonRegistrarse = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel1.setText("Nombre de usuario");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel2.setText("Contraseña");

        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("DejaVu Sans Light", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(12, 72, 140));
        titulo.setText("Chat Distribuido");

        subtitulo.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        subtitulo.setForeground(new java.awt.Color(112, 151, 217));
        subtitulo.setText("Login");

        goTo_vPrincipal.setBackground(new java.awt.Color(1, 96, 124));
        goTo_vPrincipal.setForeground(new java.awt.Color(254, 254, 254));
        goTo_vPrincipal.setText("Iniciar Sesión");
        goTo_vPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        goTo_vPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goTo_vPrincipalActionPerformed(evt);
            }
        });

        mensajeError.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        mensajeError.setForeground(new java.awt.Color(248, 56, 56));
        mensajeError.setText("Nombre de usuario o contraseña inválidos");

        botonRegistrarse.setBackground(new java.awt.Color(37, 110, 36));
        botonRegistrarse.setForeground(new java.awt.Color(254, 254, 254));
        botonRegistrarse.setText("Registrarse");
        botonRegistrarse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(subtitulo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(mensajeError))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(passwd, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(goTo_vPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 264, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subtitulo)
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mensajeError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goTo_vPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void goTo_vPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goTo_vPrincipalActionPerformed
        try {
            ChatClientInterface cliente = new ChatClientImpl(userName.getText(), passwd.getText(), servidor);
            if(cliente.login()){
                vPrincipal vista = new vPrincipal((ChatClientImpl)cliente, ventana, servidor);
                cliente.setPanel(vista);
                ventana.setContentPane(vista);
                ventana.setVisible(true);
                
                ventana.setTitle("Chat Distribuido (" + userName.getText()+ ")");
            }else{
                mensajeError.setText("Nombre de usuario o contraseña inválidos");
                mensajeError.setVisible(true);
            }
        } catch (RemoteException ex) {
            
        }
    }//GEN-LAST:event_goTo_vPrincipalActionPerformed

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void botonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarseActionPerformed
        try {
            ChatClientInterface cliente = new ChatClientImpl(userName.getText(), passwd.getText(), servidor);
            if(servidor.registro(userName.getText(), passwd.getText(), cliente)){ //Si el registro va bien, se logea directamente al usuario
                vPrincipal vista = new vPrincipal((ChatClientImpl)cliente, ventana, servidor);
                cliente.setPanel(vista);
                ventana.setContentPane(vista);
                ventana.setVisible(true);
                ventana.setSize(vista.getSize());
                ventana.setTitle(userName.getText());
            }else{
                mensajeError.setText("Nombre de usuario no disponible");
                mensajeError.setVisible(true);
            }
        } catch (RemoteException ex) {
            System.out.println("RemoteException detectada al registrarse : " + ex.getMessage());
        }
    }//GEN-LAST:event_botonRegistrarseActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrarse;
    private javax.swing.JButton goTo_vPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel mensajeError;
    private javax.swing.JPasswordField passwd;
    private javax.swing.JLabel subtitulo;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
