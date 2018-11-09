package whatsapp;

import java.util.List;
import java.util.ArrayList;

public class WhatsApp {

    List<Usuario> usu = new ArrayList<>();

    //adisiona usuario 
    public boolean adiciona(String nome) {
        if (usuarioExiste(nome)) {
            return false;
        }
        Usuario p = new Usuario(nome);
        this.usu.add(p);
        return true;
    }

    //busca usuario se existe
    public boolean usuarioExiste(String nome) {
        for (int i = 0; i < this.usu.size(); i++) {
            if (this.usu.get(i).getNome().equals(nome)) {
                return true;

            }
        }
        return false;
    }

    //busca grupos repetidos///////////////
    public boolean gruporRepetido(String nomeGrupo) {
        int x = 0;
        for (int i = 0; i < this.usu.size(); i++) {
            for (; x < this.usu.get(i).grupo.size(); x++) {
                if (this.usu.get(i).grupo.get(x).getNomeGrupo().equals(nomeGrupo)) {
                    return true;

                }
            }//vetor x
            x = 0;
        }//vetor i
        return false;
    }// 

    public void show() {
        System.out.println(this.usu);
    }//

    //criar grupo nome do usuario e nome do grupo
    public boolean criarChet(String nome, String nomeGrupo) {
        if (gruporRepetido(nomeGrupo)) {
            System.out.println(" fail: chat " + nomeGrupo + " ja existe");
            return false;
        }

        for (int i = 0; i < this.usu.size(); i++) {
            if (this.usu.get(i).getNome().equals(nome)) {
                GruposVetor p = new GruposVetor(nomeGrupo, usu.get(i));
                this.usu.get(i).grupo.add(p);
                return true;
            }
        }
        System.out.println(" usuario nao existe");
        return false;
    }//

    //usuaruo saber quais grupos pertence
    public boolean ChatGrupos(String nome) {
        for (int i = 0; i < this.usu.size(); i++) {
            if (this.usu.get(i).getNome().equals(nome)) {
                System.out.println(this.usu.get(i).grupo);
                return true;
            }
        }
        System.out.println(" usuario nao existe");
        return false;
    }//

    //ver usuarios de um grupo/////////
    public boolean usuarioDoGrupo(String nomeGrupo) {
        int x = 0;
        for (int i = 0; i < this.usu.size(); i++) {
            for (; x < this.usu.get(i).grupo.size(); x++) {
                if (this.usu.get(i).grupo.get(x).getNomeGrupo().equals(nomeGrupo)) {
                    System.out.println(this.usu.get(i).grupo.get(x).usuarioCopia);
                    return true;

                }
            }//vetor x
            x = 0;

        }//vetor i
        System.out.println(" grupo nao existe");
        return false;

    }//

    //cadastra usuario no chat
    public boolean entrarNoGrupo(String nome, String nomeNovo, String nomeGrupo) {
        if (usuarioExiste(nome)) {
            int x = 0;
            int y = 0;
            for (int i = 0; i < this.usu.size(); i++) {
                for (; x < this.usu.get(i).grupo.size(); x++) {
                    for (; y < this.usu.get(i).grupo.get(x).usuarioCopia.size(); y++) {
                        if (this.usu.get(i).grupo.get(x).usuarioCopia.get(y).getNome().equals(nome) && this.usu.get(i).grupo.get(x).getNomeGrupo().equals(nomeGrupo)) {
                            if (this.usu.get(i).grupo.get(x).naoRepetirMensmoNome(nomeNovo)) {
                                System.out.println(" o usuario ja esta no grupo");
                                return false;
                            }
                            //pegar referencia do usuario
                            for (int j = 0; j < this.usu.size(); j++) {
                                if (this.usu.get(j).getNome().equals(nomeNovo)) {
                                    //joga o vetor de grupo, no vetor de grupo do adicionado
                                    this.usu.get(j).grupo.add(usu.get(i).grupo.get(x));
                                    //jogar no vertor do chat
                                    this.usu.get(i).grupo.get(x).usuarioCopia.add(usu.get(j));
                                    return true;

                                }
                            }///////
                            System.out.println(" usuario " + nomeNovo + " nao existe");
                            return false;

                        }
                    }//vetor y
                    y = 0;
                }//vetor x
                x = 0;
            }//vetor i
            System.out.println("  fail: user " + nome + " nao esta em chat " + nomeGrupo);
            return false;
        }
        System.out.println(" usuario nao existe");
        return false;

    }//

    //apargar usuario do grupo
    public boolean apagarUsuarioDoGrupo(String nome, String nomeGrupo) {
        if (usuarioExiste(nome)) {
            int x = 0;
            int y = 0;
            for (int i = 0; i < this.usu.size(); i++) {
                for (; x < this.usu.get(i).grupo.size(); x++) {
                    for (; y < this.usu.get(i).grupo.get(x).usuarioCopia.size(); y++) {
                        if (this.usu.get(i).grupo.get(x).usuarioCopia.get(y).getNome().equals(nome) && this.usu.get(i).grupo.get(x).getNomeGrupo().equals(nomeGrupo)) {
                                for (int j = 0; j < this.usu.size(); j++) {
                                    if (this.usu.get(j).getNome().equals(this.usu.get(i).grupo.get(x).usuarioCopia.get(y).getNome())) {
                                        this.usu.get(i).grupo.get(x).usuarioCopia.remove(y);
                                        this.usu.get(j).apagarGrupos(nomeGrupo);
                                           return true;
                                    }
                                }//
                            
                        }

                    }//vetor y
                    y = 0;
                }//vetor x
                x = 0;

            }//vetor i
        }
        return false;
    }//final metodo

    
    //mandar menssagem para um grupo especifico
    public boolean conversaGrupo(String nome, String nomeGrupo, String conversa){
       if(usuarioExiste(nome)) {
            int x = 0;
            for (int i = 0; i < this.usu.size(); i++) {
                for (; x < this.usu.get(i).grupo.size(); x++) {
                    if (this.usu.get(i).grupo.get(x).getNomeGrupo().equals(nomeGrupo)) {
                        this.usu.get(i).grupo.get(x).publicarMenssagem(nome, conversa);
                         return true;////////
                    }
                }//vetor x
                x = 0;

            }//vetor i
            return true;
       }
       System.out.println("usuario "+nome+" nao existe");
       return false;
    }//
    
    
    //ler menssagem do grupo certo
     public boolean lerVetor(String nome, String nomeGrupo){
            int x = 0;
            for (int i = 0; i < this.usu.size(); i++) {
                for (; x < this.usu.get(i).grupo.size(); x++) {
                    if (this.usu.get(i).getNome().equals(nome) && this.usu.get(i).grupo.get(x).getNomeGrupo().equals(nomeGrupo)) {
                        this.usu.get(i).grupo.get(x).lerMenssagem();
                        return true;

                    }
                }//vetor x
                x = 0;

            }//vetor i
            System.out.println(" fail: user "+nome+ " nao esta no chat "+ nomeGrupo);
            return false;
         
    }//
     
}//final

