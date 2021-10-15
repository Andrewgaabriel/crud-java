package fonte;


/* Classe para bebidas alcoolicas */

// Andrew Gabriel  (andrew.gabrielgomes@gmail.com)

public class Alcoolica extends Bebida{


    /**
     * Constructor
    * 
    * @param code
    * @param name
    * @param content
    * @param price
    * @param stock
    */
    public Alcoolica(String code, String name, int content, double price, int stock){
        this.code = code;
        this.name = name;
        this.content = content;
        this.price = price;
        this.stock = stock;
    }


    
    /**
     * Comprar bebidas
    * 
    * @param qnt de bebidas a ser comprada
    */
    public void compraBebida(int qnt) {
        this.stock += qnt;
    }



    /**
     * Vender bebidas
    * 
    * @param qnt de bebidas a ser vendidas;
    * @param maior18 ve se é + 18;
    */
    public void vendeBebida(int qnt, boolean maior18){


        if(maior18){
            if (qnt > this.stock) {

                System.out.println("Sem estoque! Restam " + this.stock + " unidades.");
                System.out.println("Refaca seu pedido !!!");
            
            } else {
    
                this.stock = this.stock - qnt;
                System.out.println("Compra efetuada com sucesso !!!");
                System.out.println("estoque atualizado! ");
            
            }
        } else {
            System.out.println("Venda recusada! Cliente é menor de idade!");
        }

        
    }

}
