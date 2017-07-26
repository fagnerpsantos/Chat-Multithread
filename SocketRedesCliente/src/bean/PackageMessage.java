/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import Enum.Acao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Ricardo
 */
public class PackageMessage implements Serializable {
    
    private String ip;
    private String nome;
    private String enviarPara;
    private Date data;
    private int porta;
    private String mensagem;
    private ArrayList<String> listaOnline = new ArrayList<>();
    private Acao acao;
    private String socket;
    private String Conect;
    

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnviar() {
        return enviarPara;
    }

    public void setEnviar(String enviar) {
        this.enviarPara = enviar;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public ArrayList<String> getListaOnline() {
        return listaOnline;
    }

    public void setListaOnline(ArrayList<String> listaOnline) {
        this.listaOnline = listaOnline;
    }   

    public String getEnviarPara() {
        return enviarPara;
    }

    public void setEnviarPara(String enviarPara) {
        this.enviarPara = enviarPara;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getConect() {
        return Conect;
    }

    public void setConect(String Conect) {
        this.Conect = Conect;
    }
    
    
    
}
