/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicoClienteNet;

import bean.PackageMessage;
import static com.sun.management.jmx.Trace.send;
import frame.ChatClient;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private DatagramSocket socket;
    private InetAddress ip;
    private Thread send;
    
    public Socket conectar(PackageMessage mensagem){
   
        try {
           cliente = new Socket("localhost",4444);
           output = new ObjectOutputStream(cliente.getOutputStream());
           
           mensagem.setSocket(cliente.toString());
           output.writeObject(mensagem);           
           
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao solicitar o servidor!");
        }
        
        return cliente;
    }
    
    public DatagramSocket conectarUdp() throws SocketException, UnknownHostException, IOException{            
        socket = new DatagramSocket(4445);
	ip = InetAddress.getByName("localhost");
        byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
        socket.send(packet);
        return socket;
    }
    
    public MulticastSocket conectarMulticast() throws IOException{
            this.multiCast = new MulticastSocket(12347);
           //endereço do grupo que se deseja associar
           InetAddress grp = InetAddress.getByName("239.0.0.1");
           //associando-se ao grupo
           multiCast.joinGroup(grp);
           System.out.println("entrou no multicast");
           
           return multiCast;
           
    }
    
    public void receberMulticast() throws IOException{
            MulticastSocket mcs = new MulticastSocket(12347);
           //endereço do grupo que se deseja associar
           InetAddress grp = InetAddress.getByName("239.0.0.1");
           
           mcs.joinGroup(grp);

            //cria o datagrama pra receber a msg
            DatagramPacket answer = new DatagramPacket(new byte[1024], 1024);

            //Recebe Datagrama
            mcs.receive(answer);
            
            String convert = new String(answer.getData(), "UTF-8");
            String msg = convert;
            
            System.out.println(msg);
    }
    
    public void enviarMensagemTodos(PackageMessage mensagem) throws SocketException, UnknownHostException, IOException, ClassNotFoundException{
            InetAddress group = InetAddress.getByName("239.0.0.1");
            MulticastSocket s = new MulticastSocket();
        
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream (baos);
            oos.writeObject(mensagem);
            byte[] bytes = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream (bytes);
            ObjectInputStream ois = new ObjectInputStream (bais);
            PackageMessage meuObjeto = (PackageMessage) ois.readObject();


            byte[] buffer = mensagem.toString().getBytes();

            DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, group, 12347);
            s.send(sendPacket);
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
