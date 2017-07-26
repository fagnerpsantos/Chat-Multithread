package frame;

import Enum.Acao;
import PalavraoException.Palavrao;
import bean.PackageMessage;
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import servicoClienteNet.ServicoCliente;

public class ClienteLogin extends javax.swing.JFrame {

    private PackageMessage mensagem = new PackageMessage();
    private Palavrao p = new Palavrao();
    private Socket socket;
    private Socket socketcompArquivos;
    private ServicoCliente servico = new ServicoCliente();

    TelaEnviarArquivo t = new TelaEnviarArquivo();

    public ClienteLogin() {
        initComponents();
        this.setLocation(400, 200);

    }

    public void conectou() {
        this.btnSair.setEnabled(true);
        this.btnConectar.setEnabled(false);
        this.jTextFieldNome.setEditable(false);
        this.jTextAreaTextoAEnviar.setEditable(true);
        this.btnEnviar.setEnabled(true);
        this.btnLimpar.setEnabled(true);
        this.jButton_EnviarArquivo.setEnabled(true);
    }

    public void recebaTexto(PackageMessage mensagem) {

        this.jTextAreaSomenteLeitura.append(mensagem.getNome() + " diz: " + mensagem.getMensagem() + "\n");
    }

    public void enviaOnlines(PackageMessage mensagem) {
        mensagem.setAcao(Acao.ONLINE);
        servico.enviarMensagem(mensagem);
    }

