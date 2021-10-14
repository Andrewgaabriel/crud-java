package fonte;


import java.util.LinkedHashMap;
import java.util.Map;


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
        clientes.put(cliente.getClientCode(), cliente);
        System.out.println("Cliente cadastrado com sucesso! ");
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
            bebidas.put(bebida.getCode(), bebida);
        } else {
            NaoAlcoolica bebida = new NaoAlcoolica(code, name, content, price, qntd);
            bebidas.put(bebida.getCode(), bebida);
        }

        System.out.println("Bebida cadastrada com sucesso! ");

    }


    /**
     * Printa bebidas cadastradas;
     * 
     */
    public void mostrarBebidas(){

        System.out.println("Bebidas cadastradas: ");

        for (String key : bebidas.keySet()) { //keySet = conjunto com todas as chaves de bebidas, key assume a cada passada uma delas

            Bebida bebidaAtual = bebidas.get(key);

            System.out.println("Codigo: " + bebidaAtual.getCode());
            System.out.println("Nome: " + bebidaAtual.getName());
            System.out.println("Conteudo(ML): " + bebidaAtual.getContent());
            System.out.println("Preco: R$" + bebidaAtual.getPrice());
            System.out.println("Quantidade em estoque: " + bebidaAtual.getStock());
        }
    }


    /**
     * Printa clientes cadastrados;
     * 
     */    
    public void mostrarClientes(){

        System.out.println("Clientes cadastrados: ");

        for (String key : clientes.keySet()) { //keySet = conjunto com todas as chaves de clientes, key assume a cada passada uma delas

            Cliente clienteAtual = clientes.get(key);

            System.out.println("Codigo: " + clienteAtual.getClientCode());
            System.out.println("Nome: " + clienteAtual.getClientName());
            System.out.println("CPF: " + clienteAtual.getClientCPF());
            System.out.println("Maior de 18: " + clienteAtual.getMaior18());
            System.out.println("Confiavel: " + clienteAtual.getpodeFiado());
        }

        System.out.println("Quantidade de Clientes cadastrados na Bodega: " + numClientes);
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
