
package whatsapp;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private String nome;
  List<GruposVetor> grupo = new ArrayList<>(); 
  

    public Usuario(String nome) {
        this.nome = nome;
    }
    
    public void apagarGrupos(String nomegrupo){
      for(int i = 0; i < this.grupo.size();i++){
           if(this.grupo.get(i).getNomeGrupo().equals(nomegrupo)){
              this.grupo.remove(i);

           }
      }
      

   } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return   this.nome ;
    }
    
    
  
    
    
    
    
    
  
}
