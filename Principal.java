
package whatsapp;
import java.util.Scanner;
public class Principal{
public static Scanner sc = new Scanner(System.in);
public static void main(String args[]){
WhatsApp zap = new WhatsApp();
String comando;
String help = "\t============= help =====================\n"+
                                           "\\zap:_nome_nomedoGrupo_menssagem pro grupo \" \n"+
                                           "\\ler :_nome_nomedoGrupo_: ler mensagen do grupo \n"+
                                           "\\adduser:_nome_: cria usuaruo e cadastra\n"+
                                           "\\newchat:_nome_nomedoGrupo_: cria um grupo unico \n"+
                                           "\\chats:_nome_: ver os grupo que o usuario esta \n"+
                                           "\\allusers: ver usuarios cadastrados   \n"+
					  "\\users:_nomeGrupo_: ver usuarios do grupo \n"+
                                           "\\deleta:_nome_nomedoGrupo_: apagar usuario do grupo \n"+
                                           "\\adiciona:_nome_nomeNovo_nomedoGrupo_: cadatra o usuario no grupo que esta o _nome_      \n"+
					  "\tend: sai do programa\n"+
					  "\t========================================\n";

while(true){

System.out.print("Digite um comando (help para ver os comandos) ");
comando = sc.nextLine();


         if(comando.equals("help")){
				System.out.println(help);
				
			 
        }else if(comando.equals("end")){
				break;
			}else{ 
		 

                String c[] = comando.split(" ");
                String c1[] = comando.split(" ");
                switch(c[0]){
                            case "zap":
                                        String menssagem = "";
                                         for(int i = 3;i < c1.length;i++){
                                            menssagem += " "+c1[i];
                                         }
                                         if( zap.conversaGrupo(c[1], c[2],menssagem)){
                                               System.out.println(" Done");

                                            }
                                       
                                    break;
                            case "ler":
                                      
                                         zap.lerVetor(c[1], c[2]);
                                        
                                    break;
                            case "adduser":
                                      
                                            if(zap.adiciona(c[1])){
                                               System.out.println(" Done");

                                            }else{System.out.println(" usuario "+c[1]+" ja esta cadastrado");}
                                         
                                    break;
                            case "newchat":
                                        
                                           if(zap.criarChet(c[1],c[2])){
                                             System.out.println(" Done");
                                            }
                                           
                                    break;
                             case "chats":
                                            zap.ChatGrupos(c[1]);
                                       
                                  

                                    break;
                            case "allusers":

                                           zap.show();
                                  

                                    break;
                             case "users":
                                          zap.usuarioDoGrupo(c[1]);
                                         
                                         
                                    break;
                             case "deleta":
                                    
                                           if(zap.apagarUsuarioDoGrupo(c[1], c[2])){
                                                System.out.println(" Done");
                                           }else{
                                               System.out.println("usuario "+c[1]+" nao esta nesse grupo");
                                           }
                                          
                                         
                                    break;
                            case "adiciona":
                                          
                                          if(zap.entrarNoGrupo(c[1], c[2], c[3])){
                                                System.out.println(" Done");
                                          }
                                  
                                          
                                    break;
                            default:

                                    System.out.println("  Comando inválido.");

                            }
            }


}










}
}



	    