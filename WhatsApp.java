package whatsapp;

import java.util.List;
import java.util.ArrayList;

public class WhatsApp {
  List<Usuario> usu = new ArrayList<>(); 
  List<List<Usuario>> gru = new ArrayList<>();
  
  
    //adisiona usuario 
    public boolean adiciona(String nome){
         if(usuarioExiste(nome)){    
              return false;
         }
           Usuario p = new Usuario(nome ,null);
           this.usu.add(p);
           return true;
      }
    
    //busca usuario se existe
    public boolean usuarioExiste(String nome){
         for(int i = 0; i < this.usu.size();i++){
            if(this.usu.get(i).getNome().equals(nome)){ 
                return true;

            } 
      }
      return false;
    }
    
    //busca grupos repetidos
    public boolean gruporRepetido(String nomeGrupo){
       int x = 0;
        for(int i = 0; i < this.gru.size();i++){
            for( ; x < 1;x++){
                 if(this.gru.get(i).get(0).getGrupo().equals(nomeGrupo)){
                     return true;
                 
                 
                 }
        }//vetor x
            x=0;
                 
        }//vetor i
        return false;
        
    }//
  
    public void show(){
        System.out.print("[ ");
        for(int i =0; i < this.usu.size();i++){
            System.out.print(this.usu.get(i).getNome()+" ");


        }
        System.out.println("]");

    }//
  
    //criar grupo nome do usuario e nome do grupo
    public boolean  criarChet(String nome,String nomeGrupo){

              if(gruporRepetido(nomeGrupo)){
                    System.out.println("  fail: chat "+nomeGrupo+" ja existe"); 
                    return false;
                 }

              if(usuarioExiste(nome)){
                  List<Usuario> m = new ArrayList<>();
                  Menssagem vetor = new Menssagem("",nomeGrupo);
                  m.add(vetor);
                  Usuario p1 = new Usuario(nome,nomeGrupo);
                  m.add(p1);
                  this.gru.add(m);
                  return true;
              }
              System.out.println(" usuario nao existe");
              return false;

        }//
      
      
    //usuaruo saber quais grupos pertence
    public String ChatGrupos(String nome){
       String res="[ ";
       int x = 0;
        for(int i = 0; i < this.gru.size();i++){
            for( ; x < this.gru.get(i).size();x++){
                 if(this.gru.get(i).get(x).getNome().equals(nome)){
                      res+= this.gru.get(i).get(x).getGrupo()+" ";
                 
                 
                 }
        }//vetor x
            x=0;
                 
        }//vetor i
        res+= "]";
        return res;
        
    }//
    
    //ver usuarios de um grupo/////////
    public void usuarioDoGrupo(String nomeGrupo){
       int x = 0;
        for(int i = 0; i < this.gru.size();i++){
            for( ; x < 1;x++){
                 if(this.gru.get(i).get(0).getGrupo().equals(nomeGrupo)){
                        System.out.println(this.gru.get(i));
                        break;
                 
                 }
        }//vetor x
            x=0;
                 
        }//vetor i
        System.out.println(" grupo nao existe");
       
        
    }//
    
    
    //cadastra usuario no chat
    public boolean entrarNoGrupo(String nome, String nomeNovo, String nomeGrupo){
        if(usuarioExiste(nomeNovo)){
            if(gruporRepetidoNome(nomeNovo, nomeGrupo)){
                System.out.println(" Usuario ja esta no grupo");
                return false;
            
            }
            
            int x = 0;
            for(int i = 0; i < this.gru.size();i++){
                for( ; x < this.gru.get(i).size();x++){  
                    if(this.gru.get(i).get(x).getNome().equals(nome) && this.gru.get(i).get(x).getGrupo().equals(nomeGrupo)){
                         Usuario p2 = new Usuario(nomeNovo, nomeGrupo);
                         this.gru.get(i).add(p2);
                         return true;


                     }
            }//vetor x
                x=0;

            }//vetor i
               System.out.println("  fail: user "+nome+ " nao esta em chat "+nomeGrupo);
               return false;
        }
        System.out.println(" usuario nao existe");
        return false;
    
      }//
    
    //nao repetir nome no mesmo grupo
    public boolean gruporRepetidoNome(String nomeNovo, String nomeGrupo){
        int x = 0;
        for(int i = 0; i < this.gru.size();i++){
            for( ; x < this.gru.get(i).size();x++){
                 if(this.gru.get(i).get(x).getNome().equals(nomeNovo) && this.gru.get(i).get(x).getGrupo().equals(nomeGrupo)){
                     return true;
                 
                 
                 }
        }//vetor x
            x=0;
                 
        }//vetor i
        return false;
        
    }//
    
    //apargar usuario do grupo
    public boolean apagarUsuarioDoGrupo(String nome, String nomeGrupo){
        int x = 0;
        for(int i = 0; i < this.gru.size();i++){
            for( ; x < this.gru.get(i).size();x++){
                 if(this.gru.get(i).get(x).getNome().equals(nome) && this.gru.get(i).get(x).getGrupo().equals(nomeGrupo)){
                     this.gru.get(i).remove(x);
                     return true;
                 
                 
                 }
        }//vetor x
            x=0;
                 
        }//vetor i
        return false;
        
    
    }//
    
    
    
    //mandar menssagem para um grupo especifico
    public void conversaGrupo(String nome, String nomeGrupo, String conversa){
        int x = 0;
        for(int i = 0; i < this.gru.size();i++){
            for( ; x < this.gru.get(i).size();x++){
                 if(this.gru.get(i).get(x).getNome().equals(nome) && this.gru.get(i).get(x).getGrupo().equals(nomeGrupo)){
                     this.gru.get(i).get(0).publicarMenssagem(nome,conversa);
                     
                 
                 
                 }
        }//vetor x
            x=0;
                 
        }//vetor i
    
    
    }//
    
    //lerm menssagem do grupo certo
     public void lerVetor(String nome, String nomeGrupo){
        int x = 0;
        for(int i = 0; i < this.gru.size();i++){
            for( ; x < this.gru.get(i).size();x++){
                 if(this.gru.get(i).get(x).getNome().equals(nome) && this.gru.get(i).get(x).getGrupo().equals(nomeGrupo)){
                     this.gru.get(i).get(0).lerMenssagemDoGrupo(nome,nomeGrupo);
                     
                 
                 
                 }
        }//vetor x
            x=0;
                 
        }//vetor i
    
    
    }//
     
      
     
    }//final
  
  
    

