
package whatsapp;

import java.util.ArrayList;
import java.util.List;

public class GruposVetor {
    private String nomeGrupo;
     List<Usuario> usuarioCopia = new ArrayList<>(); 
     List<String> menssagen= new ArrayList<>(); 
     

    public GruposVetor(String nomeGrupo, Usuario pessoa) {
        this.nomeGrupo = nomeGrupo;
        this. usuarioCopia.add(pessoa);
    }
    
    public boolean naoRepetirMensmoNome(String nome){
       for(int i = 0; i < this.usuarioCopia.size();i++){
            if(this.usuarioCopia.get(i).getNome().equals(nome)){
                return true;
            
            }
       }
       return false;
    
    }
    
    public void lerMenssagem(){
        for(int i =0; i < this.menssagen.size();i++){
            System.out.println(this.menssagen.get(i));
         
        }
    
    }
    
    public void publicarMenssagem(String nome, String conversa){
       this.menssagen.add(nome+": "+conversa);
    
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    @Override
    public String toString() {
        return this.nomeGrupo;
    }
     
    
     
     
     
     
     
     
     
     
     
     
     
     
    
}
