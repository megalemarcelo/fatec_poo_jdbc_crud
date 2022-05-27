import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt;
public class Principal {
    public static void main(String[] args) {
        String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n0-Sair";

        int op = 0;
        do{
            try{
                op = Integer.parseInt(JOptionPane.showInputDialog(menu));
                    switch (op){
                        case 1:{
                            String nome = JOptionPane.showInputDialog("Digite o nome");
                            String fone = JOptionPane.showInputDialog("Digite o fone");
                            String email = JOptionPane.showInputDialog("Digite o e-mail");
                            Pessoa p = new Pessoa(nome, fone, email);
                            p.inserir();
                            JOptionPane.showMessageDialog(null, "Pessoa cadastrada");
                            break;
                        }
                        case 2:{
                            String nome = JOptionPane.showInputDialog("Digite o nome");
                            String fone = JOptionPane.showInputDialog("Digite o fone");
                            String email = JOptionPane.showInputDialog("Digite o e-mail");
                            int codigo = parseInt(JOptionPane.showInputDialog("Digite o código"));
                            Pessoa p = new Pessoa(codigo, nome, fone, email);
                            p.atualizar();
                            JOptionPane.showMessageDialog(null, "Pessoa atualizada");
                            break;
                        }
                        case 3:{
                            new Pessoa(
                                parseInt(JOptionPane.showInputDialog("Digite o código"))
                            ).apagar();
                            break;
                        }
                        case 4:
                            Pessoa.listar();
                            break;
                        case 0:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                }
            }
            catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Falhou...");
                    System.out.println(e.getMessage());
            }

        }while (op != 0);
   } 
}
