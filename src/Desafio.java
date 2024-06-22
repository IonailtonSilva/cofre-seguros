import java.util.Scanner;

abstract class Cofre {
    protected String tipo;
    protected String metodoAbertura;

    public Cofre(String tipo, String metodoAbertura) {
        this.tipo = tipo;
        this.metodoAbertura = metodoAbertura;
    }

    public void imprimirInformacoes() {
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Metodo de abertura: " + this.metodoAbertura);
    }
}

class CofreDigital extends Cofre {

    private int senha;

    public CofreDigital(int senha) {
        super("Cofre Digital", "Senha");
        this.senha = senha;
    }

    public boolean validarSenha(int confirmacaoSenha) {
        return confirmacaoSenha == this.senha;
    }
}

class CofreFisico extends Cofre {

    public CofreFisico() {
        super("Cofre Fisico", "Chave");
    }
}

public class Desafio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê o tipo de cofre
        System.out.println("Digite o tipo de cofre: ");
        String tipoCofre = scanner.nextLine();

        // Verifica o tipo de cofre
        if (tipoCofre.equals("digital")) {
            // Solicita e valida a senha
            int senhaDigitada = solicitarSenha(scanner);
            int confirmacaoSenhaDigitada = solicitarConfirmacaoSenha(scanner);

            if (senhaDigitada == confirmacaoSenhaDigitada) {
                // Cria e valida o cofre digital
                CofreDigital cofreDigital = new CofreDigital(senhaDigitada);
                cofreDigital.imprimirInformacoes();
                System.out.println("Cofre aberto!");

                // Imprime as informações do cofre
                
            } else {
                CofreDigital cofreDigital = new CofreDigital(senhaDigitada);
                cofreDigital.imprimirInformacoes();
                System.out.println("Senha incorreta!");
            }
        } else if (tipoCofre.equals("fisico")) {
            // Cria um cofre físico
            CofreFisico cofreFisico = new CofreFisico();

            // Imprime as informações do cofre
            cofreFisico.imprimirInformacoes();
        } else {
            System.out.println("Tipo de cofre inválido!");
        }
    }

    // Função para solicitar a senha
    private static int solicitarSenha(Scanner scanner) {
        System.out.println("Digite sua senha: ");
        while (!scanner.hasNextInt()) {
            System.out.println();
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Função para solicitar a confirmação da senha
    private static int solicitarConfirmacaoSenha(Scanner scanner) {
        System.out.println("Confirme sua senha: ");
        while (!scanner.hasNextInt()) {
            System.out.println();
            scanner.next();
        }
        return scanner.nextInt();
    }
}