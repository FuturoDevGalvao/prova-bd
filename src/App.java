import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        iniciar();
    }

    private static void iniciar() {
        System.out.println("### SISTEMA - SUPERMERCADO ###");
        String desicao = "";

        do {
            System.out
                    .println("\nInforme 1: Inserir \nInforme 2: Atualizar \nInforme 3: Deletar\nInforme 4: Consultar");

            System.out.print("\nInforme aqui: ");
            int acao = input.nextInt();
            executarAcao(acao);

            System.out.print("\nDeseja continuar [S] ou [N]? ");
            desicao = input.next();
        } while (desicao.equalsIgnoreCase("S"));
    }

    private static void executarAcao(int acao) {
        switch (acao) {
            case 1:
                conexaoProduto.inserir(getProduto());
                break;
            case 2:
                conexaoProduto.atualizar(getProduto());
                break;
            case 3:
                conexaoProduto.deletar(getProduto());
                break;
            case 4:
                showResult(conexaoProduto.consultar());
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ação inválida.");
                break;
        }
    }

    private static Produto getProduto() {
        System.out.println("\n<< Informe as informações referentes ao produto >>");
        System.out.print("\nInforme o id: ");
        int id = input.nextInt();
        System.out.print("Informe a descrição: ");
        String decricao = input.next();
        System.out.print("Informe a quantidade: ");
        int quantidade = input.nextInt();
        System.out.print("Informe o valor: ");
        double valor = input.nextDouble();

        return new Produto(id, decricao, quantidade, valor);
    }

    private static void showResult(ArrayList<Produto> produtos) {
        System.out.println("");

        produtos.forEach((produto) -> {
            System.out.println(produto);
        });
    }
}
