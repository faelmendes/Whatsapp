
package whatsapp;

public class Usuario {
  private String nome;
  private final String grupo;
  

    public Usuario(String nome, String grupo) {
        this.nome = nome;
        this.grupo = grupo;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrupo() {
        return grupo;
    }

   
    @Override
    public String toString() {
        String res="";
        res+= this.nome +" ";
        return res;
    }
    //dica do java 
    void publicarMenssagem(String nome, String conversa) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    //dica do java
    void lerMenssagemDoGrupo(String nome, String nomeGrupo) {
        throw new UnsupportedOperationException("Not supported yet.");
    } 
    
    
    
    
    
    
  
}
