/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import Enum.Acao;
import bean.PackageMessage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Servidor extends javax.swing.JFrame {

    private PackageMessage mensagem;
    private ServerSocket serverSocket;
    private Socket cliente;

    private ArrayList<String> listaNomes = new ArrayList<>();
    private ArrayList<ObjectOutputStream> listaOutput = new ArrayList<>();

    /**
     * Creates new form Servidor
     */
    public Servidor() {
        iniciarServidor();
        
    }

    public void iniciarServidor() {

        try {
            System.out.println("Online!");

            serverSocket = new ServerSocket(4444);
            

            new Thread(new aguardaConexao(serverSocket)).start();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void encerrarConexao() {

        try {            
            serverSocket.close();
        } catch (IOException ex) {
            System.out.println("erro ao fechar");
        }

    }

    private boolean conectar(PackageMessage mensagem, ObjectOutputStream output) {
        boolean saida = true;
        if (listaNomes.isEmpty() && listaOutput.isEmpty()) {
             
            this.listaNomes.add(mensagem.getNome());
            this.listaOutput.add(output);

            mensagem.setConect("Conect");
            mensagem.setListaOnline(listaNomes);
            enviarMensagem(mensagem, output);
            return saida;

        } else {
            for (int i = 0; i < listaNomes.size(); i++) {
                if (listaNomes.get(i).equals(mensagem.getNome())) {
                    saida = false;
                    mensagem.setConect("ErroConect");
                }
            }
        }
        if (saida && !(listaNomes.isEmpty())) {

            this.listaNomes.add(mensagem.getNome());
            this.listaOutput.add(output);

            mensagem.setConect("Conect");
        }

        mensagem.setListaOnline(listaNomes);
        enviarMensagem(mensagem, output);

        return saida;
    }

    private PackageMessage preencheTabela(PackageMessage mensagem) {

        mensagem.setPorta(cliente.getLocalPort());
        mensagem.setIp(cliente.getInetAddress().getHostAddress());
        mensagem.setData(Date.from(Instant.now(Clock.systemDefaultZone())));

        return mensagem;
    }


    private void enviarParaCliente(PackageMessage mensagem, ObjectOutputStream output) {
        mensagem.setAcao(Acao.RECEBA);
        for (int i = 0; i < listaNomes.size(); i++) {
            if (mensagem.getEnviarPara().equals(listaNomes.get(i))) {
                enviarMensagem(mensagem, listaOutput.get(i));
            }
        }

    }

    //Falta implementar
      private void enviarParaTodosCliente(PackageMessage mensagem, ObjectOutputStream output) {
        mensagem.setAcao(Acao.RECEBA);
        for (int i = 0; i < listaNomes.size(); i++) {
                enviarMensagem(mensagem, listaOutput.get(i));
            
        }

    }

    private void mandaOnlines(PackageMessage mensagem, ObjectOutputStream output) {
        mensagem.setAcao(Acao.ONLINE);

        for (int i = 0; i < listaNomes.size(); i++) {
            enviarMensagem(mensagem, listaOutput.get(i));
        }

    }

    private void enviarMensagem(PackageMessage mensagem, ObjectOutputStream output) {
        try {
            output.writeObject(mensagem);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar(PackageMessage mensagem, ObjectOutputStream output) {
        for (int i = 0; i < listaNomes.size(); i++) {
            if (mensagem.getNome().equals(listaNomes.get(i))) {
                listaNomes.remove(i);
                listaOutput.remove(i);
                encerrar(mensagem, listaOutput.get(i));
            }
        }
    }
    private void encerrar(PackageMessage mensagem,ObjectOutputStream output){
        try {
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    // THREAD para cuidar só da conexao e deixa a Frame livre
    private class aguardaConexao implements Runnable {

        private ServerSocket serverSocket;

        public aguardaConexao(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }

        @Override
        public void run() {


            while (true) {
                try {
                    cliente = serverSocket.accept();

                    new Thread(new ListenerSocket(cliente)).start();

                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // THREAD para cuidar somente da solicitacao de clientes
    private class ListenerSocket implements Runnable {

        private Socket cliente;
        private ObjectOutputStream output;
        private ObjectInputStream input;

        public ListenerSocket(Socket cliente) {
            this.cliente = cliente;
        }

        @Override
        public void run() {
            try {
                this.input = new ObjectInputStream(cliente.getInputStream());
                this.output = new ObjectOutputStream(cliente.getOutputStream());

                while ((mensagem = (PackageMessage) input.readObject()) != null) {

                    if (mensagem.getAcao().equals(Acao.CONECTAR)) {

                        if (conectar(mensagem, output)) {
                            mensagem = preencheTabela(mensagem);
                           mandaOnlines(mensagem, output);
                        }
                    } else if (mensagem.getAcao().equals(Acao.ENVIAR)) {
                        enviarParaCliente(mensagem, output);
                    } else if (mensagem.getAcao().equals(Acao.ONLINE)) {
                        mandaOnlines(mensagem, output);
                    } else if (mensagem.getAcao().equals(Acao.DESCONECTAR)) {
                        desconectar(mensagem, output);
                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
