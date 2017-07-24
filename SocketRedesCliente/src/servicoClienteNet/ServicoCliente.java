/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicoClienteNet;

import bean.PackageMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ServicoCliente {
    private ObjectOutputStream output;
    private Socket cliente;
    
    private MulticastSocket multiCast;
    private String addr = "224.0.0.3";
    private int porta = 8888;
    ByteArrayOutputStream baos;
    ObjectOutputStream oos;
    
    public Socket conectar(PackageMessage mensagem){
   
        try {
           //multiCast = new MulticastSocket(porta);
           //multiCast.joinGroup(InetAddress.getByName(addr));                      
            //DatagramSocket cliente = new DatagramSocket(4444);
           //DatagramSocket serverSocket = new DatagramSocket(4445);
           cliente = new Socket("localhost",4444);
           output = new ObjectOutputStream(cliente.getOutputStream());
           
           
           mensagem.setSocket(cliente.toString());
           output.writeObject(mensagem);
           
           return cliente;
           
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao solicitar o servidor!");
        }
        
        return cliente;
    }
    
    public void enviarMensagemTodos(PackageMessage mensagem) throws SocketException, UnknownHostException, IOException{
        DatagramSocket serverSocket = new DatagramSocket();
        
        DatagramPacket msg = new DatagramPacket(mensagem.toString().getBytes(), mensagem.toString().getBytes().length, 
                InetAddress.getByName(addr), porta);
        
        serverSocket.send(msg);
        System.out.println(mensagem.toString());
    }
    
    public void enviarMensagem(PackageMessage mensagem) throws ClassNotFoundException{
        try {
            /*            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream (baos);
            oos.writeObject(mensagem);
            byte[] bytes = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream (bytes);
            ObjectInputStream ois = new ObjectInputStream (bais);
            PackageMessage meuObjeto = (PackageMessage) ois.readObject();
            System.out.println(meuObjeto.getEnviarPara());*/
            output.writeObject(mensagem);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null , "Erro ao Contatar Servidor!"); 
        }
    }
}
