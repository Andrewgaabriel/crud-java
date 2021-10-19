package fonte;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;
import java.io.*;


/* Dados gerais da Bodega */

// Andrew Gabriel  (andrew.gabrielgomes@gmail.com)


class Bodega {
    
    private String name;
    private String Cnpj;
    private int numClientes;
    public Map<String, Bebida> bebidas; //Struct para guardar as bebidas
    public Map<String, Cliente> clientes; //Struct para guardar os clientes
    

/**
 * Construtor
 * 
 * @param name -> nome da bodega
 * @param CNPJ -> CNPJ da bodega
 */
    public Bodega(String name, String CNPJ){
        this.name = name;
        this.Cnpj = CNPJ;
        this.numClientes = 0;
        this.bebidas = new LinkedHashMap<>();
        this.clientes = new LinkedHashMap<>();
    }


    /**
     * Cadastra um novo cliente;
     * 
     * @param code -> Codigo do cliente;
     * @param name -> Nome do cliente;
     * @param age -> Idade do cliente;
     * @param cpf -> Cpf do cliente;
     * @param fiado -> Cliente é confiável?
     */
    public void cadastraCliente(String code, String name, int age, String cpf, int fiado){
        boolean podeFiado, maior18;


        if (age > 18){
            maior18 = true; 
        } else {
            maior18 = false;
        }

        if(fiado == 1){
            podeFiado = true;
        } else {
            podeFiado = false;
        }

        Cliente cliente = new Cliente(name, code, cpf, maior18, podeFiado);
        this.clientes.put(cliente.getClientCode(), cliente);
        System.out.print("\n\n >> Cliente cadastrado com sucesso! <<\n\n");
        this.numClientes+=1;

    }


    /**
     * Cadastro de bebida;
     * 
     * @param code -> Código da bebida;
     * @param name -> Nome da bebida;
     * @param content -> Conteúdo em ML da bebida;
     * @param price -> Preço da bebida;
     * @param qntd -> Quantidade da bebida;
     * @param eAlcoolica -> A bebida é alcoólica?
     */
    public void cadastraBebida(String code, String name, int content, double price, int qntd, int eAlcoolica){
        boolean alcoolica;
        
        if (eAlcoolica == 1) {
            alcoolica = true;
        } else {
            alcoolica = false;
        }

        if (alcoolica) {
            Alcoolica bebida = new Alcoolica(code, name, content, price, qntd);
            this.bebidas.put(bebida.getCode(), bebida);
        } else {
            NaoAlcoolica bebida = new NaoAlcoolica(code, name, content, price, qntd);
            this.bebidas.put(bebida.getCode(), bebida);
        }

        System.out.println("\n\n>> Bebida cadastrada com sucesso! ");

    }


    /**
     * Printa bebidas cadastradas;
     * 
     */
    public void mostrarBebidas(){

        System.out.println("\n\n>> Bebidas cadastradas: \n");

        for (String key : bebidas.keySet()) { //keySet = conjunto com todas as chaves de bebidas, key assume a cada passada uma delas

            Bebida bebidaAtual = bebidas.get(key); //polimorfismo (bebida/alcoolica/naoalcoolica)
            System.out.println("--------------------------------------------");
            System.out.println("Codigo: " + bebidaAtual.getCode());
            System.out.println("Nome: " + bebidaAtual.getName());
            System.out.println("Conteudo(ML): " + bebidaAtual.getContent());
            System.out.println("Preco: R$" + bebidaAtual.getPrice());
            System.out.println("Quantidade em estoque: " + bebidaAtual.getStock());
            System.out.println("Alcoolica: " + bebidaAtual.getisAlcool());
            System.out.println("--------------------------------------------");
        }
    }


    /**
     * Printa clientes cadastrados;
     * 
     */    
    public void mostrarClientes(){

        System.out.println("\n\n>> Clientes cadastrados: \n");

        for (String key : clientes.keySet()) { //keySet = conjunto com todas as chaves de clientes, key assume a cada passada uma delas

            Cliente clienteAtual = clientes.get(key);
            System.out.println("--------------------------------------------");
            System.out.println("Codigo: " + clienteAtual.getClientCode());
            System.out.println("Nome: " + clienteAtual.getClientName());
            System.out.println("CPF: " + clienteAtual.getClientCPF());
            System.out.println("Maior de 18: " + clienteAtual.getMaior18());
            System.out.println("Confiavel: " + clienteAtual.getpodeFiado());
            System.out.println("--------------------------------------------");
        }

        System.out.println(">> Temos um total de " + numClientes + " clientes cadastrados.");
    }


