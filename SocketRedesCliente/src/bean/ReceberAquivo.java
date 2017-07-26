package bean;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Nailton
 */
public class ReceberAquivo implements Runnable {

    private Socket socket;
    private int tamanho;
    private String arquivo, origem, diretorio;

    public ReceberAquivo(Socket socket, String diretorio, String arquivo, int tamanho, String origem) {
        this.socket = socket;
        this.origem = origem;
        this.diretorio = diretorio;
        this.arquivo = arquivo;
        this.tamanho = tamanho;
    }

    @Override
    public void run() {
        try {

            System.out.println("Baixando arquivo...");
            System.out.println("De: " + origem);
            try (FileOutputStream salvar = new FileOutputStream(diretorio)) {
                InputStream in = socket.getInputStream();
                byte[] buffer = new byte[tamanho];
                int count =0;
                while ((count = in.read(buffer)) != -1) {
                    salvar.write(buffer, 0, count);
                }
                salvar.flush();
            }
            JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Arquivo");
        }
    }

}
