/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicoClienteNet;

import bean.PackageMessage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricardo
 */
public class ServicoCliente {
    private ObjectOutputStream output;
    private Socket cliente;
        
    public Socket conectar(PackageMessage mensagem){
   
        try {
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
    
    public void enviarMensagem(PackageMessage mensagem){
        try {
            output.writeObject(mensagem);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null , "Erro ao Contatar Servidor!"); 
        }
    }
}
