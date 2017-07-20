/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PalavraoException;

/**
 *
 * @author Ricardo
 */
public class Palavrao {
    
    public boolean verificaPalavrao(String palavrao){
        boolean saida=false;
        palavrao = palavrao.toLowerCase();
        if (palavrao.contains("porra") || palavrao.contains("caralho") || palavrao.contains("buceta") || palavrao.contains("nudes") ||
                palavrao.contains("foda") || palavrao.contains("puta")){
            return saida =true;
        }
        
        return saida;
    }
    
}