    public void setaOnline(PackageMessage mensagem) {
        DefaultListModel modelo = new DefaultListModel();
        for (int i = 0; i < mensagem.getListaOnline().size(); i++) {
            if (!(mensagem.getListaOnline().get(i).equals(this.jTextFieldNome.getText()))) {
                modelo.addElement(mensagem.getListaOnline().get(i));
                System.out.println(mensagem.getListaOnline().get(i));
            }
        }
        jListOnlines.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListOnlines = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane_Chat = new javax.swing.JScrollPane();
        jTextAreaSomenteLeitura = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        btnEnviar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaTextoAEnviar = new javax.swing.JTextArea();
        jButton_EnviarArquivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Login"));

        jLabelNome.setText("Nome: ");

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.setEnabled(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextFieldNome)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelNome)
                .addGap(5, 5, 5)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConectar)
                    .addComponent(btnSair)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane3.setViewportView(jListOnlines);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextAreaSomenteLeitura.setEditable(false);
        jTextAreaSomenteLeitura.setColumns(20);
        jTextAreaSomenteLeitura.setRows(5);
        jScrollPane_Chat.setViewportView(jTextAreaSomenteLeitura);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_Chat)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_Chat)
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

        jButton_EnviarArquivo.setText("Enviar Arquivo");
        jButton_EnviarArquivo.setEnabled(false);
        jButton_EnviarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EnviarArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_EnviarArquivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnLimpar)
                    .addComponent(jButton_EnviarArquivo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        //cria um novo BEAN 
        mensagem = new PackageMessage();
        if (!jTextFieldNome.getText().equals("") && !jTextFieldNome.getText().equals("Todos")) {

            //setando o BEAN
            this.mensagem.setNome(this.jTextFieldNome.getText());
            this.mensagem.setAcao(Acao.CONECTAR);
            //aqui eu informo ao SERVER SOCKET para CONECTAR e manda o BEAN MENSAGEM 
            this.socket = servico.conectar(mensagem);
            //inicializo a Thread Listener para esperar a resposta do servidor

            new Thread(new ListenerSocket()).start();

        } else {
            JOptionPane.showMessageDialog(this, "Digite o seu nome");
        }
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        if (!jTextAreaTextoAEnviar.getText().equals("")) {
            if (!jListOnlines.isSelectionEmpty()) {
                if (!p.verificaPalavrao(jTextAreaTextoAEnviar.getText())) {
                    //criou um novo BEAN
                    mensagem = new PackageMessage();

                    this.mensagem.setNome(jTextFieldNome.getText());
                    this.mensagem.setEnviarPara((String) jListOnlines.getSelectedValue());
                    this.mensagem.setMensagem(this.jTextAreaTextoAEnviar.getText());
                    this.mensagem.setAcao(Acao.ENVIAR);

                    jTextAreaSomenteLeitura.append("Voce diz: " + mensagem.getMensagem() + "\n");
                    jTextAreaTextoAEnviar.setText("");
                    // envio o servidor para que ele trate de acordo a acao setada aqui (Acao.ENVIAR)
                    servico.enviarMensagem(this.mensagem);
                } else {
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

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

        this.jTextFieldNome.setEditable(true);
        this.btnConectar.setEnabled(true);
        this.btnLimpar.setEnabled(false);
        this.btnEnviar.setEnabled(false);
        this.jTextAreaTextoAEnviar.setEditable(false);
        mensagem = new PackageMessage();

        this.mensagem.setNome(jTextFieldNome.getText());
        this.mensagem.setEnviarPara((String) jListOnlines.getSelectedValue());
        this.mensagem.setMensagem(this.jTextAreaTextoAEnviar.getText());
        this.mensagem.setAcao(Acao.DESCONECTAR);

        jTextAreaTextoAEnviar.setText("");
        this.jTextFieldNome.setText("");

        servico.enviarMensagem(mensagem);

    }//GEN-LAST:event_btnSairActionPerformed

    private void jButton_EnviarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnviarArquivoActionPerformed
        ///// ver se isso aqui vai funcionar
        if (!jListOnlines.isSelectionEmpty()) {
            mensagem = new PackageMessage();
            ArrayList<String> lista = new ArrayList<>();

            this.mensagem.setNome(jTextFieldNome.getText());
            this.mensagem.setEnviarPara((String) jListOnlines.getSelectedValue());
            this.mensagem.setMensagem("ENVIA_ARQUIVO");
            this.mensagem.setAcao(Acao.ARQUIVO);
            
            this.mensagem.setListaOnline(lista);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione alguem para enviar!");
        }
        t.setVisible(true);
        t.envioDeArquivo(mensagem);
    }//GEN-LAST:event_jButton_EnviarArquivoActionPerformed

    public void encerrar() {
        ClienteLogin login = new ClienteLogin();
        login.setVisible(true);
        this.dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButton_EnviarArquivo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JList jListOnlines;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane_Chat;
    private javax.swing.JTextArea jTextAreaSomenteLeitura;
    private javax.swing.JTextArea jTextAreaTextoAEnviar;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

    private class ListenerSocket implements Runnable {

        private ObjectInputStream input;
        private PackageMessage mensagem;

        public ListenerSocket() {
            // vou inicializar o input com um INPUT STREAM que o servidor vai passar
            try {
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ClienteLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        @Override
        public void run() {
            try {
                // inicializo o BEAN MENSAGEM com o Objeto salvo no INPUT e rodo enquanto diferente de nulo o objeto
                while ((mensagem = (PackageMessage) input.readObject()) != null) {
                    if (mensagem.getAcao().equals(Acao.CONECTAR)) {

                        if (mensagem.getConect().equals("ErroConect")) {
                            JOptionPane.showMessageDialog(null, "Nome ja existe! \ninforme um diferente");
                            encerrar();
                        } else if (mensagem.getConect().equals("Conect")) {
                            JOptionPane.showMessageDialog(null, "Conexao Realizada");
                            conectou();
                            enviaOnlines(mensagem);
                        }

                    } else if (mensagem.getAcao().equals(Acao.DESCONECTAR)) {
                        setaOnline(mensagem);

                    } else if (mensagem.getAcao().equals(Acao.RECEBA)) {
                        recebaTexto(mensagem);
                        //  setaOnline(mensagem);
                    } else if (mensagem.getAcao().equals(Acao.ONLINE)) {
                        setaOnline(mensagem);

                    }

                }

            } catch (IOException ex) {
                Logger.getLogger(ClienteLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeadlessException ex) {
                Logger.getLogger(ClienteLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}