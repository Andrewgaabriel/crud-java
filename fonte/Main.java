package fonte;


import java.util.Scanner;


public class Main {
    

    public static void main(String[] args) {
        int opcao = 1;
        Scanner scanner = new Scanner(System.in);
        Bodega bodega = new Bodega("Bodega Dois Irmaos", "89.888.888.88");



        while(opcao != 10) {

            System.out.printf("\n===============         MENU         ===================\n");
            System.out.printf("|| 1 - Cadastrar bebida;     ok                           ||\n");
            System.out.printf("|| 2 - Mostrar bebidas;        ok                         ||\n");
            System.out.printf("|| 3 - Comprar bebidas;           ok                      ||\n");
            System.out.printf("|| 4 - Vender bebidas;                                  ||\n");
            System.out.printf("|| 5 - Cadastrar cliente;    ok                           ||\n");
            System.out.printf("|| 6 - Mostrar clientes;    ok                            ||\n");
            System.out.printf("|| 7 - Salvar dados;                                    ||\n");
            System.out.printf("|| 10 - Finalizar sistema;                              ||\n");
            System.out.printf("==========================================================\n");
            System.out.printf(">");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println(">> CADASTRO DE BEBIDA:");
                    System.out.printf("Codigo da bebida:");
                    String codigo1 = scanner.nextLine();

                    System.out.printf("Nome da bebida:");
                    String nome1 = scanner.nextLine();

                    System.out.printf("Conteudo da bebida (em ml):");
                    int content1 = scanner.nextInt();

                    System.out.printf("Preco da bebida:");
                    double price1 = scanner.nextDouble();

                    System.out.printf("Quantidade:");
                    int qntd1 = scanner.nextInt();

                    System.out.printf("Alcoólica (1-sim  2-nao):");
                    int alcoolica1 = scanner.nextInt();
                    
                    bodega.cadastraBebida(codigo1, nome1, content1, price1, qntd1, alcoolica1);

                    break;
                case 2:
                    bodega.mostrarBebidas();
                    break;
                case 3:
                    System.out.println(">> COMPRA DE BEBIDA:");

                    System.out.printf("Codigo da bebida:");
                    String code = scanner.nextLine();

                    System.out.printf("Quantidade a ser comprada:");
                    int qntd = scanner.nextInt();

                    if(!bodega.bebidas.containsKey(code)){//se nao existe essa bebida;
                        System.out.println("Bebida nao encontrada !! ");
                    } else {
                        bodega.bebidas.get(code).compraBebida(qntd);
                    }

                    break;
                case 4:
                    
                    break;
                case 5:
                    System.out.println(">> CADASTRO DE CLIENTE:");
                    System.out.printf("Codigo do cliente:");
                    String codigo = scanner.nextLine();

                    System.out.printf("Nome do cliente:");
                    String nome = scanner.nextLine();

                    System.out.printf("Idade do cliente:");
                    int idade = scanner.nextInt();

                    System.out.printf("CPF do cliente:");
                    String cpf = scanner.nextLine();

                    System.out.printf("Confiavel (1-sim  2-nao):");
                    int fiado = scanner.nextInt();
                    
                    bodega.cadastraCliente(codigo, nome, idade, cpf, fiado);
                    break;
                case 6:
                    bodega.mostrarClientes();
                    break;
                case 7:
                    
                    break;
            
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

        }

        scanner.close();
    }

}
