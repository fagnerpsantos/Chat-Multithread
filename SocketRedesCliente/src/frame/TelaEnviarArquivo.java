package frame;
import bean.PackageMessage;
import java.io.File;
import javax.swing.JFileChooser;
/**
 *
 * @author Nailton
 */
public class TelaEnviarArquivo extends javax.swing.JFrame {
    private PackageMessage mensagem;
    
    public TelaEnviarArquivo() {
        initComponents();
    }
    public void envioDeArquivo(PackageMessage mensagem){
        this.mensagem = mensagem;
        /// prencher o combobox com tos onlines ou pegar so o que tiver selecionado???
        for(int i = 0;i<mensagem.getListaOnline().size(); i++ ){  
               jComboBox_Para.addItem(mensagem.getListaOnline().get(i));  
           }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox_Para = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Arquivo = new javax.swing.JTextField();
        jButton_SelecionarArquivo = new javax.swing.JButton();
        jButton_Enviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox_Para.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Enviar Arquivo");

        jLabel2.setText("Arquivo:");

        jLabel3.setText("Para:");

        jButton_SelecionarArquivo.setText("...");
        jButton_SelecionarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SelecionarArquivoActionPerformed(evt);
            }
        });

        jButton_Enviar.setText("Enviar");
        jButton_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_Arquivo)
                            .addComponent(jComboBox_Para, 0, 125, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_SelecionarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jButton_Enviar)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton_SelecionarArquivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox_Para, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton_Enviar)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SelecionarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SelecionarArquivoActionPerformed
try {
            JFileChooser abrir = new JFileChooser();
            abrir.setCurrentDirectory(new File("C:/Users/"));
            abrir.setDialogTitle("Escolha uma Pasta...");
            abrir.setFileSelectionMode(JFileChooser.FILES_ONLY);
            abrir.showOpenDialog(this);
            File diretorio = abrir.getSelectedFile();
            jTextField_Arquivo.setText(diretorio.getAbsolutePath());
            //implementar a parte que chama a class enviar arquivo
        } catch (Exception e) {
            System.out.println("errrooo..");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SelecionarArquivoActionPerformed

    private void jButton_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnviarActionPerformed
        
    }//GEN-LAST:event_jButton_EnviarActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEnviarArquivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Enviar;
    private javax.swing.JButton jButton_SelecionarArquivo;
    private javax.swing.JComboBox<String> jComboBox_Para;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField_Arquivo;
    // End of variables declaration//GEN-END:variables

    
}

