
package whatsapp;

import java.util.ArrayList;
import java.util.List;

public class Menssagem extends Usuario{
    
     List<String> menssagem = new ArrayList<>(); 

    public Menssagem(String nome, String grupo) {
        super(nome, grupo);
    }
    
    
     @Override
    public void lerMenssagemDoGrupo(String nome, String nomeGrupo){
         for(int i =0; i < this.menssagem.size();i++){
             System.out.println(this.menssagem.get(i));
         
         }
    
    }

    @Override
    public String toString() {
        String res="";
        res+=super.toString();
        return res;
    }
    
     @Override
    public void publicarMenssagem(String nome, String conversa){
       
         this.menssagem.add(nome+": "+conversa);
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
