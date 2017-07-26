/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Nailton
 */
public class EnviarArquivo implements Runnable {

    private Socket socket;
    private String diretorio;
    private DataOutputStream output;

    public EnviarArquivo(String ip, int porta, String diretorio) {
        this.diretorio = diretorio;        
        try {
            socket = new Socket(ip, porta);
            System.out.println("Pronto para enviar o arquivo");
        } catch (IOException ex) {
            Logger.getLogger(EnviarArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Enviando Arquivo..!");
            output = new DataOutputStream(socket.getOutputStream());
            File arquivo = new File(diretorio);
            int tamanho = (int) arquivo.length();
            System.out.println("DE: ");
            System.out.println("Para: ");
            System.out.println("Arquivo: "+arquivo.getName());
            InputStream in = new FileInputStream(arquivo);
            OutputStream out = socket.getOutputStream();

            BufferedInputStream lerArquivo = new BufferedInputStream(in);
            /** cria um arquivo temp **/
            byte[] buffer = new byte[tamanho];
            int count = 0;
            while((count = lerArquivo.read(buffer)) > 0){
                out.write(buffer, 0, count);
            }
            
            JOptionPane.showMessageDialog(null, "Arquivo Enviado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            /* Close Streams */
            out.flush();
            out.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao enviar arquivo", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

}


