package fonte;

/* Main da Bodega */

// Andrew Gabriel  (andrew.gabrielgomes@gmail.com)


import java.util.Scanner;
import java.io.File;
import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args) {

        int opcao = 1;
        Scanner scanner = new Scanner(System.in);
        Bodega bodega = new Bodega("Bodega Dois Irmaos", "89.888.888.88");

        File testeClientes = new File("clientes.txt");
        
        if (testeClientes.exists() && !testeClientes.isDirectory()){
            System.out.println("\n\n>>> Fazendo download de clientes...");
            bodega.downloadClientes();
        }

        File testeBebidas = new File("bebidas.txt");
        
        if (testeBebidas.exists() && !testeBebidas.isDirectory()){
            System.out.println("\n\n>>> Fazendo download de Bebidas...");
            bodega.downloadBebidas();
        }


        try {
            while(opcao != 10) {

                System.out.printf("\n===============         MENU         ===================\n");
                System.out.printf("|| 1 - Cadastrar bebida;                                ||\n");
                System.out.printf("|| 2 - Mostrar bebidas;                                 ||\n");
                System.out.printf("|| 3 - Comprar bebidas;                                 ||\n");
                System.out.printf("|| 4 - Vender bebidas;                                  ||\n");
                System.out.printf("|| 5 - Cadastrar cliente;                               ||\n");
                System.out.printf("|| 6 - Mostrar clientes;                                ||\n");
                System.out.printf("|| 7 - Fazer backup;                                    ||\n");
                System.out.printf("|| 10 - Finalizar sistema;                              ||\n");
                System.out.printf("==========================================================\n");
                System.out.print("> ");
    
                opcao = scanner.nextInt();
                scanner.nextLine();
    
                switch (opcao) {
    
                    case 1: /**CADASTRO DE BEBIDAS */
                        System.out.print("\n>> CADASTRO DE BEBIDA <<\n\n");
    
                        System.out.print("> Codigo da bebida: ");
                        String codigo1 = scanner.nextLine();
                    
                        System.out.print("> Nome da bebida: ");
                        String nome1 = scanner.nextLine();
    
                        System.out.print("> Conteudo da bebida (em ml): ");
                        int content1 = scanner.nextInt();
    
                        System.out.print("> Preco da bebida: ");
                        double price1 = scanner.nextDouble();
    
                        System.out.print("> Quantidade: ");
                        int qntd1 = scanner.nextInt();
    
                        System.out.print("> Alcoolica (1-sim  2-nao): ");
                        int alcoolica1 = scanner.nextInt();
                        
                        bodega.cadastraBebida(codigo1, nome1, content1, price1, qntd1, alcoolica1);
                        break;
    
                    case 2: /**IMPRIME BEBIDAS CADASTRADAS */
                        bodega.mostrarBebidas();
                        break;
    
                    case 3:/**COMPRA DE BEBIDAS PARA ESTOQUE */
                        System.out.print("\n\n>> COMPRA DE BEBIDA <<\n\n");
    
                        System.out.printf("> Codigo da bebida: ");
                        String code = scanner.nextLine();
    
                        System.out.printf("> Quantidade a ser comprada: ");
                        int qntd = scanner.nextInt();
    
                        if(!bodega.bebidas.containsKey(code)){//se nao existe essa bebida;
                            System.out.println("!! Bebida nao encontrada !! ");
                        } else {
                            bodega.bebidas.get(code).compraBebida(qntd);
                            System.out.println("\n\n>> Compra efetuada! Estoque atualizado com sucesso! <<\n\n");
                        }
                        break;
    
                    case 4: /**VENDA DE BEBIDAS PARA CLIENTE >> CADASTRADOS << */
                        if (bodega.clientes.isEmpty()){
                            System.out.println("\n\n!! Nao ha clientes cadastrados para efetuar uma venda !!");
                            System.out.println("!! Faca o cadastro e volte depois !!");
                            break;
                        }

                        System.out.print("\n\n>> VENDA DE BEBIDA <<\n\n");
    
                        System.out.print("> Codigo da bebida: ");
                        String codig = scanner.nextLine();
    
                        System.out.print("> Quantidade: ");
                        int qtd = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("> Codigo do cliente: ");
                        String cCod = scanner.nextLine();
    
                        if(!bodega.bebidas.containsKey(codig)){ //VERIFICA SE EXISTE ESSA BEBIDA NOS CADASTROS
                            System.out.print("\n\n!! Bebida nao encontrada !!\n\n");
                        } else {
                            System.out.print("> Valor da venda: R$ " + ((qtd)*(bodega.bebidas.get(codig).getPrice())));
                            bodega.bebidas.get(codig).vendeBebida(qtd, bodega.clientes.get(cCod).getMaior18());
                        }
                        break;
    
                    case 5:/**CADASTRO DE NOVOS CLIENTES */
                        System.out.print(">> CADASTRO DE CLIENTE <<\n\n");

                        System.out.print("> Codigo do cliente: ");
                        String codigo = scanner.nextLine();
    
                        System.out.print("> Nome do cliente: ");
                        String nome = scanner.nextLine();
    
                        System.out.print("> Idade do cliente: ");
                        int idade = scanner.nextInt();
    
                        scanner.nextLine();
                        System.out.print("> CPF do cliente: ");
                        String cpf = scanner.nextLine();
    
                        System.out.printf("> Confiavel? (1-sim  2-nao): ");
                        int fiado = scanner.nextInt();
                        
                        bodega.cadastraCliente(codigo, nome, idade, cpf, fiado);
                        break;

                    case 6:/**PRINTA CLIENTE CADASTRADOS */
                        bodega.mostrarClientes();
                        break;
    
                    case 7:/**EFETUA BACKUP DOS DADOS */
                        System.out.println(">>> Efetuando backup dos dados...");
                        bodega.uploadBebidas();
                        bodega.uploadClientes();
                        break;

                    case 10:/**FINALIZA SISTEMA */
                        System.out.println(">>> Finalizando.....");
                        System.out.println(">>> Ate mais...");
                        break;
                
                    default:
                        System.out.print("\n\n !! Opcao invalida !! \n\n");
                        break;
                }
            }

        } catch (InputMismatchException e) { /**TRATA ERRO DE VALOR DIGITADO INVALIDO */
            System.out.println("!! Valor digitado invalido !! \nFazendo backup...\nAbortando...");
            bodega.uploadBebidas();
            bodega.uploadClientes();
        }


        scanner.close();
    }
}