    public void uploadClientes() {

        File dir = new File("C:\\super_Bodega");
        //Cria um novo arquivo
        File arq = new File(dir, "clientes.txt");

        try {
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
          
            for (Cliente client : this.clientes.values()) {
                printWriter.print(client.getClientName() + ";");
                printWriter.print(client.getClientCode() + ";");
                printWriter.print(client.getClientCPF() + ";");
                printWriter.print(client.getMaior18() + ";");
                printWriter.println(client.getpodeFiado());
            }

            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }



    public void uploadBebidas() {

        File dir = new File("C:\\super_Bodega");
        //Cria um novo arquivo
        File arq = new File(dir, "bebidas.txt");

        try {
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
          
            for (Bebida bebida : this.bebidas.values()) {
                printWriter.print(bebida.getCode() + ";");
                printWriter.print(bebida.getName() + ";");
                printWriter.print(bebida.getContent() + ";");
                printWriter.print(bebida.getPrice() + ";");
                printWriter.print(bebida.getStock() + ";");
                printWriter.println(bebida.getisAlcool());
            }

            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void downloadClientes() {

        File dir = new File("C:\\super_Bodega");
        //Cria um novo arquivo
        File arq = new File(dir, "clientes.txt");

        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = "";

            //Lista que irá guardar o resultado, ou seja,
            // cada linha do arquivo que corresponde a um User

            //this.bebidas

            List result = new ArrayList();

            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
                if (linha != null && !linha.isEmpty()) {
                    //this.clientes.put(linha);
                    result.add(linha);
                }
            }
            fileReader.close();
            bufferedReader.close();

            for (String s : result) {
                //Usei o método split da classe String
                //para separar as partes entre os ponto e vírgulas.
                //Guardamos o resultado em um array
                String[] client = s.split(";");

                //Criamos um objeto Bebida e setamos em seus atributos
                //as posições correspondentes do array
                Cliente u = new Cliente();



                u.setClientName(client[0]);
                u.setClientCode(client[1]);
                u.setClientCPF(client[2]);
                u.setMaior18(Boolean.valueOf(client[3]));
                u.setpodeFiado(Boolean.valueOf(client[4]));

                this.clientes.put(u.getClientCode(), u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    public void downloadBebidas() {

        File dir = new File("C:\\super_Bodega");
        //Cria um novo arquivo
        File arq = new File(dir, "bebidas.txt");

        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = "";

            //Lista que irá guardar o resultado, ou seja,
            // cada linha do arquivo que corresponde a um User

            //this.bebidas

            List result = new ArrayList();

            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
                if (linha != null && !linha.isEmpty()) {
                    //this.bebidas.put(linha);
                    result.add(linha);
                }
            }
            fileReader.close();
            bufferedReader.close();

            for (String s : result) {
                //Usei o método split da classe String
                //para separar as partes entre os ponto e vírgulas.
                //Guardamos o resultado em um array
                String[] bebida = s.split(";");

                //Criamos um objeto Bebida e setamos em seus atributos
                //as posições correspondentes do array
                Bebida u = new Bebida();
                u.setCode(bebida[0]);
                u.setName(bebida[1]);
                u.setContent(Integer.valueOf(bebida[2]));
                u.setPrice(Double.valueOf(bebida[3]));
                u.setStock(Integer.valueOf(bebida[4]));
                u.setisAlcool(Boolean.valueOf(bebida[5]));

                this.bebidas.put(u.getCode(), u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    /**
     * Getter
     * 
     * @return -> name of Bodega;
     */
    public String getName() {
        return this.name;
    }


    /**
     * Setter
     * 
     * -> Set name of Bodega;
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Getter
     * 
     * @return -> CNPJ of Bodega;
     */
    public String getCnpj() {
        return this.Cnpj;
    }


    /**
     * Setter
     * 
     * -> Set CNPJ of Bodega;
     */    
    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }
}
