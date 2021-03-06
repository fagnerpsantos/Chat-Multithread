/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import Enum.Acao;
import PalavraoException.Palavrao;
import bean.PackageMessage;
import java.awt.HeadlessException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import servicoClienteNet.ServicoCliente;

public class ChatClient extends javax.swing.JFrame {

    private PackageMessage msg = new PackageMessage();
    private Palavrao p = new Palavrao();
    private Socket sckt;
    private MulticastSocket multi;
    private ServicoCliente servico;
    

    /**
     * Creates new form Cliente
     * @param socketConexao
     * @param mensagem
     */
    public ChatClient(Socket socketConexao, PackageMessage mensagem, ServicoCliente servico, MulticastSocket multi) throws ClassNotFoundException, IOException {
        initComponents();
        this.sckt = socketConexao;
        this.msg = mensagem;
        this.servico = servico;
        this.multi = multi;
        nomeUsuarioLabel.setText(msg.getNome());
        new Thread(new ChatClient.ListenerSocket()).start();        
        this.setLocation(400, 200);
    }

    public void conectou() {
        this.jTextAreaTextoAEnviar.setEditable(true);
        this.btnEnviar.setEnabled(true);
        this.btnLimpar.setEnabled(true);

    }

    public void recebaTexto(PackageMessage mensagem) throws IOException, ClassNotFoundException {    
            this.jTextAreaSomenteLeitura.append(mensagem.getNome() + " diz: " + mensagem.getMensagem() + "\n");        

    }

    public void enviaOnlines(PackageMessage mensagem) throws ClassNotFoundException {
        mensagem.setAcao(Acao.ONLINE);
        servico.enviarMensagem(mensagem);
    }

    public void setaOnline(PackageMessage mensagem) {
        DefaultListModel modelo = new DefaultListModel();
        modelo.addElement("Todos");
        for (int i = 0; i < mensagem.getListaOnline().size(); i++) {
            if (!(mensagem.getListaOnline().get(i).equals(this.nomeUsuarioLabel.getText()))) {
                modelo.addElement(mensagem.getListaOnline().get(i));
            }
        }
        jListOnlines.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSomenteLeitura = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        btnEnviar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaTextoAEnviar = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListOnlines = new javax.swing.JList();
        nomeUsuarioLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextAreaSomenteLeitura.setEditable(false);
        jTextAreaSomenteLeitura.setColumns(20);
        jTextAreaSomenteLeitura.setRows(5);
        jScrollPane1.setViewportView(jTextAreaSomenteLeitura);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnEnviar.setText("Enviar");
        btnEnviar.setEnabled(false);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnLimpar.setText("limpar");
        btnLimpar.setToolTipText("irá limpar todo tipo de texto que foi escrito");
        btnLimpar.setEnabled(false);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jTextAreaTextoAEnviar.setEditable(false);
        jTextAreaTextoAEnviar.setColumns(20);
        jTextAreaTextoAEnviar.setRows(5);
        jScrollPane2.setViewportView(jTextAreaTextoAEnviar);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnLimpar))
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jListOnlines);

        nomeUsuarioLabel.setText("jLabel1");

        jLabel1.setText("Usuário online:");

        jButton1.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(nomeUsuarioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomeUsuarioLabel)
                        .addComponent(jLabel1))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        if (!jTextAreaTextoAEnviar.getText().equals("")) {
            if (!jListOnlines.isSelectionEmpty()) {                
                if(!p.verificaPalavrao(jTextAreaTextoAEnviar.getText())){
                //criou um novo BEAN
                msg = new PackageMessage();

                this.msg.setNome(nomeUsuarioLabel.getText());
                this.msg.setEnviarPara((String) jListOnlines.getSelectedValue());
                this.msg.setMensagem(this.jTextAreaTextoAEnviar.getText());
                this.msg.setAcao(Acao.ENVIAR);

                jTextAreaSomenteLeitura.append("Voce diz: " + msg.getMensagem() + "\n");
                jTextAreaTextoAEnviar.setText("");
                    try {                        
                        // envio o servidor para que ele trate de acordo a acao setada aqui (Acao.ENVIAR)
                        servico.enviarMensagem(this.msg);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Palavroes nao permitidos");
                    jTextAreaTextoAEnviar.setText("");
                }
                
            } else {
                JOptionPane.showMessageDialog(this, "Selecione alguem para enviar!");
            }
            
        }

    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        jTextAreaSomenteLeitura.setText("");
        jTextAreaTextoAEnviar.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    /*    public void encerrar() {
    ChatClient login = new ChatClient();
    login.setVisible(true);
    this.dispose();
    }*/
    
    public void receberMulti() throws IOException, ClassNotFoundException{
            
           try {
            
            byte[] data = new byte[4];
            //cria o datagrama pra receber a msg
            DatagramPacket packet = new DatagramPacket(data, data.length);
            this.multi.receive(packet);

            // now we know the length of the payload
            byte[] buffer = new byte[1024];
            packet = new DatagramPacket(buffer, buffer.length);
            this.multi.receive(packet);

            ByteArrayInputStream baos = new ByteArrayInputStream(buffer);
            ObjectInputStream oos = new ObjectInputStream(baos);
            PackageMessage c1 = (PackageMessage) oos.readObject();
            recebaTexto(c1);
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jListOnlines;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaSomenteLeitura;
    private javax.swing.JTextArea jTextAreaTextoAEnviar;
    private javax.swing.JLabel nomeUsuarioLabel;
    // End of variables declaration//GEN-END:variables

    public class ListenerSocket implements Runnable {

        private ObjectInputStream input;
        private ObjectInputStream input2;
        private ByteArrayInputStream binput;
        private PackageMessage mensagem;
        private ChatClient chat;
     
        public ListenerSocket() throws ClassNotFoundException, IOException {
            // vou inicializar o input com um INPUT STREAM que o servidor vai passar
            try {                
                this.input = new ObjectInputStream(sckt.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        @Override
        public void run() {
            try {
                // inicializo o BEAN MENSAGEM com o Objeto salvo no INPUT e rodo enquanto diferente de nulo o objeto
                while ((mensagem = (PackageMessage) input.readObject()) != null){
                    switch (mensagem.getAcao()) {
                        case CONECTAR:
                            if (mensagem.getConect().equals("ErroConect")) {
                                JOptionPane.showMessageDialog(null, "Nome ja existe! \ninforme um diferente");
                                
                                /*encerrar();*/
                            } else if (mensagem.getConect().equals("Conect")) {
                                JOptionPane.showMessageDialog(null, "Conexao Realizada");
                                conectou();
                                enviaOnlines(mensagem);
                            }   break;
                        case DESCONECTAR:
                            setaOnline(mensagem);
                            break;
                        case RECEBA:
                            System.out.println("chegou");
                            recebaTexto(mensagem);
                            //  setaOnline(mensagem);
                            break;
                        case ENVIAR_TODOS:
                            System.out.println("todo mundo");
                            receberMulti();
                        case ONLINE:
                            setaOnline(mensagem);
                            break;
                        default:
                            break;
                    }

                }

            } catch (IOException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeadlessException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
